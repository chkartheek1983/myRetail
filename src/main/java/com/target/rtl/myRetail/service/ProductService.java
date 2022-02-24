package com.target.rtl.myRetail.service;

import com.target.rtl.myRetail.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.target.rtl.myRetail.entity.Product;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@Component
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Value("${prdtinfo.url}")
    private String url;

    public ProductService(){

    }
    public Product createProduct(Product product)
    {
        try
        {
            WebClient webClient = WebClient.create(url);
            Mono<String> result = webClient.get()
                    .uri(product.getProductId())
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .retrieve()
                    .bodyToMono(String.class);
            product.setTitle(result.block());
        }
        catch(Exception e)
        {
            product.setTitle("");
        }
        Product _product = productRepository.save(product);
        return _product;
    }
    public Optional<Product> getProductById(String productId)
    {
        Optional<Product> product = productRepository.findById(productId);
        return product;
    }
    public Product getProductByproductId(String productId)
    {
        Product product = productRepository.getProductByproductId(productId);
        return product;
    }

}
