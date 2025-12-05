package com.uc.productcatalog_service.controller;

import com.uc.productcatalog_service.dto.ProductRequestDTO;
import com.uc.productcatalog_service.dto.ProductResponseDTO;
import com.uc.productcatalog_service.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController { //handle HTTP request&response
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET all products
    @GetMapping
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
        // Build Location: /api/products/{id}
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()               // /api/products
                .path("/{id}")                      // append /{id}
                .buildAndExpand(productResponseDTO.getProductId())
                .toUri();
        return ResponseEntity.created(location).body(productResponseDTO); // status 201
    }


    // GET single product by ID
    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable String productId) {
        ProductResponseDTO product = productService.getById(productId);
        return ResponseEntity.ok(product);
    }

    // GET batch of product
    @GetMapping("/batch")
    public ResponseEntity<List<ProductResponseDTO>> getProductsBatch(@RequestParam(required = false) List<String> ids) {
        @Size(max = 100, message = "Max 100 ids per request")
        List<ProductResponseDTO> customers = productService.getBatchByIds(ids);
        return ResponseEntity.ok(customers);
    }

    // PUT update a product by ID (Admin)
    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @PathVariable String productId,
            @Valid @RequestBody ProductRequestDTO productRequestDTO) {
        ProductResponseDTO updatedProduct = productService.updateProduct(productId, productRequestDTO);
        return ResponseEntity.ok(updatedProduct);
    }

    // Optional API end points

    // DELETE one product by id
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {
        productService.deleteById(productId);   // throws ProductNotFoundException if missing
        return ResponseEntity.noContent().build(); // 204
    }

    // delete all product (dev/admin only)
    @DeleteMapping
    public ResponseEntity<Void> deleteAllProducts() {
        productService.deleteAll();
        return ResponseEntity.noContent().build(); // 204
    }
}

