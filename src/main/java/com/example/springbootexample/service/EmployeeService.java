package com.example.springbootexample.service;

import com.example.springbootexample.dao.EmployeeDaoInterface;
import com.example.springbootexample.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

@Component
@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    private EmployeeDaoInterface employeeDao;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        System.out.println("SERVICE");
        return this.employeeDao.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        System.out.println(employee);
        this.employeeDao.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(String id) {
        return this.employeeDao.getEmployeeById(id);
    }

    @Override
    @Transactional
    public boolean deleteEmployeeById(String id)  {
        return this.employeeDao.deleteEmployeeById(id);
    }


}
