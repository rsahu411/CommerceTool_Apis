package com.CommerceTool.Payments;

import com.CommerceTool.DataProvider.DataProvider;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.common.Money;
import com.commercetools.api.models.customer.CustomerResourceIdentifier;
import com.commercetools.api.models.payment.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    ProjectApiRoot projectApiRoot;
    DataProvider cdp = new DataProvider();


    // Create Payments
    public Payment createPayment(PaymentDetails paymentDetails) {


       List<TransactionDraft> transactionDraftList = paymentDetails.getTransactions()
                .stream()
                .map( transactionDetails -> {
                    return TransactionDraft
                            .builder()
                            .timestamp(transactionDetails.getTimestamp())
                            .type(transactionDetails.getType())
                            .amount(Money
                                    .builder()
                                    .currencyCode(transactionDetails.getCurrencyCode())
                                    .centAmount(transactionDetails.getCentAmount())
                                    .build())
                            .state(transactionDetails.getState())
                            .build();
                        }
                )
                .collect(Collectors.toList());


        PaymentDraft paymentDraft = PaymentDraft
                .builder()
                .key(paymentDetails.getKey())
                .customer(CustomerResourceIdentifier.builder().id(paymentDetails.getCustomerId()).build())
                .interfaceId(paymentDetails.getInterfaceId())
                .amountPlanned(Money
                        .builder()
                        .currencyCode(paymentDetails.getCurrencyCode())
                        .centAmount(paymentDetails.getCentAmount())
                        .build())
                .paymentMethodInfo(PaymentMethodInfo
                        .builder()
                        .paymentInterface(paymentDetails.getPaymentInterface())
                        .method(paymentDetails.getMethod())
                        .name(LocalizedString.ofEnglish(paymentDetails.getName()))
                        .build())
                .transactions(transactionDraftList)
                .build();

        return cdp.createPayment(paymentDraft);
    }


    // Get All Payments
    public PaymentPagedQueryResponse getAllPayments(String limit)
    {
        PaymentPagedQueryResponse queryResponse = projectApiRoot
                .payments()
                .get()
                .withLimit(limit)
                .executeBlocking()
                .getBody();

        return queryResponse;
    }


    // Get Payment By Id
    public Payment getPaymentsById(String id) {

        Payment payment = projectApiRoot
                .payments()
                .withId(id)
                .get()
                .executeBlocking()
                .getBody();

        return payment;

    }


    // Delete Payment By Id
    public Payment deletePaymentById(String id) {

        Payment payment = projectApiRoot.payments().withId(id).get().executeBlocking().getBody();

        return projectApiRoot
                .payments()
                .withId(id)
                .delete(payment.getVersion())
                .executeBlocking()
                .getBody();
    }
}
