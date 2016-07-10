package edu.zipcloud.cloudstreetmarket.core.market.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zipcloud.cloudstreetmarket.core.historic.entity.HistoricalIndex;
import edu.zipcloud.cloudstreetmarket.core.market.entity.Market;
import edu.zipcloud.cloudstreetmarket.core.historic.dao.HistoricalIndexRepository;
import edu.zipcloud.cloudstreetmarket.core.index.dao.IndexProductRepository;
import edu.zipcloud.cloudstreetmarket.core.market.dao.MarketRepository;
import edu.zipcloud.cloudstreetmarket.core.index.dto.IndexOverviewDTO;
import edu.zipcloud.cloudstreetmarket.core.market.dto.DailyMarketActivityDTO;

@Service(value = "marketServiceImpl")
public class MarketServiceImpl implements IMarketService {

    private DateFormat dateFormat = new SimpleDateFormat("HH:mm");

    @Autowired
    private MarketRepository marketRepository;

    @Autowired
    private HistoricalIndexRepository historicalIndexRepository;

    @Autowired
    private IndexProductRepository indexProductRepository;
    
    @Override
    public DailyMarketActivityDTO getLastDayIndexActivity(String code) {
        Map<String, BigDecimal> map = new LinkedHashMap<>();
        Iterator<HistoricalIndex> histoList = historicalIndexRepository.findLastIntraDay(code).iterator();
        Date lastDate = null;
        HistoricalIndex lastValue = null;

        while (histoList.hasNext()) {
            lastValue = histoList.next();
            lastDate = lastValue.getToDate();
            map.put(dateFormat.format(lastDate), new BigDecimal(lastValue.getClose()));
        }

        return new DailyMarketActivityDTO(lastValue.getIndex().getName(), code, map, lastDate);
    }

    @Override
    public List<IndexOverviewDTO> getLastDayIndexOverview(String market) {

        List<IndexOverviewDTO> result = new LinkedList<>();
        Market marketEntity = marketRepository.findOne(market);

        if (marketEntity != null) {
            indexProductRepository.findByMarket(marketEntity).forEach(
                    index -> {
                        HistoricalIndex histo = historicalIndexRepository.findLastHistoric(index.getCode());
                        result.add(
                                new IndexOverviewDTO(
                                        index.getName(),
                                        index.getCode(),
                                        new BigDecimal(histo.getClose()),
                                        new BigDecimal(histo.getChangePercent() * 0.01)
                                ));
                    }
            );
        }

        return result;
    }
}
