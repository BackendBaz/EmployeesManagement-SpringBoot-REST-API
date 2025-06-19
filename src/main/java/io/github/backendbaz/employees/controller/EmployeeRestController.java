package io.github.backendbaz.employees.controller;

import io.github.backendbaz.employees.entity.Employee;
import io.github.backendbaz.employees.exception.EmployeeNotFoundException;
import io.github.backendbaz.employees.service.EmployeeService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")

public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Employee findEmployeeById(
            @PathVariable
            @Min(value = 1, message = "Id must be a positive number")
            long id) {
        Employee employee = employeeService.findById(id);
        if (employee == null)
            throw new EmployeeNotFoundException("Employee with id " + id +
                    " not found");
        return employeeService.findById(id);
    }

}
