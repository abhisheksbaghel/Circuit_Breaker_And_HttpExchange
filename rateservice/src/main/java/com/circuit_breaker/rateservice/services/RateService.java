package com.circuit_breaker.rateservice.services;

import com.circuit_breaker.rateservice.beans.Rate;

import java.util.List;

public interface RateService {

    public String save(Rate rate);

    public List<Rate> getAll();

    public List<Rate> findByType(String type);

}
