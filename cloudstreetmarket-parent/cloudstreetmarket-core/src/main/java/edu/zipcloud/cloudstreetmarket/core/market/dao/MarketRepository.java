package edu.zipcloud.cloudstreetmarket.core.market.dao;

import edu.zipcloud.cloudstreetmarket.core.market.entity.Market;
import edu.zipcloud.cloudstreetmarket.core.market.entity.MarketCode;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MarketRepository extends JpaRepository<Market, MarketCode>{
    Market findByCode(MarketCode code);
}
