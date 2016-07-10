package edu.zipcloud.cloudstreetmarket.core.product.service;

import edu.zipcloud.cloudstreetmarket.core.product.dto.ProductOverviewDTO;
import edu.zipcloud.cloudstreetmarket.core.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


public interface IProductService<T extends Product, U extends ProductOverviewDTO> {
    Page<U> getProductsOverview(String startWith, Specification<T> spec, Pageable pageable);
}
