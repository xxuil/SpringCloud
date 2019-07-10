package com.learn.springboot.viewservice.service;


import com.learn.springboot.viewservice.client.ProductClient;
import com.learn.springboot.viewservice.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductClient productClient;

    public List<Product> listProducts() {
        return productClient.listProducts();
    }
}
