package com.Daily_CTTask.Repository;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.product.ProductProjectionPagedSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CategoryRepository {

    @Autowired
    private ProjectApiRoot apiRoot;

    public ProductProjectionPagedSearchResponse getAllProduct()
    {
        return apiRoot.productProjections().search().get().executeBlocking().getBody();
    }

    public ProductProjectionPagedSearchResponse getCategoryFilterProduct(String category) {

        return apiRoot.productProjections().search().get()
                .addFilter("categories.id:"+category+"")
                .addFacet("categories.id:"+category+" counting products")
                .executeBlocking().getBody();
    }


    public ProductProjectionPagedSearchResponse getPriceFilterProduct(String price){

        return apiRoot.productProjections().search().get()
                .addFilter("variants.price.centAmount:"+price+"")
                .addFacet("variants.price.centAmount:"+price+"counting products")
                .executeBlocking().getBody();
    }

    public ProductProjectionPagedSearchResponse getSizeFilterProduct(String size) {

        return apiRoot.productProjections().search().get()
                .addFilter("variants.attributes.size:"+size+"")
                .addFacet("variants.attributes.size:"+size+"counting products")
                .executeBlocking().getBody();
    }

    public ProductProjectionPagedSearchResponse getColorFilterProduct(String color) {

        return apiRoot.productProjections().search().get()
                .addFilter("variants.attributes.color.key:"+color+"")
                .addFacet("variants.attributes.color.key:"+color+"counting products")
                .executeBlocking().getBody();
    }


    public ProductProjectionPagedSearchResponse getCategoryAndColorFilterProduct(String category, String color)
    {
        return apiRoot.productProjections().search().get()
                .addFilter("categories.id:"+category+"")
                .addFilter("variants.attributes.color.key:"+color+"")
                .addFacet("categories.id:"+category+"counting products")
                .addFacet("variants.attributes.color.key:"+color+"counting products")
                .executeBlocking().getBody();
    }

    public ProductProjectionPagedSearchResponse getCategoryAndSizeFilterProduct(String category, String size)
    {
        return apiRoot.productProjections().search().get()
                .addFilter("categories.id:"+category+"")
                .addFilter("variants.attributes.size:"+size+"")
                .addFacet("categories.id:"+category+"counting products")
                .addFacet("variants.attributes.size:"+size+"counting products")
                .executeBlocking().getBody();
    }


    public ProductProjectionPagedSearchResponse getCategoryAndPriceFilterProduct(String category, String price)
    {
        return apiRoot.productProjections().search().get()
                .addFilter("categories.id:"+category+"")
                .addFilter("variants.price.centAmount:"+price+"")
                .addFacet("categories.id:"+category+"counting products")
                .addFacet("variants.price.centAmount:"+price+"counting products")
                .executeBlocking().getBody();
    }


    public ProductProjectionPagedSearchResponse getColorAndPriceFilterProduct(String color, String price)
    {
        return apiRoot.productProjections().search().get()
                .addFilter("variants.attributes.color.key:"+color+"")
                .addFilter("variants.price.centAmount:"+price+"")
                .addFacet("variants.attributes.color.key:"+color+"counting products")
                .addFacet("variants.price.centAmount:"+price+"counting products")
                .executeBlocking().getBody();
    }


    public ProductProjectionPagedSearchResponse getColorAndSizeFilterProduct(String color, String size) {

        return apiRoot.productProjections().search().get()
                .addFilter("variants.attributes.size:"+size+"")
                .addFilter("variants.attributes.color.key:"+color+"")
                .addFacet("variants.attributes.size:"+size+"counting products")
                .addFacet("variants.attributes.color.key:"+color+"counting products")
                .executeBlocking().getBody();
    }


    public ProductProjectionPagedSearchResponse getPriceAndSizeFilterProduct(String price, String size)
    {
        return apiRoot.productProjections().search().get()
                .addFilter("variants.price.centAmount:"+price+"")
                .addFilter("variants.attributes.size:"+size+"")
                .addFacet("variants.price.centAmount:"+price+"counting products")
                .addFacet("variants.attributes.size:"+size+"counting products")
                .executeBlocking().getBody();
    }



    public ProductProjectionPagedSearchResponse getCategoryColorAndSizeFilterProduct(String category, String color, String size)
    {
        return apiRoot
            .productProjections().search().get()
            .addFilter("categories.id:"+category+"")
            .addFilter("variants.attributes.color.key:"+color+"")
            .addFilter("variants.attributes.size:"+size+"")
            .executeBlocking().getBody();
    }


    public ProductProjectionPagedSearchResponse getCategoryColorAndPriceFilterProduct(String category,String color, String price)
    {
        return apiRoot.productProjections().search().get()
                .addFilter("categories.id:"+category+"")
                .addFilter("variants.attributes.color.key:"+color+"")
                .addFilter("variants.price.centAmount:"+price+"")
                .executeBlocking().getBody();
    }


    public ProductProjectionPagedSearchResponse getCategorySizeAndPriceFilterProduct(String category, String size, String price) {

        return apiRoot.productProjections().search().get()
                .addFilter("categories.id:"+category+"")
                .addFilter("variants.attributes.size:"+size+"")
                .addFilter("variants.price.centAmount:"+price+"")
                .executeBlocking().getBody();
    }

    public ProductProjectionPagedSearchResponse getColorSizeAndPriceFilterProduct(String color, String size, String price) {

        return apiRoot.productProjections().search().get()
                .addFilter("variants.attributes.color.key:"+color+"")
                .addFilter("variants.attributes.size:"+size+"")
                .addFilter("variants.price.centAmount:"+price+"")
                .executeBlocking().getBody();

    }

    public ProductProjectionPagedSearchResponse getCategoryColorPriceAndSizeFilterProduct(String category, String color, String price, String size) {

        return apiRoot.productProjections().search().get()
                .addFilter("categories.id:"+category+"")
                .addFilter("variants.attributes.color.key:"+color+"")
                .addFilter("variants.attributes.size:"+size+"")
                .addFilter("variants.price.centAmount:"+price+"")
                .executeBlocking().getBody();
    }
}
