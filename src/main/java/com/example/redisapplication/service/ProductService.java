package com.example.redisapplication.service;

import com.example.redisapplication.model.Product;
import com.example.redisapplication.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Product getProduct(int id){
        return productRepository.findById(id).get();
    }

    public String deleteProduct(int id){
        productRepository.deleteById(id);
        return "Deleted";
    }

    public List<Product> getQuantitiesLessThan(int quantity){
        return getAllProducts().stream()
                .filter(product -> product.getQuantity() <= quantity)
                .toList();
    }

}
