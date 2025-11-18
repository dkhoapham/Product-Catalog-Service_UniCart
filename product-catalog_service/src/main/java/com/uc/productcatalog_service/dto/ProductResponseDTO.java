package com.uc.productcatalog_service.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductResponseDTO { //GET
    private String productId;
    private String productName;
    private String productDescription;
    private String productPrice;
    private String productCategory;
    private List<String> imageUrls;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

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
        if(this.imageUrls == null) this.imageUrls = new ArrayList<>();
        this.imageUrls.addAll(imageUrls);
    }
}
