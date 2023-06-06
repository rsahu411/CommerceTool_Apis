package com.Daily_CTTask.Repository.NavBar;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.category.Category;
import com.commercetools.api.models.category.CategoryPagedQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NavBarRepository {

    @Autowired
    private ProjectApiRoot apiRoot;

    public List<Category> getAllMainCategories()
    {
        CategoryPagedQueryResponse queryResponse = apiRoot.categories().get().executeBlocking().getBody();
        List<Category> categories = queryResponse.getResults().stream().filter(category -> category.getAncestors().isEmpty()).collect(Collectors.toList());
        return categories;
    }

    public CategoryPagedQueryResponse getAllMainParentCategories()
    {
        return apiRoot.categories().get().withWhere("ancestors is empty").executeBlocking().getBody();
    }
}
