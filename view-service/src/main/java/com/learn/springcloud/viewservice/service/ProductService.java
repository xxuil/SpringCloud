package com.learn.springcloud.viewservice.service;


import com.learn.springcloud.viewservice.client.ProductClient;
import com.learn.springcloud.viewservice.pojo.Product;
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
