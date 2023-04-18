package com.CommerceTool.Order;

import lombok.Data;

@Data
public class ParcelDetails {


    // All dimensions are in millimeter and weight in milligram
    private Integer lengthInMillimeter;
    private Integer widthInMilliMeter;
    private Integer heightInMillimeter;
    private Integer weightInGram;

    // Tracking Details

    private String trackingId;
    private String carrier;
    private String provider;
    private String providerTransaction;
    private boolean isReturn;
}
