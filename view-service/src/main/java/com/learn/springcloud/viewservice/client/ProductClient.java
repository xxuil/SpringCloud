package com.learn.springcloud.viewservice.client;


import com.learn.springcloud.viewservice.pojo.Product;
import com.learn.springcloud.viewservice.service.ProductServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "DATA-SERVICE", fallback = ProductServiceFallback.class)
public interface ProductClient {
    @GetMapping("/products")
    List<Product> listProducts();
}
