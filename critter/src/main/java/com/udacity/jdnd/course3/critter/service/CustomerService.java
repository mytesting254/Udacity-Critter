package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.enity.Customer;
import com.udacity.jdnd.course3.critter.enity.Pet;
import com.udacity.jdnd.course3.critter.repository.CustomersRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private PetRepository petsRepository;

    public Customer saveCustomer(Customer customer, List<Long> petIds) {
        List<Pet> customerPets = new ArrayList<>();

        if (petIds != null && !petIds.isEmpty()) {
            customerPets = petIds.stream().map((petId) -> petsRepository.getOne(petId)).collect(Collectors.toList());
        }
        customer.setPet(customerPets);

        return customersRepository.save(customer);
    }

    public Customer getCustomerByPetId(Long petId) {
        return petsRepository.getOne(petId).getCustomer();
    }

    public List<Customer> getAllCustomers() {
        return customersRepository.findAll();
    }
}
