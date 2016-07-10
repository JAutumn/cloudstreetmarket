package edu.zipcloud.cloudstreetmarket.core.market.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.zipcloud.cloudstreetmarket.core.market.entity.Market;

public interface MarketRepository extends JpaRepository<Market, String> {

}
