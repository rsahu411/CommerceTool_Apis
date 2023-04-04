package com.CommerceTool.Product;

import com.commercetools.api.models.product_type.AttributeConstraintEnum;
import com.commercetools.api.models.product_type.AttributeType;
import com.commercetools.api.models.product_type.TextInputHint;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AttributesDetails {

    public String label;
    public String attributeName;
    public AttributeConstraintEnum attributeConstraint;
    public TextInputHint inputHint;
    public AttributeType attributeType;
    public Boolean isSearchable;
    public Boolean isRequired;
}
