package com.example.api.repositories;

import com.example.api.entities.Contract;
import com.example.api.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ContractRepository extends JpaRepository<Contract, Integer> {
}
