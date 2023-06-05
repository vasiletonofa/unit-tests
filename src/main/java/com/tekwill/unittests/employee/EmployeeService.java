package com.tekwill.unittests.employee;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface EmployeeService {

    void createEmployee(Employee employee);

    List<Employee> getAllEmployee();

    void deleteEmployeeById(Long id);

    List<Employee> getAllEmployeeByName(String name);

    boolean checkEmployeeNameStartsWith(Employee employee, String prefix);

}
