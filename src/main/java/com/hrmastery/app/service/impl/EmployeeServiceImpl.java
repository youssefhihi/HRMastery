package com.hrmastery.app.service.impl;

import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.entity.Employee;
import com.hrmastery.app.repository.impl.EmployeeRepoImpl;
import com.hrmastery.app.repository.inerfaces.EmployeeRepo;
import com.hrmastery.app.service.interfaces.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo = new EmployeeRepoImpl();

    @Override
    public String createEmployee(Employee employee) throws RepoException {
        try {
            Boolean isAdded = employeeRepo.create(employee);
            if (isAdded) {
                return "Employee added successfully";
            }
        } catch (RepoException e) {
            throw new RepoException(e.getMessage());
        }
        return "SERDFTGHJK";
    }


}
