package com.CommerceTool.DataProvider;


import com.CommerceTool.configuration.Client;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.cart.Cart;
import com.commercetools.api.models.cart.CartDraft;
import com.commercetools.api.models.cart_discount.CartDiscount;
import com.commercetools.api.models.cart_discount.CartDiscountDraft;
import com.commercetools.api.models.channel.Channel;
import com.commercetools.api.models.channel.ChannelDraft;
import com.commercetools.api.models.customer.*;
import com.commercetools.api.models.customer_group.CustomerGroup;
import com.commercetools.api.models.customer_group.CustomerGroupDraft;
import com.commercetools.api.models.discount_code.DiscountCode;
import com.commercetools.api.models.discount_code.DiscountCodeDraft;
import com.commercetools.api.models.order.Order;
import com.commercetools.api.models.order.OrderFromCartDraft;
import com.commercetools.api.models.payment.Payment;
import com.commercetools.api.models.payment.PaymentDraft;
import com.commercetools.api.models.product.Product;
import com.commercetools.api.models.product.ProductDraft;
import com.commercetools.api.models.product_type.ProductType;
import com.commercetools.api.models.product_type.ProductTypeDraft;
import com.commercetools.api.models.review.Review;
import com.commercetools.api.models.review.ReviewDraft;
import com.commercetools.api.models.state.State;
import com.commercetools.api.models.state.StateDraft;
import com.commercetools.api.models.type.Type;
import com.commercetools.api.models.type.TypeDraft;

public class DataProvider {

    ProjectApiRoot apiRoot = Client.createApiClient();

    public Customer createCustomer(CustomerDraft newCustomerDraft) {
        return apiRoot.customers().post(newCustomerDraft).executeBlocking().getBody().getCustomer();
    }

//    public CustomerPagedQueryResponse queryResponse(CustomerPagedQueryResponse queryResponse) {
//        return apiRoot.customers().post(queryResponse).executeBlocking().getBody();
//    }

    public CustomerSignInResult getCustomerByLogin(CustomerSignin customerSignin) {
        return apiRoot.login().post(customerSignin).executeBlocking().getBody();
    }

    public Type createCustomType(TypeDraft typeDraft) {
        return apiRoot.types().post(typeDraft).executeBlocking().getBody();
    }


    public CustomerToken getCustomerToken(CustomerCreatePasswordResetToken customerCreatePasswordResetToken) {
        return apiRoot.customers().passwordToken().post(customerCreatePasswordResetToken).executeBlocking().getBody();
    }

    public Customer resetPassword(CustomerResetPassword customerResetPassword) {
        return apiRoot.customers().passwordReset().post(customerResetPassword).executeBlocking().getBody();
    }

    public Customer changePassword(CustomerChangePassword changePassword) {
        return apiRoot.customers().password().post(changePassword).executeBlocking().getBody();
    }

    public ProductType createProductType(ProductTypeDraft productType) {
        return  apiRoot.productTypes().post(productType).executeBlocking().getBody();
    }

    public Product createProduct(ProductDraft productDraft) {
        return  apiRoot.products().post(productDraft).executeBlocking().getBody();
    }

    public CustomerGroup createCustomerGroup(CustomerGroupDraft customerGroupDraft) {
        return apiRoot.customerGroups().post(customerGroupDraft).executeBlocking().getBody();
    }

    public Cart createCart(CartDraft cart) {
        return  apiRoot.carts().post(cart).executeBlocking().getBody();
    }

    public DiscountCode createDiscountCode(DiscountCodeDraft codeDraft) {
        return apiRoot.discountCodes().post(codeDraft).executeBlocking().getBody();
    }

    public CartDiscount createCartDiscount(CartDiscountDraft cartDiscountDraft) {
        return apiRoot.cartDiscounts().post(cartDiscountDraft).executeBlocking()
                .getBody();
    }

    public Channel createChannel(ChannelDraft channel) {
        return  apiRoot.channels().post(channel).executeBlocking().getBody();
    }

    public Order createOrder(OrderFromCartDraft order) {
        return apiRoot.orders().post(order).executeBlocking().getBody();
    }

    public State createState(StateDraft stateDraft) {

        return apiRoot.states().post(stateDraft).executeBlocking().getBody();
    }


    public Payment createPayment(PaymentDraft paymentDraft) {

        return apiRoot.payments().post(paymentDraft).executeBlocking().getBody();
    }

    public Review createReview(ReviewDraft reviewDraft) {

        return apiRoot.reviews().post(reviewDraft).executeBlocking().getBody();
    }
}

