package com.uc.productcatalog_service.mapper;

import com.uc.productcatalog_service.dto.ProductRequestDTO;
import com.uc.productcatalog_service.dto.ProductResponseDTO;
import com.uc.productcatalog_service.model.Product;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductMapper {
    public static ProductResponseDTO toDTO(Product product) {
        ProductResponseDTO productDTO = new ProductResponseDTO();
        productDTO.setProductId(product.getId());
        productDTO.setProductName(product.getName());
        productDTO.setProductDescription(product.getDescription());
        productDTO.setProductPrice(product.getPrice().toString());
        productDTO.setProductCategory(product.getCategory());
        productDTO.setImageUrls(product.getImageUrls());
        return productDTO;
    }

    public static Product toModel(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setName(productRequestDTO.getProductName());
        product.setDescription(productRequestDTO.getProductDescription());
        product.setPrice(new BigDecimal(productRequestDTO.getProductPrice()));
        product.setCategory(productRequestDTO.getProductCategory());
        product.setImageUrls(productRequestDTO.getImageUrls());
        return product;
    }
}
