package com.microservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Component
@FeignClient(name = "PRODUCT")
public interface ProductClient {

    @GetMapping("/api/v1/products")
    List<CustomerDto> list();

    @GetMapping("/api/v1/products/{id}")
    Optional<CustomerDto> findById(@PathVariable(name = "id") Integer id);
}
