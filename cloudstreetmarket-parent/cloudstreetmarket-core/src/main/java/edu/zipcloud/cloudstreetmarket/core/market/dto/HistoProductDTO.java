package edu.zipcloud.cloudstreetmarket.core.market.dto;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class HistoProductDTO {
    private String productName;
    private String code;
    private Set<Map<String, BigDecimal>> values;
    private Map<String, BigDecimal> mapValues = new HashMap<>();
    private Date fromDate;
    private Date toDate;

    public HistoProductDTO(String productName, String code, Map<String, BigDecimal> mapValues, Date fromDate, Date toDate) {
        this.productName = productName;
        this.code = code;
        this.mapValues = mapValues;
        this.values = mapValues.entrySet()
                               .stream()
                               .map(entry -> Collections.singletonMap(entry.getKey(), entry.getValue()))
                               .collect(Collectors.toCollection(LinkedHashSet::new));
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<Map<String, BigDecimal>> getValues() {
        return values;
    }

    public void setValues(Set<Map<String, BigDecimal>> values) {
        this.values = values;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public BigDecimal getMaxValue() {
        return Collections.max(mapValues.values());
    }

    public BigDecimal getMinValue() {
        return Collections.min(mapValues.values());
    }
}