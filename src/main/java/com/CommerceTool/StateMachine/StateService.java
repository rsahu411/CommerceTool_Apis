package com.CommerceTool.StateMachine;

import com.CommerceTool.DataProvider.DataProvider;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.state.*;
import com.commercetools.api.models.state.StateRoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateService {

    DataProvider cdp = new DataProvider();

    @Autowired
    ProjectApiRoot apiRoot;


    public State createState(StateDetails stateDetails)
    {


        StateDraft stateDraft = StateDraft
                .builder()
                .key(stateDetails.getKey())
                .type(stateDetails.getType())
             //   .name(LocalizedString.ofEnglish(stateDetails.getName()))
                .roles(stateDetails.getRoles())
                .initial(stateDetails.isInitial())
                .build();

        return cdp.createState(stateDraft);
    }



    public StatePagedQueryResponse getAllSate() {

        StatePagedQueryResponse state = apiRoot
                .states()
                .get()
                .executeBlocking()
                .getBody();

        return state;
    }


    public void deleteState(String stateId,long version)
    {
        State state = apiRoot
                .states()
                .withId(stateId)
                .delete(version)
                .executeBlocking()
                .getBody();

    }



    // Set Transitions
    public State setTransition(StateDetails stateDetails,String id)
    {
        State state = apiRoot.states().withId(id).get().executeBlocking().getBody();

        StateUpdate stateUpdate = StateUpdate
                .builder()
                .version(state.getVersion())
                .actions(StateUpdateAction.setTransitionsBuilder()
                        .transitions(stateDetails.getTransitions())
                        .build())
                .build();

        State updatedState = apiRoot
                .states()
                .withId(state.getId())
                .post(stateUpdate)
                .executeBlocking()
                .getBody();
        return updatedState;
    }


}
