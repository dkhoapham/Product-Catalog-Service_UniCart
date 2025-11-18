package com.uc.productcatalog_service.service;

import com.uc.productcatalog_service.dto.ProductRequestDTO;
import com.uc.productcatalog_service.dto.ProductResponseDTO;
import com.uc.productcatalog_service.mapper.ProductMapper;
import com.uc.productcatalog_service.model.Product;
import com.uc.productcatalog_service.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService { // business logic
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // GET all products
    public List<ProductResponseDTO> getProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDTO> productResponseDTOS = products.stream()
                                                               .map(ProductMapper::toDTO) //inside () means: product -> ProductMapper.toDTO(product)
                                                               .toList();
        return productResponseDTOS;
    }

    //GET product by category
    public List<ProductResponseDTO> getProductsFilter(String category) {
        List<Product> products = productRepository.findByCategory(category);
        List<ProductResponseDTO> productResponseDTOS = products.stream()
                                                               .map(ProductMapper::toDTO)
                                                               .toList();
        return productResponseDTOS;
    }

    // POST new product
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product newProduct = productRepository.save(ProductMapper.toModel(productRequestDTO));
        return ProductMapper.toDTO(newProduct);
    }
}