package com.CommerceTool.Cart;

import com.commercetools.api.models.cart.Cart;
import com.commercetools.api.models.cart.CartDraft;
import com.commercetools.api.models.cart.CartPagedQueryResponse;
import com.commercetools.api.models.cart.LineItem;
import com.commercetools.api.models.product.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/carts")
public class CartController {
    @Autowired
    CartService service;
    //create cart
    @PostMapping
    public Cart createCart(@RequestBody CartDetails cartDetails)
    {
       return service.createCart(cartDetails);
    }

    @GetMapping
    public CartPagedQueryResponse getAllCarts(@RequestParam String Limit)
    {
        return service.getAllCarts(Limit);
    }


//    @PostMapping("/{Id}")
//    public Cart updatedCart(@RequestBody CartDetails cartDetails, @PathVariable String Id)
//    {
//        return service.updateCart(cartDetails,Id);
//    }

    @GetMapping("/{Id}")
    public Product getCartById(@PathVariable String Id)
    {
        return service.getCartById(Id);
    }

    @GetMapping("/quantity/{id}")
    public long getQuantity(@PathVariable String id)
    {
        return service.getQuantity(id);
    }

    @GetMapping("/customer-id={customerId}")
    public Cart gtCartByCustomerId(@PathVariable String customerId)
    {
        return service.GetCartByCustomerId(customerId);
    }


    @DeleteMapping("/{Id}")
    public Cart deleteCartById(@PathVariable String Id,@RequestParam(required = false, defaultValue="1L") long version)
    {
        return service.deleteCartById(Id,version);
    }


    @PostMapping("/addShippingAddress/{id}")
    public  Cart addShippingAddress(@RequestBody CartDetails cartDetails, @PathVariable String id)
    {
        return service.addShippingAddress(cartDetails,id);
    }


    @PostMapping("/addLineItem/{id}")
    public  Cart addLineItem(@RequestBody CartDetails cartDetails, @PathVariable String id)
    {
        return service.addLineItem(cartDetails,id);
    }


    @GetMapping("/orders/{Id}")
    public Product getProductByOrderId(@PathVariable String Id)
    {
        return service.getProductByOrderId(Id);
    }
}
