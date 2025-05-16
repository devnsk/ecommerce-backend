package com.dev.ecommerce.dao;

import com.dev.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    @EntityGraph(attributePaths = {"products"})
    @Query("SELECT pc FROM ProductCategory pc")
    List<ProductCategory> findAllWithProducts();
}
