package com.CommerceTool.Payments;

import com.commercetools.api.models.payment.TransactionState;
import com.commercetools.api.models.payment.TransactionType;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class TransactionDetails {


    private ZonedDateTime timestamp;
    private TransactionType type;
    private String currencyCode;
    private long centAmount;
    private TransactionState state;
}
