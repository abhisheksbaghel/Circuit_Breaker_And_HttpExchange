package com.circuit_breaker.loanservice.controllers;

import com.circuit_breaker.loanservice.beans.Loan;
import com.circuit_breaker.loanservice.dtos.Rate;
import com.circuit_breaker.loanservice.external_services.ApiClient;
import com.circuit_breaker.loanservice.services.LoanService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitTemplateConfigurer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private Logger log=Logger.getLogger(getClass().getName());

    @Autowired
    private LoanService loanService;

    @Autowired
    private ApiClient apiClient;

    @GetMapping("/get-all")
    public List<Loan> getAll()
    {
        return loanService.getAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody Loan loan)
    {
        loan.setType(loan.getType().toUpperCase());
        return loanService.save(loan);
    }


    @GetMapping("/get-from-rate")
    @CircuitBreaker(name = "loan-service", fallbackMethod = "getErrorMessage")
    public List<Rate> getAllRates() throws Exception
    {
        return apiClient.getAll();
    }

    public List<Rate> getErrorMessage(Exception e)
    {
        log.info("Fallback method called...!");
        return null;
    }

    @GetMapping("/get-message-from-rate")
    public String getMessage()
    {
        return apiClient.getMessage();
    }


}
