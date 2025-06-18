package io.github.backendbaz.employees.dao;

import io.github.backendbaz.employees.entity.Employee;
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

}
