package com.hrmastery.app.repository.inerfaces;

import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.entity.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepo {

    Boolean create(Employee Employee) throws RepoException;
    Boolean delete(UUID id) throws RepoException;
    Boolean update(Employee employee) throws RepoException;
    List<Employee> findAll() throws RepoException;
    Optional<Employee> findById(UUID id) throws RepoException;

}
