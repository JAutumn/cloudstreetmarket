package edu.zipcloud.cloudstreetmarket.core.market.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import edu.zipcloud.cloudstreetmarket.core.historic.dao.HistoricalIndexRepository;
import edu.zipcloud.cloudstreetmarket.core.historic.entity.HistoricalIndex;
import edu.zipcloud.cloudstreetmarket.core.index.dao.IndexRepository;
import edu.zipcloud.cloudstreetmarket.core.index.dto.IndexOverviewDTO;
import edu.zipcloud.cloudstreetmarket.core.index.entity.Index;
import edu.zipcloud.cloudstreetmarket.core.market.dao.MarketRepository;
import edu.zipcloud.cloudstreetmarket.core.market.dto.HistoProductDTO;
import edu.zipcloud.cloudstreetmarket.core.market.entity.Market;
import edu.zipcloud.cloudstreetmarket.core.market.entity.MarketCode;
import edu.zipcloud.cloudstreetmarket.core.quote.entity.QuotesInterval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service(value="marketServiceImpl")
public class MarketServiceImpl implements IMarketService {
    private static final DateFormat dateFormat = new SimpleDateFormat("HH:mm");

    @Autowired
    private MarketRepository marketRepository;

    @Autowired
    private HistoricalIndexRepository historicalIndexRepository;

    @Autowired
    private IndexRepository indexRepository;

    @Override
    public HistoProductDTO getHistoIndex(String code, MarketCode market, Date fromDate, Date toDate, QuotesInterval interval){
        Map<String, BigDecimal> map = new LinkedHashMap<>();
        Iterator<HistoricalIndex> histoList;
        if (fromDate == null){
            histoList = historicalIndexRepository.findLastIntraDay(code).iterator();
        }
        else{
            histoList = historicalIndexRepository.findHistoric(code, market, fromDate, toDate, interval).iterator();
        }

        Date firstDate = null;
        HistoricalIndex lastValue = null;
        while(histoList.hasNext()){
            lastValue = histoList.next();
            if(firstDate==null){
                firstDate = lastValue.getFromDate();
            }
            map.put(dateFormat.format(lastValue.getToDate()), lastValue.getClose());
        }

        return (lastValue != null) ? new HistoProductDTO(lastValue.getIndex().getName(), code, map, firstDate, lastValue.getToDate()) : null;
    }

    @Override
    public Page<IndexOverviewDTO> getLastDayIndicesOverview(MarketCode market, Pageable pageable) {
        Market marketEntity = marketRepository.findByCode(market);
        Page<Index> indices = indexRepository.findByMarket(marketEntity, pageable);

        List<IndexOverviewDTO> result = new LinkedList<>();
        for (Index index : indices) {
            result.add(IndexOverviewDTO.build(index));
        }

        return new PageImpl<>(result, pageable, indices.getTotalElements());
    }

    @Override
    public Page<IndexOverviewDTO> getLastDayIndicesOverview(Pageable pageable) {
        Page<Index> indices = indexRepository.findAll(pageable);
        List<IndexOverviewDTO> result = new LinkedList<>();
        for (Index index : indices) {
            result.add(IndexOverviewDTO.build(index));
        }
        return new PageImpl<>(result, pageable, indices.getTotalElements());
    }

}
