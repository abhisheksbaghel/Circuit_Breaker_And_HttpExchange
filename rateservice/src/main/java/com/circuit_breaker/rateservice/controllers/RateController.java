package com.circuit_breaker.rateservice.controllers;

import com.circuit_breaker.rateservice.beans.Rate;
import com.circuit_breaker.rateservice.services.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rate")
public class RateController {

    @Autowired
    private RateService rateService;

    @GetMapping("/get-all")
    public List<Rate> getAll()
    {
        return rateService.getAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody Rate rate)
    {
        rate.setType(rate.getType().toUpperCase());
        return rateService.save(rate);
    }

    @GetMapping("find-by-type/{type}")
    public List<Rate> findByType(@PathVariable String type)
    {
        type= type.toUpperCase();
        return rateService.findByType(type);
    }

    @GetMapping("/get-message")
    public String getMessage()
    {
        return "got a call from other service";
    }

}
