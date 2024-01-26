package dev.cata.backend.customer;

public record CustomerRegistrationRequest(
        String name,
        String email,
        Integer age
) {
}
