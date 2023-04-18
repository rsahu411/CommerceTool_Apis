package com.CommerceTool.Order;


import lombok.Data;

@Data
public class DeliveryItemDetails {

    // line item id & Quantity
    private String id;
    private long quantity;
}
