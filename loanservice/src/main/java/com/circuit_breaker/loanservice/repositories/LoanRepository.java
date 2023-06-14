package com.circuit_breaker.loanservice.repositories;

import com.circuit_breaker.loanservice.beans.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer> {
}
