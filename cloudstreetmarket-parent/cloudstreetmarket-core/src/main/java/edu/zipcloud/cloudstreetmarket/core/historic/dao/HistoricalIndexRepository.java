package edu.zipcloud.cloudstreetmarket.core.historic.dao;

import java.util.Date;

import edu.zipcloud.cloudstreetmarket.core.historic.entity.HistoricalIndex;
import edu.zipcloud.cloudstreetmarket.core.market.entity.MarketCode;
import edu.zipcloud.cloudstreetmarket.core.quote.entity.QuotesInterval;

public interface HistoricalIndexRepository {
    Iterable<HistoricalIndex> findIntraDay(String code, Date of);
    Iterable<HistoricalIndex> findHistoric(String code, MarketCode market, Date fromDate, Date toDate, QuotesInterval interval);
    Iterable<HistoricalIndex> findLastIntraDay(String code);
    HistoricalIndex findLastHistoric(String code);
}
