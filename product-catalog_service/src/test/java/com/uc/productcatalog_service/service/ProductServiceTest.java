package com.uc.productcatalog_service.service;

import com.uc.productcatalog_service.dto.ProductRequestDTO;
import com.uc.productcatalog_service.dto.ProductResponseDTO;
import com.uc.productcatalog_service.exception.ProductNotFoundException;
import com.uc.productcatalog_service.model.Product;
import com.uc.productcatalog_service.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    void setUp() {
        productRepository = Mockito.mock(ProductRepository.class);
        productService = new ProductService(productRepository);
    }

    @Test
    void testGetById_ReturnsProduct() {
        Product product = new Product();

        // prevent null imageUrls (fix for NPE)
        product.setImageUrls(new ArrayList<>());

        // use reflection to set the private 'id' field
        try {
            var idField = Product.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(product, "11111111-1111-1111-1111-111111111111");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        product.setName("TrackIt Planner");
        product.setDescription("A productivity planner app");
        product.setPrice(new BigDecimal("19.99"));
        product.setCategory("Productivity");

        when(productRepository.findById(1))
                .thenReturn(Optional.of(product));

        ProductResponseDTO result =
                productService.getById("prod_1");

        assertEquals("TrackIt Planner", result.getProductName());
        assertEquals("Productivity", result.getProductCategory());
        verify(productRepository, times(1))
                .findById(1);
    }

    @Test
    void testGetById_Throws_WhenNotFound() {
        when(productRepository.findById(2))
                .thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () ->
                productService.getById("prod_2"));
    }

    @Test
    void testUpdateProduct_Success() {
        // Create existing product
        Product existingProduct = new Product();
        existingProduct.setImageUrls(new ArrayList<>());
        
        try {
            var idField = Product.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(existingProduct, 1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        existingProduct.setName("Old Product Name");
        existingProduct.setDescription("Old Description");
        existingProduct.setPrice(new BigDecimal("99.99"));
        existingProduct.setCategory("Old Category");
        existingProduct.setImageUrls(Arrays.asList("old-image.jpg"));

        // Create update request
        ProductRequestDTO updateRequest = new ProductRequestDTO();
        updateRequest.setProductName("Updated Product Name");
        updateRequest.setProductDescription("Updated Description");
        updateRequest.setProductPrice("199.99");
        updateRequest.setProductCategory("Updated Category");
        updateRequest.setImageUrls(Arrays.asList("new-image1.jpg", "new-image2.jpg"));

        // Mock repository behavior
        when(productRepository.findById(1)).thenReturn(Optional.of(existingProduct));
        when(productRepository.save(any(Product.class))).thenReturn(existingProduct);

        // Execute update
        ProductResponseDTO result = productService.updateProduct("prod_1", updateRequest);

        // Verify results
        assertEquals("Updated Product Name", result.getProductName());
        assertEquals("Updated Description", result.getProductDescription());
        assertEquals("199.99", result.getProductPrice());
        assertEquals("Updated Category", result.getProductCategory());
        
        // Verify repository interactions
        verify(productRepository, times(1)).findById(1);
        verify(productRepository, times(1)).save(existingProduct);
    }

    @Test
    void testUpdateProduct_ThrowsNotFoundException() {
        ProductRequestDTO updateRequest = new ProductRequestDTO();
        updateRequest.setProductName("Updated Product");
        updateRequest.setProductDescription("Updated Description");
        updateRequest.setProductPrice("199.99");
        updateRequest.setProductCategory("Updated Category");
        updateRequest.setImageUrls(Arrays.asList("image.jpg"));

        when(productRepository.findById(999)).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, () ->
                productService.updateProduct("prod_999", updateRequest));
        
        verify(productRepository, times(1)).findById(999);
        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    void testUpdateProduct_UpdatesAllFields() {
        Product existingProduct = new Product();
        List<String> oldImages = new ArrayList<>(Arrays.asList("old1.jpg", "old2.jpg"));
        existingProduct.setImageUrls(oldImages);
        
        try {
            var idField = Product.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(existingProduct, 5);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        existingProduct.setName("Original Name");
        existingProduct.setDescription("Original Description");
        existingProduct.setPrice(new BigDecimal("50.00"));
        existingProduct.setCategory("Original Category");

        ProductRequestDTO updateRequest = new ProductRequestDTO();
        updateRequest.setProductName("New Name");
        updateRequest.setProductDescription("New Description");
        updateRequest.setProductPrice("75.50");
        updateRequest.setProductCategory("New Category");
        updateRequest.setImageUrls(Arrays.asList("new1.jpg", "new2.jpg", "new3.jpg"));

        when(productRepository.findById(5)).thenReturn(Optional.of(existingProduct));
        when(productRepository.save(any(Product.class))).thenReturn(existingProduct);

        productService.updateProduct("prod_5", updateRequest);

        // Verify all fields are updated
        assertEquals("New Name", existingProduct.getName());
        assertEquals("New Description", existingProduct.getDescription());
        assertEquals(new BigDecimal("75.50"), existingProduct.getPrice());
        assertEquals("New Category", existingProduct.getCategory());
        assertTrue(existingProduct.getImageUrls().contains("new1.jpg"));
        assertTrue(existingProduct.getImageUrls().contains("new2.jpg"));
        assertTrue(existingProduct.getImageUrls().contains("new3.jpg"));
        
        verify(productRepository, times(1)).save(existingProduct);
    }
}