package com.Daily_CTTask.Controller.NavBar;

import com.Daily_CTTask.Service.NavBar.NavBarService;
import com.commercetools.api.models.category.Category;
import com.commercetools.api.models.category.CategoryPagedQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NavBarController {

    @Autowired
    private NavBarService navBarService;

    // Get all main parent category
    @GetMapping("/parent-category")
    public List<Category> test(){
        return navBarService.getAllMainCategories();
    }

    // Method 2
    @GetMapping("/parent-category2")
    public CategoryPagedQueryResponse getAllMainParentCategories()
    {
        return navBarService.getAllMainParentCategories();
    }
}
