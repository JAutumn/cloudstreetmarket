package edu.zipcloud.cloudstreetmarket.core.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.zipcloud.cloudstreetmarket.core.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {


}
