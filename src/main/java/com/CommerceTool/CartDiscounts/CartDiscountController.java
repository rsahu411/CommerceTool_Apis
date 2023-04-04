package com.CommerceTool.CartDiscounts;

import com.CommerceTool.DiscountCode.CartDiscountVariable;
import com.commercetools.api.models.cart_discount.CartDiscount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart-discounts")
public class CartDiscountController {
    @Autowired
    CartDiscountService service;

    @PostMapping
    public CartDiscount createCartDiscount(@RequestBody CartDiscountDetails cartDiscountDetails)
    {
        return service.createCartDiscount(cartDiscountDetails);
    }
}
