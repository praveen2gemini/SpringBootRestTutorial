package com.dpdlad.simplejson.products.controller;

import com.dpdlad.simplejson.products.entity.Product;
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
    public ResponseEntity<GeneralResponse<Product>> findProductById(@PathVariable int id) {
        try {
            GeneralResponse<Product> generalResponse = new GeneralResponse<>();
            generalResponse.setStatusCode(HttpStatus.OK.value());
            generalResponse.setStatusMessage(HTTP_STATUS_MESSAGE);
            generalResponse.setData(productService.getProductById(id));
            return new ResponseEntity<>(generalResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{name}")
    public ResponseEntity<GeneralResponse<Product>> findProductByName(@PathVariable String name) {
        try {
            GeneralResponse<Product> generalResponse = new GeneralResponse<>();
            generalResponse.setStatusCode(HttpStatus.OK.value());
            generalResponse.setStatusMessage(HTTP_STATUS_MESSAGE);
            generalResponse.setData(productService.getProductByName(name));
            return new ResponseEntity<>(generalResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<GeneralResponse<Product>> updateProduct(@RequestBody Product product) {
        try {
            GeneralResponse<Product> generalResponse = new GeneralResponse<>();
            generalResponse.setStatusCode(HttpStatus.OK.value());
            generalResponse.setStatusMessage(HTTP_STATUS_MESSAGE);
            generalResponse.setData(productService.updateProduct(product));
            return new ResponseEntity<>(generalResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GeneralResponse<Product>> deleteProduct(@PathVariable int id) {
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
