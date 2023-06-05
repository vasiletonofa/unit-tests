package com.tekwill.unittests;

import com.tekwill.unittests.employee.Employee;
import com.tekwill.unittests.employee.EmployeeService;
import com.tekwill.unittests.employee.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UnitTestsApplicationTests {  // Unit Tests  / JUnit / Mockito -> Mock tests

	@Autowired
	EmployeeService employeeService;

	@Test
	void testMath() {
		boolean isCorrect = (2 + 2) == 4;
		Assertions.assertTrue(isCorrect);
	}

	@Test
	void testEmployeeServiceNameStartWith() {

		Employee employee = new Employee();
		employee.setFirstName("Vasile");

		boolean isTrue = employeeService.checkEmployeeNameStartsWith(employee, "V");

		Assertions.assertTrue(isTrue);
	}

	@Test
	void testCreateEmployeeWithEmptyFirstName() {
		Employee employee = new Employee();
		employee.setFirstName("");

		Assertions.assertThrows(IllegalArgumentException.class, () -> employeeService.createEmployee(employee));
	}

	@Test
	void testCreateEmployeeWithEmptyFirstName2() {
		Employee employee = new Employee();
		employee.setFirstName("Vasile");

		employeeService.createEmployee(employee);

		Assertions.assertEquals(employeeService.getAllEmployee().size(), 1);
		Assertions.assertEquals(employeeService.getAllEmployee().get(0).getFirstName(), "Vasile");
	}

}

// Nicolae - Artiom, Dumitru, Grigore

// Maxim - Alina, Vasile,

// API
// DB
// CRUD

// Bank ( Maib - 0.5%)

// Payment (Bank_id,  amount,  Bani -- , Payer, Payee)




