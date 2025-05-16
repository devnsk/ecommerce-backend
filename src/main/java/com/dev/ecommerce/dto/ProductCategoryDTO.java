package com.dev.ecommerce.dto;

import com.dev.ecommerce.entity.ProductCategory;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;


public class ProductCategoryDTO {
    private Long id;
    private String categoryName;
    private Set<ProductDTO> products;

    // Constructor for creating a DTO from ProductCategory
    public ProductCategoryDTO(ProductCategory category) {
        this.id = category.getId();
        this.categoryName = category.getCategoryName();
        this.products = category.getProducts() != null
                ? category.getProducts().stream().map(ProductDTO::new).collect(Collectors.toSet())
                : null;
    }

    // Empty constructor for POST requests
    public ProductCategoryDTO() {
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProducts(Set<ProductDTO> products) {
        this.products = products;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Long getId() {
        return id;
    }

    public Set<ProductDTO> getProducts() {
        return products;
    }
}