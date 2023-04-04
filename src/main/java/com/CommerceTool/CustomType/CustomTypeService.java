package com.CommerceTool.CustomType;

import com.CommerceTool.DataProvider.DataProvider;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.type.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CustomTypeService {


    @Autowired
    ProjectApiRoot apiRoot;

    DataProvider cdp = new DataProvider();


    //Create Custom-Type
    public Type createCustomType(CustomTypeDetails customTypeDetails)
    {

        List<FieldDefinition> fieldDefinitions = customTypeDetails.getCustomFieldDetails()
                .stream()
                .map(fieldDetails -> {
                    return  FieldDefinition
                            .builder()
                            .type(FieldType.stringBuilder().build())
                            .name(fieldDetails.getFieldName())
                            .label(LocalizedString.builder().addValue("en",fieldDetails.getFieldLabel()).build())
                            .inputHint(fieldDetails.getInputHint())
                            .required(fieldDetails.getRequired())
                            .build();
                })
                .collect(Collectors.toList());

        TypeDraft typeDraft = TypeDraft
                .builder()
                .key(customTypeDetails.getCustomTypeKey())
                .name(LocalizedString.builder().addValue("en",customTypeDetails.getCustomTypeName()).build())

                .resourceTypeIds(List.of(customTypeDetails.getResourceTypeId()))
                .fieldDefinitions(fieldDefinitions)
                .build();
        return  cdp.createCustomType(typeDraft);
    }




    // Get All Custom Object
    public TypePagedQueryResponse getAllCustomType(String limit) {

        TypePagedQueryResponse queryResponse =apiRoot
                .types()
                .get()
                .withLimit(limit)
                .executeBlocking()
                .getBody();
        return queryResponse;
    }





    // Get Custom-Type By Id
    public  Type getCustomTypeById(String id)
    {
        Type type = apiRoot
                .types()
                .withId(id)
                .get()
                .executeBlocking()
                .getBody();
        return  type;
    }




    // Update Custom-Type
    public Type updateCustomType(CustomTypeDetails customTypeDetails, String id)
    {
        Type type = apiRoot.types().withId(id).get().executeBlocking().getBody();


        TypeUpdate typeUpdate = TypeUpdate
                .builder()
                .version(type.getVersion())
                .actions(TypeUpdateAction.addFieldDefinitionBuilder()
                        .fieldDefinition(FieldDefinition.builder()
                                .type(FieldType.stringBuilder().build())
                                .name(customTypeDetails.getFieldName())
                                .label(LocalizedString.ofEnglish(customTypeDetails.getFieldLabel()))
                                .inputHint(customTypeDetails.getInputHint())
                                .required(customTypeDetails.getRequired())
                                .build())
                        .build())
                .build();

        Type updatedType = apiRoot
                .types()
                .withId(type.getId())
                .post(typeUpdate)
                .executeBlocking()
                .getBody();
        return updatedType;
    }




    // Delete Custom-Type By Id
    public Type deleteCustomType(String id,long version) {

        Type type=apiRoot
                .types()
                .withId(id)
                .delete(version)
                .executeBlocking()
                .getBody();
        return type;

    }
}
