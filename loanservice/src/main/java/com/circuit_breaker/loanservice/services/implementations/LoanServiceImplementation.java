package com.circuit_breaker.loanservice.services.implementations;

import com.circuit_breaker.loanservice.beans.Loan;
import com.circuit_breaker.loanservice.repositories.LoanRepository;
import com.circuit_breaker.loanservice.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImplementation implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public String save(Loan loan) {
        loanRepository.save(loan);
        return "Saved Loan with type : "+loan.getType();
    }

    @Override
    public List<Loan> getAll() {
        return loanRepository.findAll();
    }
}
