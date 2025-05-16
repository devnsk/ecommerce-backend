package com.dev.ecommerce.controller;

import com.dev.ecommerce.dto.ProductCategoryDTO;
import com.dev.ecommerce.service.impl.ProductCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-categories")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    // Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductCategoryDTO createProductCategory(@RequestBody ProductCategoryDTO categoryDTO) {
        return productCategoryService.createProductCategory(categoryDTO);
    }

    // Read (All)
    @GetMapping
    public List<ProductCategoryDTO> getAllProductCategories() {
        return productCategoryService.getAllProductCategories();
    }

    // Read (By ID)
    @GetMapping("/{id}")
    public ProductCategoryDTO getProductCategoryById(@PathVariable Long id) {
        return productCategoryService.getProductCategoryById(id);
    }

    // Update
    @PutMapping("/{id}")
    public ProductCategoryDTO updateProductCategory(@PathVariable Long id, @RequestBody ProductCategoryDTO categoryDTO) {
        return productCategoryService.updateProductCategory(id, categoryDTO);
    }

    // Delete
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductCategory(@PathVariable Long id) {
        productCategoryService.deleteProductCategory(id);
    }
}