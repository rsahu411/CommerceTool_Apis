package com.CommerceTool.DiscountCode;

import com.CommerceTool.DataProvider.DataProvider;
import com.CommerceTool.configuration.Client;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.cart_discount.*;
import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.discount_code.DiscountCode;
import com.commercetools.api.models.discount_code.DiscountCodeDraft;
import com.commercetools.api.models.discount_code.DiscountCodePagedQueryResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountCodeService {

    ProjectApiRoot projectApiRoot= Client.createApiClient();
    DataProvider cdp = new DataProvider();
    public DiscountCode createDiscountCode(DiscountCodeDetails discountCodeDetails) {
        List<CartDiscountResourceIdentifier> cartList = discountCodeDetails.getCartDiscountvariables()
                .stream()
                .map(deatils->CartDiscountResourceIdentifier.builder().id(deatils.getId()).build())
                .collect(Collectors.toList());

        DiscountCodeDraft codeDraft = DiscountCodeDraft
                .builder()
                .name(LocalizedString.ofEnglish(discountCodeDetails.getName()))
                .description(LocalizedString.ofEnglish(discountCodeDetails.getDescription()))
                .code(discountCodeDetails.getCode())
                .validFrom(discountCodeDetails.getValidFrom())
                .validUntil(discountCodeDetails.getValidUntil())
                .isActive(discountCodeDetails.getIsActive())
                .maxApplications(discountCodeDetails.getMaxApplication())
                .maxApplicationsPerCustomer(discountCodeDetails.getMaxApplicationPerCustomer())
                .cartDiscounts(cartList)
                .build();
        return cdp.createDiscountCode(codeDraft);
    }



    public DiscountCodePagedQueryResponse getAllDiscountCode(String limit)
    {
        DiscountCodePagedQueryResponse queryResponse= projectApiRoot
                .discountCodes()
                .get()
                .withLimit(limit)
                .executeBlocking()
                .getBody();
        return queryResponse;
    }


    public DiscountCode getDiscountCodeById(String id)
    {
         DiscountCode discountCode = projectApiRoot
                 .discountCodes()
                 .withId(id)
                 .get()
                 .executeBlocking()
                 .getBody();
         return discountCode;
    }

    public DiscountCode deleteDiscountCodeById(String id, Long version) {

        DiscountCode discountCode = projectApiRoot
                .discountCodes()
                .withId(id)
                .delete(version)
                .executeBlocking()
                .getBody();
        return discountCode;
    }
}
