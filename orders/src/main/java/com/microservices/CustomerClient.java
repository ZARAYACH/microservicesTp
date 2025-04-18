package com.microservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Component
@FeignClient(name = "CUSTOMER")
public interface CustomerClient {

    @GetMapping("/api/v1/customers")
    List<CustomerDto> list();

    @GetMapping("/api/v1/customers/{id}")
    Optional<CustomerDto> findById(@PathVariable(name = "id") Integer id);
}
