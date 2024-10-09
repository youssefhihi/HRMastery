package com.hrmastery.app.service.interfaces;

import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.entity.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeService {
    String createEmployee(Employee Employee) throws RepoException;
    String updateEmployee(Employee Employee) throws RepoException;
    List<Employee> getAllEmployees() throws RepoException;
    Employee getEmployee(UUID EmployeeId) throws RepoException;

}
