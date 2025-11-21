package com.uc.productcatalog_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

public class ProductRequestDTO { //POST

    @NotBlank(message = "Product Name required")
    @Size(min = 1, max = 255)
    private String productName;

    @NotBlank(message = "Description of product required")
    private String productDescription;

    @NotBlank(message = "Product Price required")
    private String productPrice;

    @NotBlank(message = "Category of product required")
    private String productCategory;

    @NotEmpty(message = "Image/s of product required")
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
