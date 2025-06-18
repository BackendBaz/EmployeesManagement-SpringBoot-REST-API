package io.github.backendbaz.employees.service;

import io.github.backendbaz.employees.entity.Employee;
import io.github.backendbaz.employees.request.EmployeeRequest;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(long id);

    Employee save(EmployeeRequest employeeRequest);

    Employee update(long id, EmployeeRequest employeeRequest);

    Employee convertToEmployee(long id, EmployeeRequest employeeRequest);

    void deleteById(long id);

}
