package com.CommerceTool.CustomType;

import com.CommerceTool.Customer.CustomerDetails;
import com.commercetools.api.models.type.Type;
import com.commercetools.api.models.type.TypePagedQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/custom-types")
public class CustomTypeController {


    @Autowired
    private CustomTypeService service;

    //Create Custom-Type
    @PostMapping
    public Type createCustomType(@RequestBody CustomTypeDetails customTypeDetails)
    {
        return service.createCustomType(customTypeDetails);
    }



    @PostMapping("/updates/{id}")
    public Type updateCustomType(@RequestBody CustomTypeDetails customTypeDetails,@PathVariable String id)
    {
        return service.updateCustomType(customTypeDetails,id);
    }




    // Get All Custom-Type
    @GetMapping
    public TypePagedQueryResponse getAllCustomType(@RequestParam String Limit)
    {
        return service.getAllCustomType(Limit);
    }




    // Get Custom-Type By id
    @GetMapping("/{id}")
    public Type getCustomTypeById(@PathVariable String id)
    {
        return service.getCustomTypeById(id);
    }




    // Delete Custom-Type
    @DeleteMapping("/{id}")
    public Type deleteCustomType(@PathVariable String id,@RequestParam(required = false,defaultValue = "1") long version)
    {
        return service.deleteCustomType(id,version);
    }
}
