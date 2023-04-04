package com.CommerceTool.CustomType;

import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.type.FieldDefinition;
import com.commercetools.api.models.type.FieldType;
import com.commercetools.api.models.type.TypeTextInputHint;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
public class CustomFieldDetails implements Serializable {


    public String fieldName;
    public String fieldLabel;
    public Boolean required;
    public FieldType name;
    public TypeTextInputHint inputHint;
}
