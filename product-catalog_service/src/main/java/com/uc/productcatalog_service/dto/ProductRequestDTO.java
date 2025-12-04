package com.uc.productcatalog_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductRequestDTO { //POST

    @NotBlank(message = "Product Name required")
    @Size(min = 1, max = 255)
    @JsonProperty("productName")
    private String productName;

    @NotBlank(message = "Description of product required")
    @JsonProperty("productDescription")
    private String productDescription;

    @NotNull(message = "Product Price required")
    @DecimalMin(value = "0.00", message = "Price must be >= 0.00")
    @Digits(integer = 10, fraction = 2)
    @JsonProperty("productPrice")
    private BigDecimal productPrice;

    @NotBlank(message = "Category of product required")
    @Size(max = 64)
    @JsonProperty("productCategory")
    private String productCategory;

    @NotNull(message = "Image/s of product required")
    @Size(min = 1, message = "At least one image URL is required")
    private List<@URL(message = "Each image must be a valid URL") String> imageUrls = new ArrayList<>();

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

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
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
        this.imageUrls = (imageUrls == null) ? new ArrayList<>() : new ArrayList<>(imageUrls);
    }
}
