package com.CommerceTool.Product;

import com.CommerceTool.configuration.Client;
import com.CommerceTool.DataProvider.DataProvider;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.common.*;
import com.commercetools.api.models.product.*;
import com.commercetools.api.models.product_type.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    ProjectApiRoot projectApiRoot= Client.createApiClient();
    DataProvider cdp = new DataProvider();


    // Create Product Type
    public ProductType createProductType(ProductDetails productDetails)
    {
        List<AttributeDefinitionDraft> attributeList = productDetails
                .getAttributesDetails()
                .stream().map(attributesDetails -> {

               return      AttributeDefinitionDraft
                            .builder()
                            .type(attributesDetails.getAttributeType())
                            .name(attributesDetails.getAttributeName())
                            .isRequired(attributesDetails.getIsRequired())
                            .label(LocalizedString.ofEnglish(attributesDetails.getLabel()))
                            .isSearchable(attributesDetails.getIsSearchable())
                            .attributeConstraint(attributesDetails.getAttributeConstraint())
                            .inputHint(attributesDetails.getInputHint())
                            .build();
                }).collect(Collectors.toList()) ;

        List<AttributeDefinitionDraft> nestedAttribute = List.of(
                AttributeDefinitionDraft
                        .builder()
                        .name(productDetails.getAttributeName())
                        .type(productDetails.getAttributeType())
                        .isRequired(productDetails.getIsRequired())
                        .isSearchable(productDetails.getIsSearchable())
                        .label(LocalizedString.ofEnglish(productDetails.getLabel()))
                        .attributeConstraint(productDetails.getAttributeConstraint())
                        .inputHint(productDetails.getInputHint())
                        .build()
//                AttributeDefinitionDraft
//                        .builder()
//                        .name(productDetails.getNestedAttributeName())
//                        .type(AttributeSetType
//                                .builder()
//                                .elementType(AttributeNestedType
//                                                .builder()
//                                                .typeReference(ProductTypeReference
//                                                        .builder()
//                                                        .id(productDetails.getProductTypeId())
//                                                        .build())
//                                                .build())
//                                .build())
//                        .isRequired(productDetails.getNestedIsRequired())
//                        .isSearchable(productDetails.getNestedIsSearchable())
//                        .label(LocalizedString.ofEnglish(productDetails.getNestedLabel()))
//                        .attributeConstraint(productDetails.getNestedAttributeConstraint())
//                        .inputHint(productDetails.getNestedInputHint())
//                        .build()
        );

        ProductTypeDraft productType = ProductTypeDraft
                .builder()
                .name(productDetails.getProductTypeName())
                .description(productDetails.getProductTypeDescription())
                .attributes(nestedAttribute)
                .key(productDetails.getProductKey())

                .build();
        return cdp.createProductType(productType);
    }


    // Get All Product Type
    public ProductTypePagedQueryResponse getAllProductTypes(String limit)
    {

        ProductTypePagedQueryResponse productType = projectApiRoot
                .productTypes()
                .get()
                .withLimit(limit)
                .executeBlocking()
                .getBody();
        return productType;
    }




    // Get Product Type By Id
    public ProductType checkProductTypeById(String id)
    {
        ProductType productType = projectApiRoot
                .productTypes()
                .withId(id)
                .get()
                .executeBlocking()
                .getBody();
        return productType;
    }



    // update Product Type
    public ProductType productTypeUpdate(String Id, ProductDetails productDetails)
    {
        ProductType product = projectApiRoot.productTypes().withId(Id).get().executeBlocking().getBody();

        List<ProductTypeUpdateAction> streamOfUpdateAttribute = productDetails
                .getAttributesDetails()
                .stream()
                .map(e->{
                    return ProductTypeUpdateActionBuilder
                        .of()
                        .addAttributeDefinitionBuilder()
                        .attribute(AttributeDefinitionDraft.builder()
                        .type(e.getAttributeType())
                                .label(LocalizedString.ofEnglish(e.getLabel()))
                        .inputHint(e.getInputHint())
                        .name(e.getAttributeName())
                        .attributeConstraint(e.getAttributeConstraint())
                        .isSearchable(e.getIsSearchable())
                        .isRequired(e.getIsRequired())
                        .build())
                .build();}).collect(Collectors.toList());
        ProductTypeUpdate productTypeUpdate = ProductTypeUpdate
                .builder()
                .version(product.getVersion())
                .actions(streamOfUpdateAttribute)
                .build();


        ProductType productType = projectApiRoot
                .productTypes()
                .withId(product.getId())
                .post(productTypeUpdate)
                .executeBlocking()
                .getBody();

        return productType;

    }



    // Create Product
    public Product createProduct(@NotNull ProductDetails productDetails)
    {

        ProductDraft productDraft = ProductDraft
                .builder()
                .productType(ProductTypeResourceIdentifier
                        .builder()
                        .id(productDetails.getProductTypeId())
                        .build())
                .name(LocalizedString.ofEnglish(productDetails.getProductName()))
                .description(LocalizedString.ofEnglish(productDetails.getProductDescription()))
                .key(productDetails.getProductKey())
                .slug(LocalizedString.ofEnglish(productDetails.getSlug()))
                .masterVariant(ProductVariantDraftBuilder
                        .of()
                        .key(productDetails.getKey())
                        .sku(productDetails.getSku())
                        .prices(PriceDraft
                                .builder()
                                .key(productDetails.getPriceKey())
                                .country(productDetails.getCountry())
                                .value(Money
                                        .builder()
                                        .centAmount(productDetails.getCentAmount())
                                        .currencyCode(productDetails.getCurrencyCode())
                                        .build())
                                .build())
                        .images(ImageBuilder
                                .of()
                                .url(productDetails.getImageUrl())
                                .dimensions(ImageDimensionsBuilder.of().w(productDetails.getWidth()).h(productDetails.getHeight()).build())
                                .label(productDetails.getImageLabel()).build())
                        .build())
                .variants(ProductVariantDraftBuilder
                        .of()

                        .sku(productDetails.getVariantSku())
                        .prices(PriceDraft
                                .builder()
                                .country(productDetails.getVariantCountry())
                                .value(Money
                                        .builder()
                                        .currencyCode(productDetails.getVariantCurrencyCode())
                                        .centAmount(productDetails.getVariantCentAmount())
                                        .build())
                                .build())
                        .images(ImageBuilder
                                .of()
                                .url(productDetails.getVariantImageUrl())
                                .dimensions(ImageDimensionsBuilder.of().w(productDetails.getWidth()).h(productDetails.getHeight()).build())
                                .build())

                        .build())
                .build();

        return cdp.createProduct(productDraft);
    }



    // Update Product
    public Product UpdateProduct(String id,ProductDetails productDetails)
    {
        Product product = projectApiRoot
                .products()
                .withId(id)
                .get()
                .executeBlocking()
                .getBody();

        ProductUpdate productUpdate = ProductUpdate
                .builder()
                .version(product.getVersion())
                .plusActions(actionBuilder -> actionBuilder.addVariantBuilder()
                        .plusAttributes(Attribute.builder().value(productDetails.getAttributeValue()).build()))
                .build();

        Product updatedProduct= projectApiRoot
                .products()
                .withId(product.getId())
                .post(productUpdate)
                .executeBlocking()
                .getBody();
        return updatedProduct;
    }



    // Get Product By id
    public Product getProductById(String id) {

        Product product=projectApiRoot
                .products()
                .withId(id)
                .get()
                .executeBlocking()
                .getBody();
        return  product;
    }



    // Get All Product
    public ProductPagedQueryResponse getProducts(String limit) {

        ProductPagedQueryResponse queryResponse = projectApiRoot
                .products()
                .get()
                .withLimit(limit)
                .executeBlocking()
                .getBody();
        return  queryResponse;
    }



    public long getPrice(String id)
    {
        long price = projectApiRoot
                .products()
                .withId(id)
                .get()
                .executeBlocking()
                .getBody()
                .getMasterData().getCurrent().getVariants().get(0)
                .getPrices().get(0).getValue().getCentAmount();
        return price;
    }


    // Update Product
    public Product updateProducts(String id,ProductDetails productDetails) {

        Product product = projectApiRoot
                .products()
                .withId(id)
                .get()
                .executeBlocking()
                .getBody();


        ProductUpdate productUpdate=ProductUpdate
                .builder()
                .version(product.getVersion())
                .plusActions(actionBuilder -> actionBuilder.setAttributeBuilder()
                        .variantId(productDetails.getVariantId())
                        .name(productDetails.getAttributeName())
                        .value(productDetails.getAttributeValue())
//                        .plusAttributes(attributeBuilder -> attributeBuilder
//
//                                .name(productDetails.getAttributeName())
//                                .value(productDetails.getAttributeValue()))
                )
//                .plusActions(actionBuilder -> actionBuilder.changeSlugBuilder()
//                        .slug(LocalizedString.ofEnglish(productDetails.getSlug())))
//                .plusActions(actionBuilder -> actionBuilder
//                        .addVariantBuilder()
//                        .plusPrices(priceDraftBuilder -> priceDraftBuilder
//                                .country(productDetails.getCountry())
//                                .key(productDetails.getKey())
//                                .value(moneyBuilder->moneyBuilder
//                                        .centAmount(productDetails.getCentAmount())
//                                        .currencyCode(productDetails.getCurrencyCode())
//                                        ))
//                        .images(Image
//                                .builder()
//                                .url(productDetails.getImageUrl())
//                                .dimensions(ImageDimensions.builder().h(productDetails.getHeight()).w(productDetails.getWidth()).build())
//                                .label(productDetails.getImageLabel())
//                                .build()))// .plusActions(actionBuilder -> actionBuilder.changeSlugBuilder().slug(ProductDraft.of().getSlug()))
                .build();
        Product updatedproduct = projectApiRoot
                .products()
                .withId(id)
                .post(productUpdate)
                .executeBlocking()
                .getBody();
        return  updatedproduct;
    }



    // Delete Products
    public Product deleteProducts(String id,long version) {

        Product product = projectApiRoot
                .products()
                .withId(id)
                .delete(version)
                .executeBlocking()
                .getBody();
        return product;
    }




    public Object getAttributeValue(String id)
    {
        Product product = projectApiRoot
                    .products()
                    .withId(id)
                    .get()
                    .executeBlocking()
                    .getBody();
       return  product.getMasterData().getCurrent().getMasterVariant().getAttributes().get(0).getValue();
    }
}
