package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.enity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customer, Long> {
}
