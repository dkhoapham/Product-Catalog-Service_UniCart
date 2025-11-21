package com.uc.productcatalog_service.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class ProductRequestDTO { //POST

    @NotBlank (message = "Product Name required")
    private String productName;

    private String productDescription;

    @NotBlank(message = "Product Price required")
    private String productPrice;

    private String productCategory;
    private List<String> imageUrls;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
}
