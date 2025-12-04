package com.uc.productcatalog_service.mapper;

import com.uc.productcatalog_service.dto.ProductRequestDTO;
import com.uc.productcatalog_service.dto.ProductResponseDTO;
import com.uc.productcatalog_service.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    public static ProductResponseDTO toDTO(Product product) {
        ProductResponseDTO productDTO = new ProductResponseDTO();
        productDTO.setProductId("prod_" + product.getId());
        productDTO.setProductName(product.getName());
        productDTO.setProductDescription(product.getDescription());
        productDTO.setProductPrice(product.getPrice());
        productDTO.setProductCategory(product.getCategory());
        List<String> urls = product.getImageUrls() == null ? List.of() : product.getImageUrls();
        productDTO.setImageUrls(urls);
        // set primary image
        productDTO.setPrimaryImageUrl(urls.isEmpty() ? null : urls.get(0));
        return productDTO;
    }

    public static List<ProductResponseDTO> toDTOs(List<Product> products) {
        if (products == null || products.isEmpty()) return List.of();
        List<ProductResponseDTO>  productDTOs = new ArrayList<>();
        for (Product product : products) productDTOs.add(toDTO(product));
        return productDTOs;
    }

    public static Product toModel(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setName(productRequestDTO.getProductName());
        product.setDescription(productRequestDTO.getProductDescription());
        product.setPrice(productRequestDTO.getProductPrice());
        product.setCategory(productRequestDTO.getProductCategory());
        product.setImageUrls(productRequestDTO.getImageUrls() == null ? List.of() : productRequestDTO.getImageUrls());
        return product;
    }
}
