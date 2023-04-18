package com.CommerceTool.StateMachine;

import com.commercetools.api.models.state.StateResourceIdentifier;
import com.commercetools.api.models.state.StateRoleEnum;
import com.commercetools.api.models.state.StateTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StateDetails {


    private String key;
    private StateTypeEnum type;
    private String name;
    List<StateRoleEnum> roles;
    List<StateResourceIdentifier> transitions;
    private boolean initial;

}
