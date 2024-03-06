package dev.cata.backend;

import com.github.javafaker.Faker;
import dev.cata.backend.customer.Customer;
import dev.cata.backend.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository) {
        return args -> {
            var faker = new Faker();
            Random random = new Random();
            var name = faker.name();

            String firstName = name.firstName();
            String lastName = name.lastName();
            Customer customer = new Customer(
                    firstName + " " + lastName,
                    firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com",
                    random.nextInt(16, 99)
            );
            customerRepository.save(customer);
        };
    }
}


