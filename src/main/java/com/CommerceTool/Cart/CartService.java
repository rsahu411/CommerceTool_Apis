package com.CommerceTool.Cart;

import com.CommerceTool.DataProvider.DataProvider;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.cart.*;
import com.commercetools.api.models.channel.ChannelResourceIdentifierBuilder;
import com.commercetools.api.models.common.BaseAddress;
import com.commercetools.api.models.order.Order;
import com.commercetools.api.models.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    ProjectApiRoot apiRoot;
    DataProvider cdp = new DataProvider();


    public Cart createCart(CartDetails cartDetails) {

//        List<LineItemDraft> lineItemList = cartDetails
//                .getLineItemDetails()
//                .stream()
//                .map(item -> {
//                 return    LineItemDraft
//                         .builder()
//                         .sku(item.getSku())
//                         .quantity(item.getQuantity())
//                         .build();
//                }).collect(Collectors.toList());

                CartDraft cart = CartDraft
                        .builder()
                        .key(cartDetails.getKey())
                        .customerId(cartDetails.getCustomerId())
                        .customerEmail(cartDetails.getEmail())
                        .currency(cartDetails.getCurrency())
                        .taxMode(cartDetails.getTaxMode())
                        .origin(CartOrigin.CUSTOMER)
                        .build();

        return  cdp.createCart(cart);
    }



    // Update Add Line Item in Cart
    public Cart addLineItem(CartDetails cartDetails,String id)
    {
        Cart cart = apiRoot.carts().withId(id).get().executeBlocking().getBody();


        CartUpdate cartUpdate = CartUpdate
                .builder()
                .version(cart.getVersion())
                .actions(CartUpdateActionBuilder
                        .of()
                        .addLineItemBuilder()
                        .productId(cartDetails.getProductId())
                        .variantId(cartDetails.getVariantId())
                        .quantity(cartDetails.getQuantity())
                        .supplyChannel(ChannelResourceIdentifierBuilder.of().id(cartDetails.getSupplyId()).build())
                        .distributionChannel(ChannelResourceIdentifierBuilder.of().id(cartDetails.getDistributionId()).build())
                        .build())

                .build();

        Cart updatedCart = apiRoot
                .carts()
                .withId(cart.getId())
                .post(cartUpdate)
                .executeBlocking()
                .getBody();
        return updatedCart;
    }




    // Add Custom LineItem in Cart
//    public Cart updateCartAddCustomLineItem(CartDetails cartDetails, String id)
//    {
//        Cart cart =  apiRoot.carts().withId(id).get().executeBlocking().getBody();
//
//        CartUpdate cartUpdate = CartUpdate
//                .builder()
//                .actions(CartUpdateActionBuilder.of().addCustomLineItemBuilder()
//                        .name(cartDetails.getCustomFieldName())
//                        .quantity(cartDetails.getQuantity())
//                        .build())
//
//    }






    // Add Shipping Address in Cart
    public Cart addShippingAddress(CartDetails cartDetails,String cartId)
    {
        Cart cart = apiRoot.carts().withId(cartId).get().executeBlocking().getBody();

        CartUpdate cartUpdate = CartUpdate
                .builder()
                .version(cart.getVersion())
                .actions(CartUpdateActionBuilder.of().setShippingAddressBuilder()
                        .address(BaseAddress.builder()
                                .title(cartDetails.getTitle())
                                .salutation(cartDetails.getSalutation())
                                .firstName(cartDetails.getFirstName())
                                .lastName(cartDetails.getLastName())
                                .streetNumber(cartDetails.getStreetNumber())
                                .streetName(cartDetails.getStreetName())
                                .postalCode(cartDetails.getPostalCode())
                                .city(cartDetails.getCity())
                                .region(cartDetails.getRegion())
                                .state(cartDetails.getState())
                                .country(cartDetails.getCountry())
                                .pOBox(cartDetails.getPOBox())
                                .key(cartDetails.getKey())
                                .build())
                        .build())
                .build();

        Cart updatedCart = apiRoot
                .carts()
                .withId(cart.getId())
                .post(cartUpdate)
                .executeBlocking()
                .getBody();
        return updatedCart;
    }




    // Get All Carts
    public CartPagedQueryResponse getAllCarts(String limit) {


        CartPagedQueryResponse queryResponse = apiRoot
                .carts()
                .get()
                .withLimit(limit)
                .executeBlocking()
                .getBody();
        return queryResponse;
    }



    // Get Cart By Id
    public Product getCartById(String id) {

        Cart cart = apiRoot
                .carts()
                .withId(id)
                .get()
                .executeBlocking()
                .getBody();
        String id1 = cart.getLineItems().get(0).getProductId();
        Product product = apiRoot.products().withId(id1).get().executeBlocking().getBody();
        return product;
    }




    // Get Cart By CustomerId
    public Cart GetCartByCustomerId(String customerId)
    {
        Cart cart = apiRoot
                .carts()
                .withCustomerId(customerId)
                .get()
                .executeBlocking()
                .getBody();

        return cart;
    }



    // Delete Cart By Id
    public Cart deleteCartById(String id,long version) {

        Cart cart = apiRoot
                .carts()
                .withId(id)
                .delete(version)
                .executeBlocking()
                .getBody();
        return cart;

    }



    // Get Quantity
    public long getQuantity(String id) {

        Cart cart=apiRoot.carts().withId(id).get().executeBlocking().getBody();
        long quantity=cart.get().getLineItems().get(0).getQuantity();
        return quantity;

    }

    public Product getProductByOrderId(String orderId)
    {
        Order order =apiRoot.orders().withId(orderId).get().executeBlocking().getBody();
        String productId = order.getLineItems().get(0).getProductId();
        System.out.println(productId);
        Product product = apiRoot.products().withId(productId).get().executeBlocking().getBody();
        return product;
    }


//    public Order test()
//    {
//        OrderFromCartDraft order = OrderFromCartDraft.builder()
//                .state()
//    }

}
