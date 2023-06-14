package com.circuit_breaker.loanservice.services;

import com.circuit_breaker.loanservice.beans.Loan;

import java.util.List;

public interface LoanService {

    public String save(Loan loan);

    public List<Loan> getAll();
}
