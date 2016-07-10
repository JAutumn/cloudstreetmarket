package edu.zipcloud.cloudstreetmarket.core.market.service;

import java.util.Date;

import edu.zipcloud.cloudstreetmarket.core.index.dto.IndexOverviewDTO;
import edu.zipcloud.cloudstreetmarket.core.market.dto.HistoProductDTO;
import edu.zipcloud.cloudstreetmarket.core.market.entity.MarketCode;
import edu.zipcloud.cloudstreetmarket.core.quote.entity.QuotesInterval;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMarketService {

    Page<IndexOverviewDTO> getLastDayIndicesOverview(MarketCode market, Pageable pageable);
    Page<IndexOverviewDTO> getLastDayIndicesOverview(Pageable pageable);
    HistoProductDTO getHistoIndex(String code, MarketCode market, Date fromDate, Date toDate, QuotesInterval interval);
}
