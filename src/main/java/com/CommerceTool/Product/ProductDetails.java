package com.CommerceTool.Product;

import com.commercetools.api.models.product_type.AttributeConstraintEnum;
import com.commercetools.api.models.product_type.AttributeType;
import com.commercetools.api.models.product_type.TextInputHint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetails {

    public String productTypeId;
    public String productTypeName;
    public String productTypeDescription;
    public String productKey;
    public String productName;
    public String productDescription;
    public String slug;
    public String key;
    public String sku;
    public String priceKey;
    public String country;
    public String currencyCode;
    public long centAmount;
    public String imageUrl;
    public String imageLabel;
    public  String variantSku;
    public  String variantCountry;
    public  String variantCurrencyCode;
    public  long variantCentAmount;
    public String variantImageUrl;
    public Integer height;
    public Integer width;

    public long version;
    public long variantId;
    public Object attributeValue;
    public String attributeName;
    public String label;
    public AttributeConstraintEnum attributeConstraint;
    public TextInputHint inputHint;
    public AttributeType attributeType;
    public Boolean isSearchable;
    public Boolean isRequired;
    public String nestedAttributeName;
    public String nestedLabel;
    public AttributeConstraintEnum nestedAttributeConstraint;
    public TextInputHint nestedInputHint;
    public AttributeType nestedAttributeType;
    public Boolean nestedIsSearchable;
    public Boolean nestedIsRequired;
    List<AttributesDetails> attributesDetails;




}
