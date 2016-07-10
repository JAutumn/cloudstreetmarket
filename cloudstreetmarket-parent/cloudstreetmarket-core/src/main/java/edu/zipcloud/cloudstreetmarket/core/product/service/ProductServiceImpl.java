package edu.zipcloud.cloudstreetmarket.core.product.service;

import java.util.LinkedList;
import java.util.List;

import edu.zipcloud.cloudstreetmarket.core.market.dao.MarketRepository;
import edu.zipcloud.cloudstreetmarket.core.product.dao.ProductRepository;
import edu.zipcloud.cloudstreetmarket.core.product.dto.ProductOverviewDTO;
import edu.zipcloud.cloudstreetmarket.core.product.entity.Product;
import edu.zipcloud.cloudstreetmarket.core.product.specification.ProductSpecifications;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl<T extends Product, U extends ProductOverviewDTO> implements IProductService<T, U> {

    @Autowired
    private ProductRepository<T> productRepository;

    @Autowired
    private MarketRepository marketRepository;

    @Override
    public Page<U> getProductsOverview(String startWith, Specification<T> spec, Pageable pageable) {

        if (StringUtils.isNotBlank(startWith)) {
            spec = Specifications.where(spec).and(new ProductSpecifications<T>().nameStartsWith(startWith));
        }

        Page<T> products = productRepository.findAll(spec, pageable);

        return new PageImpl<>(transformTypedProductsInDTOs(products), pageable, products.getTotalElements());
    }

    @SuppressWarnings("unchecked")
    private List<U> transformTypedProductsInDTOs(Iterable<T> products) {
        List<U> results = new LinkedList<>();
        for (T product : products) {
            results.add((U) U.build(product));
        }
        return results;
    }
}
