package com.Daily_CTTask.Service;


import com.Daily_CTTask.Repository.Repository;
import com.commercetools.api.models.product.ProductPagedQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Repository repository;

    public ProductPagedQueryResponse getAllProducts(String limit)
    {
     return repository.getAllProducts(limit);
    }

    public Mono<ProductPagedQueryResponse> getAllProductsByMono(String limit)
    {
        return repository.getAllProductsByMono(limit);
    }
}
