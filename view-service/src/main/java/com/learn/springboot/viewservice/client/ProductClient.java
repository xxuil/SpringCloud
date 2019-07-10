package com.learn.springboot.viewservice.client;


import com.learn.springboot.viewservice.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "DATA-SERVICE")
public interface ProductClient {
    @GetMapping("/products")
    List<Product> listProducts();
}
