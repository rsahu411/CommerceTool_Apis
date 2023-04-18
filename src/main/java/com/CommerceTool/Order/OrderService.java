package com.CommerceTool.Order;

import com.CommerceTool.DataProvider.DataProvider;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.common.BaseAddress;
import com.commercetools.api.models.order.*;
import com.commercetools.api.models.payment.PaymentResourceIdentifier;
import com.commercetools.api.models.state.StateResourceIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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




    // Add Delivery
    public Order addDelivery(OrderDetails orderDetails, String id)
    {
        Order order = apiRoot.orders().withId(id).get().executeBlocking().getBody();

        List<DeliveryItem> deliveryItems = orderDetails.getItems()
                .stream()
                .map( lineItem -> {
                    return DeliveryItem
                            .builder()
                            .id(lineItem.getId())
                            .quantity(lineItem.getQuantity())
                            .build();
                        }

                )
                .collect(Collectors.toList());

        List<ParcelDraft> parcelDrafts = orderDetails.getParcels()
                .stream()
                .map( parcelDetails -> {
                    return ParcelDraft
                            .builder()
                            .measurements(ParcelMeasurements
                                    .builder()
                                    .lengthInMillimeter(parcelDetails.getLengthInMillimeter())
                                    .widthInMillimeter(parcelDetails.getWidthInMilliMeter())
                                    .heightInMillimeter(parcelDetails.getHeightInMillimeter())
                                    .weightInGram(parcelDetails.getWeightInGram())
                                    .build())
                            .trackingData(TrackingData
                                    .builder()
                                    .trackingId(parcelDetails.getTrackingId())
                                    .carrier(parcelDetails.getCarrier())
                                    .provider(parcelDetails.getProvider())
                                    .providerTransaction(parcelDetails.getProviderTransaction())
                                    .isReturn(parcelDetails.isReturn())
                                    .build())
                         //   .items(deliveryItems)
                            .build();
                        }

                )
                .collect(Collectors.toList());

        OrderUpdate orderUpdate = OrderUpdate
                .builder()
                .version(order.getVersion())
                .actions(OrderUpdateAction
                        .addDeliveryBuilder()
                        .items(deliveryItems)
                        .parcels(parcelDrafts)
                        .address(BaseAddress
                                .builder()
                                .key(orderDetails.getKey())
                                .title(orderDetails.getTitle())
                                .salutation(orderDetails.getSalutation())
                                .firstName(orderDetails.getFirstName())
                                .lastName(orderDetails.getLastName())
                                .streetNumber(orderDetails.getStreetNumber())
                                .streetName(orderDetails.getStreetName())
                                .postalCode(orderDetails.getPostalCode())
                                .region(orderDetails.getRegion())
                                .city(orderDetails.getCity())
                                .state(orderDetails.getState())
                                .country(orderDetails.getCountry())
                                .build()

                        )
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




    // Remove Delivery
    public Order removeDelivery(OrderDetails orderDetails,String id)
    {
        Order order = apiRoot.orders().withId(id).get().executeBlocking().getBody();

        OrderUpdate orderUpdate = OrderUpdate
                .builder()
                .version(order.getVersion())
                .actions(OrderUpdateAction
                        .removeDeliveryBuilder()
                        .deliveryId(orderDetails.getDeliveryId())
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




    // Add Payment in Order
    public Order addPayment(OrderDetails orderDetails,String id)
    {
        Order order = apiRoot.orders().withId(id).get().executeBlocking().getBody();

        OrderUpdate orderUpdate = OrderUpdate
                .builder()
                .version(order.getVersion())
                .actions(OrderUpdateAction
                        .addPaymentBuilder()
                        .payment(PaymentResourceIdentifier
                                .builder()
                                .id(orderDetails.getPaymentId())
                                .build()
                        )
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



    // Remove Payment in Order
    public Order removePayment(OrderDetails orderDetails,String id)
    {
        Order order = apiRoot.orders().withId(id).get().executeBlocking().getBody();

        OrderUpdate orderUpdate = OrderUpdate
                .builder()
                .version(order.getVersion())
                .actions(OrderUpdateAction
                        .removePaymentBuilder()
                        .payment(PaymentResourceIdentifier
                                .builder()
                                .id(orderDetails.getPaymentId())
                                .build()
                        )
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
