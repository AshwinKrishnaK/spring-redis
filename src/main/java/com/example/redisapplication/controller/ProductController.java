package com.example.redisapplication.controller;

import com.example.redisapplication.model.Product;
import com.example.redisapplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") int id){
        return productService.getProduct(id);
    }

    @PostMapping("/")
    public String saveProduct(@RequestBody Product product){
        return  productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        return productService.deleteProduct(id);
    }

    @PostMapping("/{id}")
    public Product updateProduct(@PathVariable("id") int id, @RequestBody Product product){
        return productService.updateProduct(id,product);
    }

}
