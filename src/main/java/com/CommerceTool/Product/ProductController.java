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
    public ResponseEntity<ProductType> createProductType(@RequestBody ProductDetails productDetails)
    {
        return new ResponseEntity<>(service.createProductType(productDetails),HttpStatus.CREATED);
    }


    // Get All Product Type
    @GetMapping("/types")
    public ResponseEntity<ProductTypePagedQueryResponse> getAllProductTypes(@RequestParam String Limit)
    {
        return new ResponseEntity<>(service.getAllProductTypes(Limit),HttpStatus.OK);
    }



    // Get ProductType By id
    @GetMapping("/product-type/{id}")
    public ResponseEntity<ProductType> checkProductTypeBYId(@PathVariable String id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.checkProductTypeById(id));
    }



    // Update Product Type
    @PostMapping("/updates/{id}")
    public ResponseEntity<ProductType> updateProductType(@PathVariable String id,@RequestBody ProductDetails productDetails)
    {
        return new ResponseEntity<>(service.productTypeUpdate(id,productDetails),HttpStatus.OK);
    }



    // Create Product
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDetails productDetails)
    {
        return new ResponseEntity<>(service.createProduct(productDetails),HttpStatus.OK);
    }



    // Get All Product
    @GetMapping
    public ResponseEntity<ProductPagedQueryResponse> getProducts(@RequestParam (required = false, defaultValue="5") String limit)
    {
        return new ResponseEntity<>(service.getProducts(limit),HttpStatus.OK);
    }



    // Get Product by id
    @GetMapping("/{Id}")
    public Product getProductById(@PathVariable String Id)
    {
        return service.getProductById(Id);
    }



    @GetMapping("/price/{id}")
    public ResponseEntity<Long> getPrice(@PathVariable String id)
    {
        return new ResponseEntity<>(service.getPrice(id),HttpStatus.OK);
    }

    // Update Product
    @PostMapping("/{Id}")
    public ResponseEntity<Product> updateProducts(@PathVariable String Id, @RequestBody ProductDetails productDetails)
    {
        return new ResponseEntity<>(service.updateProducts(Id,productDetails),HttpStatus.OK);
    }



    // Delete Products
    @DeleteMapping("/{Id}")
    public ResponseEntity<Product> deleteProducts(@PathVariable String Id,@RequestParam(required = false, defaultValue="1L") long version)
    {
        return new ResponseEntity<>(service.deleteProducts(Id,version),HttpStatus.OK);
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
