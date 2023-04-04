package com.CommerceTool.SataeMachine;

import com.commercetools.api.models.state.StateTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateDetails {


    private String key;
    private StateTypeEnum type;
    private String name;
    private boolean initial;

}
