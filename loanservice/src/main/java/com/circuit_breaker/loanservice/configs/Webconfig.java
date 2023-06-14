package com.circuit_breaker.loanservice.configs;

import com.circuit_breaker.loanservice.external_services.ApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class Webconfig {

    @Bean
    WebClient webClient()
    {
        return WebClient.builder()
                .baseUrl("http://localhost:9000")
                .build();
    }

    @Bean
    ApiClient postClient()
    {
        HttpServiceProxyFactory httpServiceProxyFactory= HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient()))
                .build();

        return httpServiceProxyFactory.createClient(ApiClient.class);
    }

}
