package com.microservices;

public record CustomerDto(Long id,
                          String firstName,
                          String lastName,
                          String email) {
}
