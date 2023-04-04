package com.CommerceTool.CartDiscounts;

import com.commercetools.api.models.cart_discount.CartDiscountValue;
import com.commercetools.api.models.cart_discount.CartDiscountValueDraft;
import com.commercetools.api.models.common.LocalizedStringImpl;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class CartDiscountDetails {

    public String name;
    public String description;
    public String Key;
    public String Code;
    public ZonedDateTime ValidFrom;
    public ZonedDateTime ValidUntil;
    public Boolean requiresDiscountCode;
    public String sortOrder;
    public Long permyriad;
    public String currencyCode;
    public Long CentAmount;
    public String cartPredicate;
    public String targetPredicate;
    public CartDiscountValueDto type;
}
