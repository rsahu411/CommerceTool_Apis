package com.CommerceTool.Order;

import com.commercetools.api.models.order.*;
import com.commercetools.api.models.state.StateResourceIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    // Create Order
    @PostMapping
    public Order createOrder(@RequestBody OrderDetails orderDetails)
    {
        return  service.createOrder(orderDetails);
    }


    @GetMapping
    public OrderPagedQueryResponse getAllOrders()
    {
        return service.gatAllOrder();
    }


    @PostMapping("/states/{OrderId}")
    public Order AddTransitionState(@RequestBody OrderDetails orderDetails, @PathVariable String orderId)
    {
        return service.AddTransitionState(orderDetails,orderId);
    }

}
