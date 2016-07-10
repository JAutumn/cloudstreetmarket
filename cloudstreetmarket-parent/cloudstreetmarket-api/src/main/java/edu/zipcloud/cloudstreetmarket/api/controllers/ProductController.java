package edu.zipcloud.cloudstreetmarket.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ProductController.PRODUCT_PATH)
public class ProductController extends CloudstreetApiWCI {
    public static final String PRODUCT_PATH = "/products";

}