package edu.zipcloud.cloudstreetmarket.api.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Date;

import edu.zipcloud.cloudstreetmarket.core.index.dto.IndexOverviewDTO;
import edu.zipcloud.cloudstreetmarket.core.market.dto.HistoProductDTO;
import edu.zipcloud.cloudstreetmarket.core.market.entity.MarketCode;
import edu.zipcloud.cloudstreetmarket.core.market.service.IMarketService;
import edu.zipcloud.cloudstreetmarket.core.quote.entity.QuotesInterval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import com.mangofactory.swagger.annotations.ApiIgnore;;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


@RestController
@RequestMapping(value = "/indices", produces = {"application/xml", "application/json"})
public class IndexController extends CloudstreetApiWCI {

    @Autowired
    private WebApplicationContext webAppContext;

    @Autowired
    @Qualifier("marketServiceImpl")
    private IMarketService marketService;

    @RequestMapping(method = GET)
    public Page<IndexOverviewDTO> getIndices(
            @ApiIgnore @PageableDefault(size = 10, page = 0, sort = {"dailyLatestValue"},
                                        direction = Direction.DESC) Pageable pageable) {
        return marketService.getLastDayIndicesOverview(pageable);
    }

    @RequestMapping(value = "/{market}", method = GET)
    public Page<IndexOverviewDTO> getIndicesPerMarket(
            @PathVariable MarketCode market,
            @ApiIgnore @PageableDefault(size = 10, page = 0, sort = {"dailyLatestValue"},
                                        direction = Direction.DESC) Pageable pageable) {
        return marketService.getLastDayIndicesOverview(market, pageable);
    }

    @RequestMapping(value = "/{market}/{index}", method = GET)
    public HistoProductDTO getHistoIndex(@PathVariable("market") MarketCode market, 
                                         @PathVariable("index") String indexCode, 
                                         @RequestParam(value = "fd", defaultValue = "") Date fromDate, 
                                         @RequestParam(value = "td", defaultValue = "") Date toDate, 
                                         @RequestParam(value = "i", defaultValue = "MINUTE_30") QuotesInterval interval) {
        return marketService.getHistoIndex(indexCode, market, fromDate, toDate, interval);
    }
}