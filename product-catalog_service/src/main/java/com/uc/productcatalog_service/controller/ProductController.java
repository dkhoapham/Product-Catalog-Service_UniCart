package com.uc.productcatalog_service.controller;

import com.uc.productcatalog_service.dto.ProductRequestDTO;
import com.uc.productcatalog_service.dto.ProductResponseDTO;
import com.uc.productcatalog_service.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController { //handle HTTP request&response
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET all products
    @GetMapping("/products")
    public ResponseEntity<List<ProductResponseDTO>> getProducts(@RequestParam(required = false) String category) {
        if (category == null) { // return all products w/out filter
            List<ProductResponseDTO> productResponseDTOS = productService.getProducts();
            return ResponseEntity.ok().body(productResponseDTOS); //Status 200
        }
        List<ProductResponseDTO> productResponseDTOS = productService.getProductsFilter(category);
        return ResponseEntity.ok().body(productResponseDTOS);
    }

    // POST a product
    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO) {
        ProductResponseDTO productResponseDTO = productService.createProduct(productRequestDTO);
        URI location = URI.create("/products/" + productResponseDTO.getProductId());
        return ResponseEntity.created(location).body(productResponseDTO); //status 201
    }
}
