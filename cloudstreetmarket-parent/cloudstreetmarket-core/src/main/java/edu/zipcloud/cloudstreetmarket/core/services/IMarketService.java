package edu.zipcloud.cloudstreetmarket.core.services;

import java.util.List;

import edu.zipcloud.cloudstreetmarket.core.dtos.DailyMarketActivityDTO;
import edu.zipcloud.cloudstreetmarket.core.dtos.IndexOverviewDTO;
import edu.zipcloud.cloudstreetmarket.core.dtos.MarketOverviewDTO;

public interface IMarketService {
    DailyMarketActivityDTO getLastDayIndexActivity(String code);
    List<IndexOverviewDTO> getLastDayIndexOverview(String market);
}

