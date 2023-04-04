package com.CommerceTool.SataeMachine;

import com.commercetools.api.models.state.State;
import com.commercetools.api.models.state.StatePagedQueryResponse;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/states")
public class StateControl {

    @Autowired
    StateService service ;

    @PostMapping
    public State createState(@RequestBody StateDetails stateDetails)
    {
        return service.createState(stateDetails);
    }

    @GetMapping
    public StatePagedQueryResponse getAllState()
    {
        return service.getAllSate();
    }

    @DeleteMapping("/{stateId}")
    public void deleteState(@PathVariable String stateId, @RequestParam(required = true,defaultValue = "1L") long version)
    {
        service.deleteState(stateId,version);
    }
}
