package com.Daily_CTTask.Controller;

import com.Daily_CTTask.Repository.Repository;
import com.Daily_CTTask.Service.Service;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.product.Product;
import com.commercetools.api.models.product.ProductPagedQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
public class Controller {

    @Autowired
    private Service service;
    @Autowired
    private ProjectApiRoot apiRoot;
    @GetMapping("/products")
    public ProductPagedQueryResponse getAllProducts(@RequestParam(defaultValue = "500",required = false) String limit)
    {
        return service.getAllProducts(limit);
    }

}
