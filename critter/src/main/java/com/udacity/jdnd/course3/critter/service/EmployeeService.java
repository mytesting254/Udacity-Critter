package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.enity.Employee;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeesRepository;

    public Employee getEmployeeById(Long employeeId) {
        return employeesRepository.getOne(employeeId);
    }

    public List<Employee> getEmployeesForService(LocalDate date, Set<EmployeeSkill> skills){
        return employeesRepository.getAllByDaysAvailableContains(date.getDayOfWeek()).stream()
                .filter(employee -> employee.getSkills().containsAll(skills))
                .collect(Collectors.toList());
    }

    public Employee saveEmployee(Employee employee) {
        return employeesRepository.save(employee);
    }

    public void setEmployeeAvailability(Set<DayOfWeek> days, Long employeeId) {
        Employee employee = employeesRepository.getOne(employeeId);
        employee.setDaysAvailable(days);
        employeesRepository.save(employee);
    }
}
