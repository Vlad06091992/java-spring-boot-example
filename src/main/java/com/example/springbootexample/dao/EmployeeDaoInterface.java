package com.example.springbootexample.dao;

import com.example.springbootexample.entity.Employee;
import java.util.List;

public interface EmployeeDaoInterface {
    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmployeeById(String id);
    public boolean deleteEmployeeById(String id);
}
