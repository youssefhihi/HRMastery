package com.hrmastery.app.service.interfaces;

import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.entity.Employee;

public interface EmployeeService {
    String createEmployee(Employee Employee) throws RepoException;

}
