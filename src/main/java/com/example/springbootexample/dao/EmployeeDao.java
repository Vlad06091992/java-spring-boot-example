package com.example.springbootexample.dao;

import com.example.springbootexample.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Component
public class EmployeeDao implements EmployeeDaoInterface {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = entityManager.unwrap(Session.class);
        System.out.println("REPOSITORY");
        List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();
        return employees;

    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        System.out.println("employee: " + employee.toString());
        if (employee.getId() == null) {
            session.save(employee);
        } else {
            session.update(employee);
        }
    }

    @Override
    public Employee getEmployeeById(String id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Employee.class, id);
    }

    @Override
    public boolean deleteEmployeeById(String id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("DELETE FROM Employee" +
                        " where id =:employeeId")
                .setParameter("employeeId", id);

        int affected = query.executeUpdate();
        return affected > 0;
    }
}
