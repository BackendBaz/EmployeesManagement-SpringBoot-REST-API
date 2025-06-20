package io.github.backendbaz.employees.service;

import io.github.backendbaz.employees.dao.EmployeeRepository;
import io.github.backendbaz.employees.entity.Employee;
import io.github.backendbaz.employees.exception.EmployeeNotFoundException;
import io.github.backendbaz.employees.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(long id) {
        Optional<Employee> result = employeeRepository.findById(id);
        if (result.isEmpty()) throw new EmployeeNotFoundException("Employee with " +
                id + " not found");
        return result.get();
    }

    @Transactional
    @Override
    public Employee save(EmployeeRequest employeeRequest) {
        return employeeRepository.save(convertToEmployee(0, employeeRequest));
    }

    @Transactional
    @Override
    public Employee update(long id, EmployeeRequest employeeRequest) {
        return employeeRepository.save(convertToEmployee(id, employeeRequest));
    }

    @Override
    public Employee convertToEmployee(long id, EmployeeRequest employeeRequest) {
        return new Employee(
                id,
                employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getEmail()
        );
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }

}
