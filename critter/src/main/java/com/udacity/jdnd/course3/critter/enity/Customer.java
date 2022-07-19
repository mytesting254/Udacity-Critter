package com.udacity.jdnd.course3.critter.enity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    private String name;
    private String phoneNumber;
    private String Notes;

    @OneToMany(targetEntity = Pet.class)
    private List<Pet> pets;

    public Customer() {
    }

    public Customer(Long id, String name, String phoneNumber, String notes) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        Notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public List<Pet> getPet() {
        return pets;
    }

    public void setPet(List<Pet> pet) {
        this.pets = pet;
    }

    public void insertPet(Pet pet) {
        pets.add(pet);
    }
}
