package com.dev.ecommerce.service;

import com.dev.ecommerce.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
}
