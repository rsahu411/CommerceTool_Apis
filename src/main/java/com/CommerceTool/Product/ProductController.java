package com.CommerceTool.Product;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.cart.CartUpdate;
import com.commercetools.api.models.product.Product;
import com.commercetools.api.models.product.ProductPagedQueryResponse;
import com.commercetools.api.models.product.ProductProjectionPagedSearchResponse;
import com.commercetools.api.models.product_type.ProductType;
import com.commercetools.api.models.product_type.ProductTypePagedQueryResponse;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProjectApiRoot projectApiRoot;
    @Autowired
    ProductService service;

    // Create Product Type
    @PostMapping("/product-type")
    public ProductType createProductType(@RequestBody ProductDetails productDetails)
    {
        return service.createProductType(productDetails);
    }


    // Get All Product Type
    @GetMapping("/types")
    public ProductTypePagedQueryResponse getAllProductTypes(@RequestParam String Limit)
    {
        return service.getAllProductTypes(Limit);
    }



    // Get ProductType By id
    @GetMapping("/product-type/{id}")
    public ResponseEntity checkProductTypeBYId(@PathVariable String id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.checkProductTypeById(id));
    }



    // Update Product Type
    @PostMapping("/updates/{id}")
    public ProductType updateProductType(@PathVariable String id,@RequestBody ProductDetails productDetails)
    {
        return service.productTypeUpdate(id,productDetails);
    }



    // Create Product
    @PostMapping
    public Product createProduct(@RequestBody ProductDetails productDetails)
    {
        return service.createProduct(productDetails);
    }



    // Get All Product
    @GetMapping
    public ProductPagedQueryResponse getProducts(@RequestParam (required = false, defaultValue="5") String limit)
    {
        return service.getProducts(limit);
    }



    // Get Product by id
    @GetMapping("/{Id}")
    public Product getProductById(@PathVariable String Id)
    {
        return service.getProductById(Id);
    }



    @GetMapping("/price/{id}")
    public long getPrice(@PathVariable String id)
    {
        return service.getPrice(id);
    }

    // Update Product
    @PostMapping("/{Id}")
    public Product updateProducts(@PathVariable String Id, @RequestBody ProductDetails productDetails)
    {
        return service.updateProducts(Id,productDetails);
    }



    // Delete Products
    @DeleteMapping("/{Id}")
    public Product deleteProducts(@PathVariable String Id,@RequestParam(required = false, defaultValue="1L") long version)
    {
        return service.deleteProducts(Id,version);
    }



    @GetMapping("/products")
    ProductPagedQueryResponse productlimit(@RequestParam(required = false, defaultValue="5") int limit)
    {
        return projectApiRoot.products().get().addLimit(limit).executeBlocking().getBody();
    }



    @GetMapping("/products-key")
    ProductPagedQueryResponse productFilter(@RequestParam String slug)
    {
        return projectApiRoot.products().get().addWhere(slug).executeBlocking().getBody();
    }





    @GetMapping("/productProjection")
    ProductProjectionPagedSearchResponse productProjectionFilter(@RequestParam List<String> where)
    {
        return projectApiRoot.productProjections().search().get().addFilter(where).executeBlocking().getBody();
    }


    @GetMapping("/attributesValue/{id}")
    public Object getAttributeValue(@PathVariable String id)
    {
        return service.getAttributeValue(id);
    }

}
