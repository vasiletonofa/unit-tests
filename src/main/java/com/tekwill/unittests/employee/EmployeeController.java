package com.tekwill.unittests.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    // HTTP -> POST, GET, PUT, DELETE, PATCH


    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @DeleteMapping("/id/{id}")
    public void deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/name/{name}")
    public List<Employee> getAllEmployeeByName(@PathVariable String name) {
        return employeeService.getAllEmployeeByName(name);
    }

}
