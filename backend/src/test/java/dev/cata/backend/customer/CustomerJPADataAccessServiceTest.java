package dev.cata.backend.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerJPADataAccessServiceTest {
    private CustomerJPADataAccessService underTest;
    private AutoCloseable autoCloseable;
    @Mock private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CustomerJPADataAccessService(customerRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void selectAllCustomers() {
        underTest.selectAllCustomers();
        verify(customerRepository).findAll();
    }

    @Test
    void selectCustomerById() {
        int id = 1;
        underTest.selectCustomerById(id);
        verify(customerRepository).findById(id);
    }

    @Test
    void insertCustomer() {
        Customer customer = new Customer();
        underTest.insertCustomer(customer);
        verify(customerRepository).save(customer);
    }

    @Test
    void existsPersonWithEmail() {
        String email = "foo@gmail.com";
        underTest.existsPersonWithEmail(email);
        verify(customerRepository).existsCustomerByEmail(email);
    }

    @Test
    void existsPersonWithId() {
        int id = 1;
        underTest.existsPersonWithId(id);
        verify(customerRepository).existsCustomerById(id);
    }

    @Test
    void deleteCustomerById() {
        int id = 1;
        underTest.deleteCustomerById(id);
        verify(customerRepository).deleteById(id);
    }

    @Test
    void updateCustomer() {
        Customer customer = new Customer(
                1, "Ali", "ali@gmail.com", 20);
        underTest.insertCustomer(customer);
        verify(customerRepository).save(customer);
    }
}