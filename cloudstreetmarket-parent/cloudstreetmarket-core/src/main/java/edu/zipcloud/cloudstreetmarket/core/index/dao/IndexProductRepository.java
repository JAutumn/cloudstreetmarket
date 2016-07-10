package edu.zipcloud.cloudstreetmarket.core.index.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.zipcloud.cloudstreetmarket.core.index.entity.Index;
import edu.zipcloud.cloudstreetmarket.core.market.entity.Market;

public interface IndexProductRepository extends JpaRepository<Index, String> {

    List<Index> findByMarket(Market market);

    Index findByCode(String code);

}
