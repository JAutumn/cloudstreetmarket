package edu.zipcloud.cloudstreetmarket.core.product.dao;

import edu.zipcloud.cloudstreetmarket.core.market.entity.Market;
import edu.zipcloud.cloudstreetmarket.core.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository<T extends Product> extends JpaRepository<T, String>, JpaSpecificationExecutor<T> {

    Page<T> findByMarket(Market marketEntity, Pageable pageable);
    Page<T> findByNameStartingWith(String param, Pageable pageable);
    Page<T> findByNameStartingWith(String param, Specification<T> spec, Pageable pageable);
}
