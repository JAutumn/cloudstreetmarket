package edu.zipcloud.cloudstreetmarket.core.index.dao;

import java.util.List;

import edu.zipcloud.cloudstreetmarket.core.index.entity.Index;
import edu.zipcloud.cloudstreetmarket.core.market.entity.Market;
import edu.zipcloud.cloudstreetmarket.core.market.entity.MarketCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IndexRepository {
    List<Index> findByMarket(Market market);
    Page<Index> findByMarket(Market market, Pageable pageable);
    List<Index> findAll();
    Page<Index> findAll(Pageable pageable);
    Index findByCode(MarketCode code);
}
