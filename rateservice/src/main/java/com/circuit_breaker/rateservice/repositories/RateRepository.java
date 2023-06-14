package com.circuit_breaker.rateservice.repositories;

import com.circuit_breaker.rateservice.beans.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RateRepository extends JpaRepository<Rate,Integer> {

    public List<Rate> findByType(String type);

}
