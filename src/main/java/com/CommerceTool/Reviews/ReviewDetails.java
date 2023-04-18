package com.CommerceTool.Reviews;

import com.commercetools.api.models.common.ResourceIdentifier;
import lombok.Data;

@Data
public class ReviewDetails {

    private String key;
    private String authorName;
    private String title;
    private String text;
    private Integer rating;
    private String productId;
    private String stateId;
    private String stateKey;



}
