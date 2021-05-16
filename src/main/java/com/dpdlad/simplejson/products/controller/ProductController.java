package com.dpdlad.simplejson.products.controller;

import com.dpdlad.simplejson.products.Product;
import com.dpdlad.simplejson.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @PostMapping("/multiProducts")
    public void addMultipleProducts(@RequestBody List<Product> products) {
        productService.saveProducts(products);
    }

    @GetMapping("/allProducts")
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }
}
