package com.circuit_breaker.rateservice.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String type;
    double rateValue;

}
