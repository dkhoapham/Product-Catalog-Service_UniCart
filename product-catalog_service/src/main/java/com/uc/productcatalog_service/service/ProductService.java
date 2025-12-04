package com.uc.productcatalog_service.service;

import com.uc.productcatalog_service.dto.ProductRequestDTO;
import com.uc.productcatalog_service.dto.ProductResponseDTO;
import com.uc.productcatalog_service.exception.ProductNotFoundException;
import com.uc.productcatalog_service.mapper.ProductMapper;
import com.uc.productcatalog_service.model.Product;
import com.uc.productcatalog_service.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
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
        return products
                .stream()
                .map(ProductMapper::toDTO)  //inside () means: product -> ProductMapper.toDTO(product)
                .toList();
    }

    //GET product by category
    public List<ProductResponseDTO> getProductsFilter(String category) {
        List<Product> products = productRepository.findByCategory(category);
        return products
                .stream()
                .map(ProductMapper::toDTO)
                .toList();
    }

    /* GET product by ID
    public ProductResponseDTO getProductById(String productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));
        return ProductMapper.toDTO(product);
    }*/

    // POST new product
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        try {
            Product newProduct = productRepository.save(ProductMapper.toModel(productRequestDTO));
            return ProductMapper.toDTO(newProduct);
        } catch (NumberFormatException nfe) {
            // price string could not be parsed
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid price format");
        }
    }

    // GET single product by ID
    public ProductResponseDTO getById(String prefixedId) {
        Integer id = parseId(prefixedId);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(prefixedId));
        return ProductMapper.toDTO(product);
    }

    // GET batch of product by ids
    public List<ProductResponseDTO> getBatchByIds(List<String> prefixedIds) {
        if (prefixedIds == null || prefixedIds.isEmpty()) return List.of();

        List<Integer> ids = new ArrayList<>(prefixedIds.size());
        for (String s : prefixedIds) {
            parseIdOptional(s).ifPresent(ids::add);
        }
        if (ids.isEmpty()) return List.of();

        List<Product> products = productRepository.findAllById(ids);
        return ProductMapper.toDTOs(products);
    }

    // PUT update product by ID
    public ProductResponseDTO updateProduct(String prefixedId, ProductRequestDTO productRequestDTO) {
        Integer id = parseId(prefixedId);
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(prefixedId));

        // Update the product fields
        existingProduct.setName(productRequestDTO.getProductName());
        existingProduct.setDescription(productRequestDTO.getProductDescription());
        existingProduct.setPrice(productRequestDTO.getProductPrice());
        existingProduct.setCategory(productRequestDTO.getProductCategory());

        // reset images safely
        existingProduct.setImageUrls(
                productRequestDTO.getImageUrls() == null ? List.of() : productRequestDTO.getImageUrls()
        );

        Product updatedProduct = productRepository.save(existingProduct);
        return ProductMapper.toDTO(updatedProduct);
    }

    // helpers

    // Strict parser for single fetch or update: bad format -> 400
    private Integer parseId(String productId) {
        String raw = productId == null ? "" : productId.trim();
        if (raw.startsWith("prod_")) raw = raw.substring(5);
        try {
            return Integer.valueOf(raw);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid productId format");
        }
    }

    // Lenient parser for batch: bad format -> empty Optional so we skip it
    private java.util.Optional<Integer> parseIdOptional(String productId) {
        String raw = productId == null ? "" : productId.trim();
        if (raw.startsWith("prod_")) raw = raw.substring(5);
        try {
            return java.util.Optional.of(Integer.valueOf(raw));
        } catch (NumberFormatException e) {
            return java.util.Optional.empty();
        }
    }

    // Safe price parser if your DTO uses String price
    private BigDecimal parsePrice(String raw) {
        try {
            if (raw == null) throw new NumberFormatException("null");
            return new BigDecimal(raw).setScale(2, RoundingMode.HALF_UP);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid price format");
        }
    }
}
