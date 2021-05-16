package com.dpdlad.simplejson.products.controller;

import com.dpdlad.simplejson.products.entity.Product;
import com.dpdlad.simplejson.products.exception.ProductNotFoundException;
import com.dpdlad.simplejson.products.response.GeneralResponse;
import com.dpdlad.simplejson.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    public static final String HTTP_STATUS_MESSAGE = "You request has been submitted successfully!";
    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<GeneralResponse<Product>> addProduct(@RequestBody Product product) {
        try {
            GeneralResponse<Product> generalResponse = new GeneralResponse<>();
            generalResponse.setStatusCode(HttpStatus.OK.value());
            generalResponse.setStatusMessage(HTTP_STATUS_MESSAGE);
            generalResponse.setData(productService.saveProduct(product));
            return new ResponseEntity<>(generalResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/multiProducts")
    public ResponseEntity<GeneralResponse<Product>> addMultipleProducts(@RequestBody List<Product> products) {
        try {
            GeneralResponse<Product> generalResponse = new GeneralResponse<>();
            generalResponse.setStatusCode(HttpStatus.OK.value());
            generalResponse.setStatusMessage(HTTP_STATUS_MESSAGE);
            generalResponse.setMultiData(productService.saveProducts(products));
            return new ResponseEntity<>(generalResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/allProducts")
    public ResponseEntity<GeneralResponse<Product>> getAllProducts() {
        try {
            GeneralResponse<Product> generalResponse = new GeneralResponse<>();
            generalResponse.setStatusCode(HttpStatus.OK.value());
            generalResponse.setStatusMessage(HTTP_STATUS_MESSAGE);
            generalResponse.setMultiData(productService.getProducts());
            return new ResponseEntity<>(generalResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/productById/{id}")
    public ResponseEntity<GeneralResponse<Product>> findProductById(@PathVariable int id) { // you have to pass the value on URL path not in key values
        Product product;
        if ((product = productService.getProductById(id)) == null)
            throw new ProductNotFoundException("Product not found for given Product ID");
        GeneralResponse<Product> generalResponse = new GeneralResponse<>();
        generalResponse.setStatusCode(HttpStatus.OK.value());
        generalResponse.setStatusMessage(HTTP_STATUS_MESSAGE);
        generalResponse.setData(product);
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @GetMapping("/findProductByName")
    public ResponseEntity<GeneralResponse<Product>> findProductByName(@RequestParam String name) {
        Product product;
        if ((product = productService.getProductByName(name)) == null)
            throw new ProductNotFoundException("Product not found for given Product Name");
        GeneralResponse<Product> generalResponse = new GeneralResponse<>();
        generalResponse.setStatusCode(HttpStatus.OK.value());
        generalResponse.setStatusMessage(HTTP_STATUS_MESSAGE);
        generalResponse.setData(product);
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @PutMapping("/product")
    public ResponseEntity<GeneralResponse<Product>> updateProduct(@RequestBody Product requestedProduct) {
        Product product;
        if ((product = productService.updateProduct(requestedProduct)) == null)
            throw new ProductNotFoundException("Product not updated because given Product not found!");
        GeneralResponse<Product> generalResponse = new GeneralResponse<>();
        generalResponse.setStatusCode(HttpStatus.OK.value());
        generalResponse.setStatusMessage(HTTP_STATUS_MESSAGE);
        generalResponse.setData(product);
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @DeleteMapping("/product")
    public ResponseEntity<GeneralResponse<Product>> deleteProduct(@RequestParam int id) {
        try {
            GeneralResponse<Product> generalResponse = new GeneralResponse<>();
            generalResponse.setStatusCode(HttpStatus.OK.value());
            generalResponse.setStatusMessage(productService.deleteProduct(id));
            generalResponse.setData(null);
            return new ResponseEntity<>(generalResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
