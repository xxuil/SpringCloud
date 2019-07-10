package com.learn.springcloud.dataservice.controller;

import com.learn.springcloud.dataservice.pojo.Product;
import com.learn.springcloud.dataservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public Object products() {
        List<Product> ps = productService.listProduct();
        return ps;
    }
}
