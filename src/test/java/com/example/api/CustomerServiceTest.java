package com.example.api;

import com.example.api.entities.Customer;
import com.example.api.repositories.CustomerRepository;
import com.example.api.services.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @MockBean
    CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Before
    public void setUp() {
        Mockito.when(customerRepository.findAll())
                .thenReturn((List<Customer>) IntStream.range(0, 10)
                        .mapToObj(i -> new Customer(
                                20+i,
                                "name-"+i,
                                66+i,
                                "address-"+i,
                                LocalDate.now(),
                                "household-"+i,
                                7 +i))
                        .collect(Collectors.toList()));
    }

    @Test
    public void testCount() {
        Assert.assertEquals(10, customerService.getAllCustomers().size());
    }
}
