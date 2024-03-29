package com.example.api.repositories;

import com.example.api.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT c FROM customers c WHERE " +
            "c.name LIKE %:query% " +
            "OR c.cmnd LIKE %:query% " +
            "OR c.address LIKE %:query% " +
            "OR c.birthday LIKE %:query% " +
            "OR c.household LIKE %:query% " +
            "OR c.phone LIKE %:query%")
    List<Customer> searchCustomer(@Param("query") String querySearch);

    @Query("SELECT c FROM customers c")
    Page<Customer> findAllCustomer(Pageable pageable);
}
