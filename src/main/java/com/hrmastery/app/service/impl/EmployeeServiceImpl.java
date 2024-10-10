package com.hrmastery.app.service.impl;

import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.entity.Employee;
import com.hrmastery.app.repository.impl.EmployeeRepoImpl;
import com.hrmastery.app.repository.inerfaces.EmployeeRepo;
import com.hrmastery.app.service.interfaces.EmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        return null;
    }

    @Override
    public String updateEmployee(Employee employee) throws RepoException {
        try {
           Boolean isUpdated = employeeRepo.update(employee);
           if (isUpdated) {
               return "Employee updated successfully";
           }
        } catch (RepoException e) {
            throw new RepoException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() throws RepoException {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployee(UUID employeeId) throws RepoException {
        Optional<Employee> employee = employeeRepo.findById(employeeId);
        if (employee.isPresent()) {
            return employee.get();
        }else {
            throw new RepoException("Employee not found");
        }
    }


    @Override
    public String deleteEmployee(UUID employeeId) throws RepoException {
        try{
            Boolean isAdded =  employeeRepo.delete(employeeId);
            if(isAdded) {
                return "Employee deleted successfully";
            }
        }catch (RepoException e) {
            throw new RepoException(e.getMessage());
        }
        return null;
    }
}
