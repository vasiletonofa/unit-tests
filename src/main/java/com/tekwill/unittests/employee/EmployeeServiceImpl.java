package com.tekwill.unittests.employee;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(Employee employee) {
        if(employee.firstName.isBlank()) {
            throw new IllegalArgumentException("First Name cannot be empty or null !!");
        }

        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployeeById(Long id) {
        if(!employeeRepository.existsById(id)) {
            throw new EmployeeNotExistException("Nu exista asa Angajat !");
        }

        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAllEmployeeByName(String name) {
        return employeeRepository.findAllByFirstName(name);
    }

    @Override
    public boolean checkEmployeeNameStartsWith(Employee employee, String prefix) {
        return employee.firstName.startsWith(prefix);
    }


}
