package com.dev.ecommerce.service.impl;

import com.dev.ecommerce.dao.ProductCategoryRepository;
import com.dev.ecommerce.dto.ProductCategoryDTO;
import com.dev.ecommerce.entity.ProductCategory;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    // Create
    public ProductCategoryDTO createProductCategory(ProductCategoryDTO categoryDTO) {
        ProductCategory category = new ProductCategory();
        category.setCategoryName(categoryDTO.getCategoryName());
        ProductCategory savedCategory = productCategoryRepository.save(category);
        return new ProductCategoryDTO(savedCategory);
    }

    // Read (All, with products)
    public List<ProductCategoryDTO> getAllProductCategories() {
        return productCategoryRepository.findAllWithProducts().stream()
                .map(ProductCategoryDTO::new)
                .collect(Collectors.toList());
    }

    // Read (By ID, with products)
    public ProductCategoryDTO getProductCategoryById(Long id) {
        ProductCategory category = productCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ProductCategory not found with id: " + id));
        // Explicitly initialize products since fetch type is LAZY
        category.getProducts().size(); // Forces initialization
        return new ProductCategoryDTO(category);
    }

    // Update
    public ProductCategoryDTO updateProductCategory(Long id, ProductCategoryDTO categoryDTO) {
        ProductCategory category = productCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ProductCategory not found with id: " + id));
        category.setCategoryName(categoryDTO.getCategoryName());
        ProductCategory updatedCategory = productCategoryRepository.save(category);
        return new ProductCategoryDTO(updatedCategory);
    }

    // Delete
    public void deleteProductCategory(Long id) {
        if (!productCategoryRepository.existsById(id)) {
            throw new EntityNotFoundException("ProductCategory not found with id: " + id);
        }
        productCategoryRepository.deleteById(id);
    }
}
