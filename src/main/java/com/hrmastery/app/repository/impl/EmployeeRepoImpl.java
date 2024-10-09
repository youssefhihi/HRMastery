package com.hrmastery.app.repository.impl;

import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.entity.Employee;
import com.hrmastery.app.enums.Role;
import com.hrmastery.app.persistence.PersistenceManager;
import com.hrmastery.app.repository.inerfaces.EmployeeRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Date;

public class EmployeeRepoImpl implements EmployeeRepo {

    @Override
    public Boolean create(Employee employee) throws RepoException {
        EntityTransaction transaction = null;
        EntityManager entityManager = null;

        try {
            entityManager = PersistenceManager.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(employee);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RepoException(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

}
