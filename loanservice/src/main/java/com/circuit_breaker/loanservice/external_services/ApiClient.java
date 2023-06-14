package com.circuit_breaker.loanservice.external_services;

import com.circuit_breaker.loanservice.dtos.Rate;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

//@FeignClient(name = "rate-service", url = "http://localhost:9000/rate")
@HttpExchange(url = "/rate", accept = "application/json", contentType = "application/json")
public interface ApiClient {

//    @GetMapping("/get-all")
    @GetExchange("/get-all")
    public List<Rate> getAll();

    @GetExchange("/get-message")
    public String getMessage();

}
