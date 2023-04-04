package com.CommerceTool.CartDiscounts;

import com.commercetools.api.models.cart_discount.CartDiscountValueDraft;
import lombok.Data;
import org.intellij.lang.annotations.JdkConstants;

@Data
public class CartDiscountValueDto {
    CartDiscountValueDraft abslute;
    CartDiscountValueDraft relative;
}
