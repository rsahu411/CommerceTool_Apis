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


    // Get All Orders
    @GetMapping
    public OrderPagedQueryResponse getAllOrders()
    {
        return service.gatAllOrder();
    }


    // Add TransitionState
    @PostMapping("/states/{orderId}")
    public Order AddTransitionState(@RequestBody OrderDetails orderDetails, @PathVariable String orderId)
    {
        return service.AddTransitionState(orderDetails,orderId);
    }


   // Add delivery
    @PostMapping("/add-delivery/{orderId}")
    public Order AddDelivery(@RequestBody OrderDetails orderDetails, @PathVariable String orderId)
    {
        return service.addDelivery(orderDetails,orderId);
    }



    // Remove Delivery
    @PostMapping("/remove-delivery/{orderId}")
    public Order removeDelivery(@RequestBody OrderDetails orderDetails,@PathVariable String orderId)
    {
        return service.removeDelivery(orderDetails,orderId);
    }



    // Add Payment
    @PostMapping("/add-payment/{orderId}")
    public Order addPayment(@RequestBody OrderDetails orderDetails,@PathVariable String orderId)
    {
        return service.addPayment(orderDetails,orderId);
    }


    // Remove Payment
    @PostMapping("/remove-payment/{orderId}")
    public Order removePayment(@RequestBody OrderDetails orderDetails,@PathVariable String orderId)
    {
        return service.removePayment(orderDetails,orderId);
    }

}
