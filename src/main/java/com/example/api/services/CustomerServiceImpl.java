package com.example.api.services;

import com.example.api.entities.Customer;
import com.example.api.repositories.ContractRepository;
import com.example.api.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> getCustomerPaginate(Pageable pageable) {
        return customerRepository.findAllCustomer(pageable);
    }

    @Override
    public List<Customer> searchCustomer(String querySearch) {
        return customerRepository.searchCustomer(querySearch);
    }

    @Override
    public Optional<Customer> getCustomerById(int id) {
        return customerRepository.findById(id);
    }

    public String getCurrentDateTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    @Override
    public void save(Customer customer){
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        Customer customer = null;
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isPresent()) {
            customer = optionalCustomer.get();
        }
        assert customer != null;
        customerRepository.delete(customer);
    }
}
