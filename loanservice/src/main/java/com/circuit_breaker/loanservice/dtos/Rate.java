package com.circuit_breaker.loanservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Rate {

    int id;
    String type;
    double rateValue;

}
