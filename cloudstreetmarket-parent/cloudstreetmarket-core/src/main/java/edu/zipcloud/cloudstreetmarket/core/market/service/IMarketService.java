package edu.zipcloud.cloudstreetmarket.core.market.service;

import java.util.List;

import edu.zipcloud.cloudstreetmarket.core.market.dto.DailyMarketActivityDTO;
import edu.zipcloud.cloudstreetmarket.core.index.dto.IndexOverviewDTO;

public interface IMarketService {
    DailyMarketActivityDTO getLastDayIndexActivity(String code);
    List<IndexOverviewDTO> getLastDayIndexOverview(String market);
}

