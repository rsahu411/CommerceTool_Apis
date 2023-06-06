package com.Daily_CTTask.Controller;

import com.Daily_CTTask.CombineAPI.CategoryCombineService;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.product.*;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class MenCategoryPLPController {

    @Autowired
    private CategoryCombineService categoryCombineService;
    @Autowired
    private ProjectApiRoot apiRoot;


    // Get
    @GetMapping("/products/men/clothing")
    public ProductProjectionPagedSearchResponse getMenClothingSubcategoriesProduct(@RequestParam(defaultValue = "",required = false)  String category,
            @RequestParam(defaultValue ="" ,required = false) String color,
            @RequestParam(defaultValue = "",required = false) String size,
            @RequestParam(defaultValue = "",required = false) String price/*,
            @RequestParam(defaultValue =" \"null\"",required = false) String facet*/) {
        int x = 0;
        if (!category.isEmpty())
            x++;
        if (!color.isEmpty())
            x++;
        if (!price.isEmpty())
            x++;
        if (!size.isEmpty())
            x++;


        System.out.println(x);

        switch (x) {
            case 1 -> {
                if (!category.isEmpty())
                    return categoryCombineService.getCategoryFilterProduct(category);
                else if (!color.isEmpty())
                    return categoryCombineService.getColorFilterProduct(color);
                else if (!size.isEmpty())
                    return categoryCombineService.getSizeFilterProduct(size);
                else
                    return categoryCombineService.getPriceFilterProduct(price);
            }
            case 2 -> {
                if (!category.isEmpty() && !color.isEmpty())
                    return categoryCombineService.getCategoryAndColorFilterProduct(category, color);
                else if (!category.isEmpty() && !size.isEmpty())
                    return categoryCombineService.getCategoryAndSizeFilterProduct(category, size);
                else if (!color.isEmpty() && !size.isEmpty())
                    return categoryCombineService.getColorAndSizeFilterProduct(color, size);
                else if (!category.isEmpty())
                    return categoryCombineService.getCategoryAndPriceFilterProduct(category, price);
                else if (!color.isEmpty())
                    return categoryCombineService.getColorAndPriceFilterProduct(color, price);
                else
                    return categoryCombineService.getPriceAndSizeFilterProduct(price, size);
            }
            case 3 -> {
                if (!category.isEmpty() && !color.isEmpty() && !size.isEmpty())
                    return categoryCombineService.getCategoryColorAndSizeFilterProduct(category, color, size);
                else if (!category.isEmpty() && !color.isEmpty())
                    return categoryCombineService.getCategoryColorAndPriceFilterProduct(category, color, price);
                else if (!color.isEmpty())
                    return categoryCombineService.getColorSizeAndPriceFilterProduct(color, size, price);
                else
                    return categoryCombineService.getCategorySizeAndPriceFilterProduct(category, size, price);
            }
            case 4 -> {
                return categoryCombineService.getCategoryColorPriceAndSizeFilterProduct(category, color, price, size);
            }
            default -> {
                return categoryCombineService.getAllProduct();
            }
        }
    }


    @GetMapping("/sort")
    public ProductProjectionPagedSearchResponse getProductsPriceSort(@RequestParam(defaultValue = "price asc",required = false)String sort)
    {
        return apiRoot.productProjections().search().get().addSort(sort).executeBlocking().getBody();
    }

}
