package edu.zipcloud.cloudstreetmarket.api.controllers;

import com.wordnik.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "products", description = "Financial products") // Swagger annotation
@RestController
@RequestMapping(ProductController.PRODUCT_PATH)
public class ProductController extends CloudstreetApiWCI {
    public static final String PRODUCT_PATH = "/products";

}