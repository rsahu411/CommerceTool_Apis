package com.CommerceTool.Order;

import com.CommerceTool.DataProvider.DataProvider;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.order.*;
import com.commercetools.api.models.state.StateResourceIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

   @Autowired
    ProjectApiRoot apiRoot;

    DataProvider cdp = new DataProvider();


    // Create Order
    public Order createOrder(OrderDetails orderDetails)
    {
        OrderFromCartDraft order = OrderFromCartDraft
                .builder()
                .id(orderDetails.getCartId())
                .version(orderDetails.getVersion())
                .orderNumber(orderDetails.getOrderNumber())
                .build();

        return cdp.createOrder(order);
    }



    // Get All Order
    public OrderPagedQueryResponse gatAllOrder()
    {
        OrderPagedQueryResponse orders = apiRoot
                .orders()
                .get()
                .executeBlocking()
                .getBody();
        return orders;
    }



    public Order AddTransitionState(OrderDetails orderDetails,String orderId)
    {
        Order order = apiRoot.orders().withId(orderId).get().executeBlocking().getBody();
        OrderUpdate orderUpdate = OrderUpdate
                .builder()
                .version(order.getVersion())
                .actions(OrderUpdateAction.transitionStateBuilder()
                        .state(StateResourceIdentifier
                                .builder()
                                .id(orderDetails.getStateId())
                                .build())
                        .build())
                .build();

        Order updatedOrder = apiRoot
                .orders()
                .withId(order.getId())
                .post(orderUpdate)
                .executeBlocking()
                .getBody();

        return  updatedOrder;

    }
}
