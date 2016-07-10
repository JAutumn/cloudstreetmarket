package edu.zipcloud.cloudstreetmarket.core.product.converters;

import javax.persistence.NoResultException;

import edu.zipcloud.cloudstreetmarket.core.product.dao.ProductRepository;
import edu.zipcloud.cloudstreetmarket.core.product.entity.StockProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class StringToStockProduct implements Converter<String, StockProduct> {

    @Autowired
    private ProductRepository<StockProduct> productRepository;

    @Override
    public StockProduct convert(String code) {
        StockProduct stock = productRepository.findOne(code);
        if(stock == null){
            throw new NoResultException("No result has been found for the value "+code+" !");
        }
        return stock;
    }
}