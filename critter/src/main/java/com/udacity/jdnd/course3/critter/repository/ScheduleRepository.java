package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.enity.Employee;
import com.udacity.jdnd.course3.critter.enity.Pet;
import com.udacity.jdnd.course3.critter.enity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> getAllByPetsContains(Pet pet);
    List<Schedule> getAllByEmployeesContains(Employee employee);
    List<Schedule> getAllByPetsIn(List<Pet> pets);
}
