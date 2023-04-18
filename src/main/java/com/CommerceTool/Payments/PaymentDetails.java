package com.CommerceTool.Payments;


import lombok.Data;
import java.time.ZonedDateTime;
import java.util.List;

@Data
public class PaymentDetails {

    private String key;
    private String customerId;
    private String interfaceId;

    // Amount Planned Details
    private String currencyCode;
    private long centAmount;

    // PaymentMethodInfo Details
    private String paymentInterface;
    private String method;
    private String name;

    // Transaction Details
    List<TransactionDetails> transactions;


}
