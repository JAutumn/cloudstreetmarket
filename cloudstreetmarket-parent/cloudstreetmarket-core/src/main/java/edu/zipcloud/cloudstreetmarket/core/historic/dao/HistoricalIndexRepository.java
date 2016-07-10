package edu.zipcloud.cloudstreetmarket.core.historic.dao;

import java.util.Date;

import edu.zipcloud.cloudstreetmarket.core.historic.entity.HistoricalIndex;

public interface HistoricalIndexRepository {

    Iterable<HistoricalIndex> findIntraDay(String code, Date of);

    Iterable<HistoricalIndex> findLastIntraDay(String code);

    HistoricalIndex findLastHistoric(String code);

}
