package com.CommerceTool.CustomType;

import com.commercetools.api.models.type.FieldType;
import com.commercetools.api.models.type.ResourceTypeId;
import com.commercetools.api.models.type.TypeTextInputHint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomTypeDetails {

    public long version;
    public String customTypeName;
    public String customTypeKey;
    public ResourceTypeId resourceTypeId;
    public String fieldName;
    public String fieldLabel;
    public Boolean required;
    public FieldType name;
    public TypeTextInputHint inputHint;
    public List<CustomFieldDetails> customFieldDetails;
}
