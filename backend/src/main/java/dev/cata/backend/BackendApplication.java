package dev.cata.backend;

import dev.cata.backend.customer.Customer;
import dev.cata.backend.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository) {
        Customer alex = new Customer( "Alex", "alex@gmail.com", 21);
        Customer jamila = new Customer("Jamila", "jamila@gmail.com", 19);
        List<Customer> customers = List.of(alex, jamila);
//        customerRepository.saveAll(customers);
        return args -> {};
    }

}


