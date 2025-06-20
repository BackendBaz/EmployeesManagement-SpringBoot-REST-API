package io.github.backendbaz.employees.controller;

import io.github.backendbaz.employees.entity.Employee;
import io.github.backendbaz.employees.request.EmployeeRequest;
import io.github.backendbaz.employees.service.EmployeeService;
import jakarta.validation.Valid;
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
            @Min(value = 1, message = "Id must be a positive number") long id) {
        return employeeService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Employee addEmployee(@Valid @RequestBody EmployeeRequest newEmployee) {
        return employeeService.save(newEmployee);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Employee updateEmployeeById(
            @PathVariable
            @Min(value = 1, message = "Id must be a positive number")
            long id,
            @Valid @RequestBody EmployeeRequest editableEmployee) {
        return employeeService.update(id, editableEmployee);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable
                                   @Min(value = 1, message = "Id must be a positive number")
                                   long id) {
        employeeService.deleteById(id);
    }

}
