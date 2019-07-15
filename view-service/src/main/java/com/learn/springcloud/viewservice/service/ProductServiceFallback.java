package com.learn.springcloud.viewservice.service;


import com.learn.springcloud.viewservice.client.ProductClient;
import com.learn.springcloud.viewservice.pojo.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceFallback implements ProductClient {
    @Override
    public List<Product> listProducts() {
        return new ArrayList<>();
    }
}
