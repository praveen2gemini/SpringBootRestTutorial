package com.dpdlad.simplejson.products.repositary;


import com.dpdlad.simplejson.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);
}
