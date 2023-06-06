package com.Daily_CTTask.Service.NavBar;

import com.Daily_CTTask.Repository.NavBar.NavBarRepository;
import com.commercetools.api.models.category.Category;
import com.commercetools.api.models.category.CategoryPagedQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavBarService {

    @Autowired
    private NavBarRepository navBarRepository;

    public List<Category> getAllMainCategories()
    {
        return navBarRepository.getAllMainCategories();
    }

    public CategoryPagedQueryResponse getAllMainParentCategories()
    {
        return navBarRepository.getAllMainParentCategories();
    }
}
