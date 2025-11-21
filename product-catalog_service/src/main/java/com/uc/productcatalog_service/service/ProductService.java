package com.uc.productcatalog_service.service;

import com.uc.productcatalog_service.dto.ProductRequestDTO;
import com.uc.productcatalog_service.dto.ProductResponseDTO;
import com.uc.productcatalog_service.exception.ProductNotFoundException;
import com.uc.productcatalog_service.mapper.ProductMapper;
import com.uc.productcatalog_service.model.Product;
import com.uc.productcatalog_service.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService { // business logic
    private final ProductRepository productRepository;

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

    /* GET product by ID
    public ProductResponseDTO getProductById(String productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));
        return ProductMapper.toDTO(product);
    }*/

    // POST new product
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product newProduct = productRepository.save(ProductMapper.toModel(productRequestDTO));
        return ProductMapper.toDTO(newProduct);
    }

     // GET single product by ID
    public ProductResponseDTO getById(String prefixedId) {
        Integer id = Integer.parseInt(prefixedId.replace("prod_", ""));
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException(prefixedId));
        return ProductMapper.toDTO(product);
    }

    // GET batch of product by ids
    public List<ProductResponseDTO> getBatchByIds(List<String> prefixedIds) {
        List<Integer> ids = prefixedIds.stream()
                .map(id -> Integer.parseInt(id.replace("prod_", "")))
                .collect(Collectors.toList());

        List<Product> products = productRepository.findAllById(ids);
        return ProductMapper.toDTOs(products);
    }
}
