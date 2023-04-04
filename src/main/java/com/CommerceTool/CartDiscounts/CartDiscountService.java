package com.CommerceTool.CartDiscounts;

import com.CommerceTool.DataProvider.DataProvider;
import com.CommerceTool.DiscountCode.CartDiscountVariable;
import com.CommerceTool.configuration.Client;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.cart_discount.*;
import com.commercetools.api.models.common.CentPrecisionMoney;
import com.commercetools.api.models.common.LocalizedString;
import org.springframework.stereotype.Service;

@Service
public class CartDiscountService {

    ProjectApiRoot projectApiRoot= Client.createApiClient();
    DataProvider cdp = new DataProvider();
    public CartDiscount createCartDiscount(CartDiscountDetails cartDiscountDetails)

    {
//        CartDiscountValueDraft abslute = null;
//        CartDiscountValueDraft relative=null;
//
//        if(cartDiscountDetails.getType().equals(abslute)){
//            String df=cartDiscountValueDraftBuilder -> cartDiscountValueDraftBuilder.absoluteBuilder();
//        } else if (cartDiscountDetails.getType().equals(relative)) {
//            cartDiscountValueDraftBuilder -> cartDiscountValueDraftBuilder.relativeBuilder();
//        }

        CartDiscountDraft cartDiscountDraft = CartDiscountDraft
                .builder()
                .name(LocalizedString.ofEnglish(cartDiscountDetails.getName()))
                .description(LocalizedString.ofEnglish(cartDiscountDetails.getDescription()))
                .validFrom(cartDiscountDetails.getValidFrom())
                .validUntil(cartDiscountDetails.getValidUntil())
                .key(cartDiscountDetails.getKey())
                .requiresDiscountCode(cartDiscountDetails.getRequiresDiscountCode())
                .sortOrder(cartDiscountDetails.getSortOrder())
                .cartPredicate(cartDiscountDetails.getCartPredicate())
                .target(CartDiscountTarget.lineItemsBuilder().predicate(cartDiscountDetails.getTargetPredicate()).build())

//                .value(CartDiscountValueDraft.absoluteBuilder().money(CentPrecisionMoney
//                                .builder().centAmount(cartDiscountDetails.getCentAmount())
//                                .currencyCode(cartDiscountDetails.getCurrencyCode()).build()).build())
                .value(CartDiscountValueDraft.relativeBuilder().permyriad(cartDiscountDetails.getPermyriad()).build())
                .build();

        return  cdp.createCartDiscount(cartDiscountDraft);
    }
}
