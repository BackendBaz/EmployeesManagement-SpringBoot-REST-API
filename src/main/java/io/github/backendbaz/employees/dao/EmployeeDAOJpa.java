package io.github.backendbaz.employees.dao;

import io.github.backendbaz.employees.entity.Employee;
import io.github.backendbaz.employees.exception.EmployeeNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeDAOJpa implements EmployeeDAO {

    private final EntityManager em;

    @Autowired
    public EmployeeDAOJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> findAll() {
        // Create a query:
        TypedQuery<Employee> query = em.createQuery("from Employee",
                Employee.class);
        // Execute the query and return the results:
        return query.getResultList();
    }

    @Override
    public Employee findById(long id) {
        Employee employee = em.find(Employee.class, id);
        if (!em.contains(employee))
            throw new EmployeeNotFoundException("Employee with id " + id +
                    " not found");
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return em.merge(employee);
    }

    @Override
    public Employee update(long id, Employee employee) {
        if (!em.contains(em.find(Employee.class, id)))
            throw new EmployeeNotFoundException("Employee with id " + id +
                    " not found");
        return em.merge(employee);
    }

    @Override
    public void deleteById(long id) {
        em.remove(findById(id));
    }

}
