package com.microservices;

public record CustomerRequest(String firstName,
                              String lastName,
                              String email) {
}