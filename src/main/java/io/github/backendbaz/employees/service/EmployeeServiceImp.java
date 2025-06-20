package io.github.backendbaz.employees.service;

import io.github.backendbaz.employees.dao.EmployeeDAO;
import io.github.backendbaz.employees.entity.Employee;
import io.github.backendbaz.employees.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImp(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(long id) {
        return employeeDAO.findById(id);
    }

    @Transactional
    @Override
    public Employee save(EmployeeRequest employeeRequest) {
        return employeeDAO.save(convertToEmployee(0, employeeRequest));
    }

    @Transactional
    @Override
    public Employee update(long id, EmployeeRequest employeeRequest) {
        return employeeDAO.update(id, convertToEmployee(id, employeeRequest));
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
        employeeDAO.deleteById(id);
    }

}
