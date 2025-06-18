package io.github.backendbaz.employees.service;

import io.github.backendbaz.employees.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

}
