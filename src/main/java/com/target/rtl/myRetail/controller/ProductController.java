package com.target.rtl.myRetail.controller;

import com.target.rtl.myRetail.entity.Product;
import com.target.rtl.myRetail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping(value="/products")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> createProduct(@RequestBody Product product)
    {
        try
        {
            Product _product = productService.createProduct(product);
            return new ResponseEntity<>(_product, HttpStatus.CREATED);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProductInfoByProductId(@PathVariable("productId") String id)
    {
        Product product = null;
        try
        {
            product = productService.getProductByproductId(id);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(product,HttpStatus.OK);
    }
    @RequestMapping(value = "/getProductName/{productId}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getProductName(@PathVariable("productId") String id)
    {
        return new ResponseEntity<String>("Product"+":"+id,HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProductInfo(@PathVariable("id") String id)
    {
       Optional<Product> product = productService.getProductById(id);
       if(product.isPresent())
       {
           return new ResponseEntity<>(product.get(), HttpStatus.OK);
       }
       else
       {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }
    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> updatePrice(@PathVariable("id") String id, @RequestBody Product product)
    {
        Optional<Product> productData = productService.getProductById(id);
        if(productData.isPresent())
        {
            Product _product = productData.get();
            _product.setPrice(product.getPrice());
            return new ResponseEntity<>(productService.createProduct(_product), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
