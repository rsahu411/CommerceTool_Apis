package com.CommerceTool.Cart;

import com.commercetools.api.models.cart.LineItem;
import com.commercetools.api.models.cart.LineItemDraft;
import com.commercetools.api.models.cart.TaxMode;
import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.customer.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartDetails {

    private String key;
    private String email;
    private String currency;
    private TaxMode taxMode;
    private String customerId;
    private long version;
    private String lineItemId;
    private long quantity;
    private String supplyId;
    private String distributionId;

    private LocalizedString customFieldName;
    private List<LineItemDetails> lineItemDetails;

    private List<BaseAddressDetails> baseAddressDetails;



    // Shipping Address Details
    private String title;
    private String salutation;
    private String firstName;
    private String lastName;
    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String city;
    private String state;
    private String region;
    private String country;
    private String pOBox;



    // Line Item Details
    private String productId;
    private Long variantId;
    private String supplyChannelId;
    private String distributionChannelId;
    private String sku;

}
