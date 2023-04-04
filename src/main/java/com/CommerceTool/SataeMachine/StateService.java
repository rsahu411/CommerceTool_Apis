package com.CommerceTool.SataeMachine;

import com.CommerceTool.DataProvider.DataProvider;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.state.State;
import com.commercetools.api.models.state.StateDraft;
import com.commercetools.api.models.state.StatePagedQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                .name(LocalizedString.ofEnglish(stateDetails.getName()))
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
}
