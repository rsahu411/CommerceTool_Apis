package com.Daily_CTTask.Repository;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.product.ProductPagedQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class Repository {

    @Autowired
    private ProjectApiRoot apiRoot;

    public ProductPagedQueryResponse getAllProducts(String limit)
    {
        return apiRoot.products().get().withLimit(limit).executeBlocking().getBody();
    }


    public Mono<ProductPagedQueryResponse> getAllProductsByMono(String limit) {
        return Mono.fromCallable(() -> apiRoot.products().get().withLimit(limit).executeBlocking().getBody());
    }
}
