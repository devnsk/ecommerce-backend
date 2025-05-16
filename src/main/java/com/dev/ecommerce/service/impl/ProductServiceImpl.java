package com.dev.ecommerce.service.impl;

import com.dev.ecommerce.dao.ProductCategoryRepository;
import com.dev.ecommerce.dao.ProductRepository;
import com.dev.ecommerce.dto.ProductDTO;
import com.dev.ecommerce.entity.Product;
import com.dev.ecommerce.entity.ProductCategory;
import com.dev.ecommerce.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
    }

    // Create
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = new Product();
        mapDtoToProduct(productDTO, product);
        Product savedProduct = productRepository.save(product);
        return new ProductDTO(savedProduct);
    }

    // Read (All)
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }

    // Read (By ID)
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
        return new ProductDTO(product);
    }

    // Update
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
        mapDtoToProduct(productDTO, product);
        Product updatedProduct = productRepository.save(product);
        return new ProductDTO(updatedProduct);
    }

    // Delete
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }

    // Helper method to map DTO to Product
    private void mapDtoToProduct(ProductDTO productDTO, Product product) {
        product.setSku(productDTO.getSku());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setUnitPrice(productDTO.getUnitPrice());
        product.setImageUrl(productDTO.getImageUrl());
        product.setActive(productDTO.isActive());
        product.setUnitsInStock(productDTO.getUnitsInStock());
        if (productDTO.getCategoryId() != null) {
            ProductCategory category = productCategoryRepository.findById(productDTO.getCategoryId())
                    .orElseThrow(() -> new EntityNotFoundException("ProductCategory not found with id: " + productDTO.getCategoryId()));
            product.setProductCategory(category);
        }
    }
}
