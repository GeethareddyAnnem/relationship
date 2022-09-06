package com.geeta.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geeta.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    
}
