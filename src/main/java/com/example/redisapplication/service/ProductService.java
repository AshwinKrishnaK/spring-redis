package com.example.redisapplication.service;

import com.example.redisapplication.model.Product;
import com.example.redisapplication.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public String saveProduct(Product product){
        productRepository.save(product);
        return "Saved";
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Cacheable(value = "product", key = "#id")
    public Product getProduct(int id){
        System.out.println("Fetching from DB for id: " + id);
        return productRepository.findById(id).orElse(null);
    }

    @CacheEvict(key = "#id",value = "product")
    public String deleteProduct(int id){
        productRepository.deleteById(id);
        return "Deleted";
    }

    @CachePut(value = "product",key = "#id")
    public Product updateProduct(int id, Product product){
        Product product1 = productRepository.findById(id).orElseThrow();
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setQuantity(product.getQuantity());
        return productRepository.save(product1);
    }

    public List<Product> getQuantitiesLessThan(int quantity){
        return getAllProducts().stream()
                .filter(product -> product.getQuantity() <= quantity)
                .toList();
    }

}
