package com.hrmastery.app.repository.inerfaces;

import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.entity.Employee;

public interface EmployeeRepo {

    Boolean create(Employee Employee) throws RepoException;
}
