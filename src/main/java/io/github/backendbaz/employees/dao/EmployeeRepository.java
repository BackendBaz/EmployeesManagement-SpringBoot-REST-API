package io.github.backendbaz.employees.dao;

import io.github.backendbaz.employees.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
