package com.target.rtl.myRetail.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collection="products")
public class Product {
    @Id
    private String id;
    public String productId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String title;
    public double price;
    public String currency;

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productId='" + productId + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                '}';
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
