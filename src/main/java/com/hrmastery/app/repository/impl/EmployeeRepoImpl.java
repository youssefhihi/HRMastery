package com.hrmastery.app.repository.impl;

import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.entity.Employee;
import com.hrmastery.app.enums.Role;
import com.hrmastery.app.persistence.PersistenceManager;
import com.hrmastery.app.repository.inerfaces.EmployeeRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Boolean update(Employee employee) throws RepoException {
        EntityTransaction transaction = null;
        EntityManager entityManager = null;
        try {
            entityManager = PersistenceManager.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(employee);
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

    @Override
    public List<Employee> findAll() throws RepoException {
        try (EntityManager entityManager = PersistenceManager.getEntityManager()) {
            return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        } catch (Exception e) {
            throw new RepoException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Employee> findById(UUID id) throws RepoException {
        try (EntityManager entityManager = PersistenceManager.getEntityManager()) {
            return Optional.of(entityManager.find(Employee.class, id));
        } catch (Exception e) {
            throw new RepoException(e.getMessage(), e);
        }
    }



}
