package com.hrmastery.app.repository.impl;

import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.entity.Employee;
import com.hrmastery.app.repository.inerfaces.EmployeeRepo;

import java.util.UUID;
import java.util.Optional;
import java.util.List;

public class EmployeeRepoImpl extends RepoImpl<Employee> implements EmployeeRepo {

    public EmployeeRepoImpl() {
        super(Employee.class);
    }

    @Override
    public Boolean create(Employee employee) throws RepoException {
        return super.create(employee);
    }

    @Override
    public Boolean update(Employee employee) throws RepoException {
        return super.update(employee);
    }

    @Override
    public List<Employee> findAll() throws RepoException {
        return super.findAll();
    }

    @Override
    public Optional<Employee> findById(UUID id) throws RepoException {
        return super.findById(id);
    }

    @Override
    public Boolean delete(UUID id) throws RepoException {
        return super.delete(id);
    }
}
