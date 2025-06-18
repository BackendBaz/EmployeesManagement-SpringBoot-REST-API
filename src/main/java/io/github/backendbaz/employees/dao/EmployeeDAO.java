package io.github.backendbaz.employees.dao;

import io.github.backendbaz.employees.entity.Employee;
import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

}
