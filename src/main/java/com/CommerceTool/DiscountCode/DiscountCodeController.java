package com.CommerceTool.DiscountCode;

import com.commercetools.api.models.discount_code.DiscountCode;
import com.commercetools.api.models.discount_code.DiscountCodePagedQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discount-codes")
public class DiscountCodeController {

    @Autowired
    DiscountCodeService service;

    @PostMapping
    public DiscountCode createDiscountCode(@RequestBody DiscountCodeDetails discountCodeDetails)
    {
        return service.createDiscountCode(discountCodeDetails);
    }


    @GetMapping
    public DiscountCodePagedQueryResponse getAllDiscountCode(@RequestParam String Limit)
    {
        return service.getAllDiscountCode(Limit);
    }


    @GetMapping("/{id}")
    public DiscountCode getDiscountCodeById(@PathVariable String id)
    {
        return service.getDiscountCodeById(id);
    }


    @DeleteMapping("/{id}")
    public DiscountCode deleteDiscountCodeById(@PathVariable String id,@RequestParam(required = false, defaultValue="1L") long Version)
    {
        return service.deleteDiscountCodeById(id,Version);
    }
}
