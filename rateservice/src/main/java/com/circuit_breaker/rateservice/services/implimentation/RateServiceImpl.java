package com.circuit_breaker.rateservice.services.implimentation;

import com.circuit_breaker.rateservice.beans.Rate;
import com.circuit_breaker.rateservice.repositories.RateRepository;
import com.circuit_breaker.rateservice.services.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateServiceImpl implements RateService {

    @Autowired
    private RateRepository rateRepository;

    @Override
    public String save(Rate rate) {
        rateRepository.save(rate);
        return "Saved rate with type : "+rate.getType();
    }

    @Override
    public List<Rate> getAll() {
        return rateRepository.findAll();
    }

    @Override
    public List<Rate> findByType(String type) {
        return rateRepository.findByType(type);
    }
}
