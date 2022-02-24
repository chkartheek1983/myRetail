package com.target.rtl.myRetail.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.target.rtl.myRetail.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String>{
    Product getProductByproductId(String productId);
}
