package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.enity.Customer;
import com.udacity.jdnd.course3.critter.enity.Pet;
import com.udacity.jdnd.course3.critter.repository.CustomersRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PetService {
    @Autowired
    private PetRepository petsRepository;

    @Autowired
    private CustomersRepository customersRepository;

    public List<Pet> getAllPets() {
        return petsRepository.findAll();
    }

    public List<Pet> getPetsByCustomerId(Long customerId){
        return petsRepository.getAllByCustomerId(customerId);
    }

    public Pet getPetById(Long petId){
        return petsRepository.getOne(petId);
    }

    public Pet savePet(Pet pet, Long ownerId) {
        Customer customer = customersRepository.getOne(ownerId);
        pet.setCustomer(customer);
        pet = petsRepository.save(pet);
        customer.insertPet(pet);
        customersRepository.save(customer);

        return pet;
    }
}
