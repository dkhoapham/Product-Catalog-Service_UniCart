package com.uc.productcatalog_service.service;

import com.uc.productcatalog_service.dto.ProductResponseDTO;
import com.uc.productcatalog_service.model.Product;
import com.uc.productcatalog_service.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
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

        when(productRepository.findById("11111111-1111-1111-1111-111111111111"))
                .thenReturn(Optional.of(product));

        ProductResponseDTO result =
                productService.getById("11111111-1111-1111-1111-111111111111");

        assertEquals("TrackIt Planner", result.getProductName());
        assertEquals("Productivity", result.getProductCategory());
        verify(productRepository, times(1))
                .findById("11111111-1111-1111-1111-111111111111");
    }

    @Test
    void testGetById_Throws_WhenNotFound() {
        when(productRepository.findById("99999999-9999-9999-9999-999999999999"))
                .thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () ->
                productService.getById("99999999-9999-9999-9999-999999999999"));
    }
}