package com.Daily_CTTask.CombineAPI;

import com.Daily_CTTask.Repository.CategoryRepository;
import com.commercetools.api.models.product.ProductProjectionPagedSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryCombineService {

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductProjectionPagedSearchResponse getAllProduct()
    {
        return categoryRepository.getAllProduct();
    }
    public ProductProjectionPagedSearchResponse getCategoryFilterProduct(String category)
    {
        return categoryRepository.getCategoryFilterProduct(category);
    }

    public ProductProjectionPagedSearchResponse getSizeFilterProduct(String size)
    {
        return categoryRepository.getSizeFilterProduct(size);
    }

    public ProductProjectionPagedSearchResponse getColorFilterProduct(String color)
    {
        return categoryRepository.getColorFilterProduct(color);
    }

    public ProductProjectionPagedSearchResponse getPriceFilterProduct(String price)
    {
        return categoryRepository.getPriceFilterProduct(price);
    }

    public ProductProjectionPagedSearchResponse getCategoryAndSizeFilterProduct(String category, String size)
    {
        return categoryRepository.getCategoryAndSizeFilterProduct(category,size);
    }

    public ProductProjectionPagedSearchResponse getCategoryAndPriceFilterProduct(String category, String price)
    {
        return categoryRepository.getCategoryAndPriceFilterProduct(category,price);
    }


    public ProductProjectionPagedSearchResponse getCategoryAndColorFilterProduct(String category, String color)
    {
        return categoryRepository.getCategoryAndColorFilterProduct(category,color);
    }


    public ProductProjectionPagedSearchResponse getColorAndPriceFilterProduct(String color, String price)
    {
        return categoryRepository.getColorAndPriceFilterProduct(color,price);
    }

    public ProductProjectionPagedSearchResponse getColorAndSizeFilterProduct(String color,String size)
    {
        return categoryRepository.getColorAndSizeFilterProduct(color,size);
    }


    public ProductProjectionPagedSearchResponse getPriceAndSizeFilterProduct(String price,String size)
    {
        return categoryRepository.getPriceAndSizeFilterProduct(price,size);
    }


    public ProductProjectionPagedSearchResponse getCategoryColorAndSizeFilterProduct(String category, String color, String size)
    {
        return categoryRepository.getCategoryColorAndSizeFilterProduct(category,color,size);
    }


    public ProductProjectionPagedSearchResponse getCategoryColorAndPriceFilterProduct(String category,String color, String price)
    {
        return categoryRepository.getCategoryColorAndPriceFilterProduct(category,color,price);
    }

    public ProductProjectionPagedSearchResponse getCategorySizeAndPriceFilterProduct(String category, String size, String price) {

        return categoryRepository.getCategorySizeAndPriceFilterProduct(category,size,price);
    }

    public ProductProjectionPagedSearchResponse getColorSizeAndPriceFilterProduct(String color, String size, String price) {

        return categoryRepository.getColorSizeAndPriceFilterProduct(color,size,price);

    }

    public ProductProjectionPagedSearchResponse getCategoryColorPriceAndSizeFilterProduct(String category, String color, String price, String size) {

        return categoryRepository.getCategoryColorPriceAndSizeFilterProduct(category,color,price,size);
    }
}
