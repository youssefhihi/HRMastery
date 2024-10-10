package com.hrmastery.app.repository.impl;

import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.repository.inerfaces.Repo;
import com.hrmastery.app.persistence.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RepoImpl<T> implements Repo<T> {

    private final Class<T> entityClass;

    public RepoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public Boolean create(T entity) throws RepoException {
        EntityTransaction transaction = null;
        EntityManager entityManager = null;
        try {
            entityManager = PersistenceManager.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(entity);
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
    public Boolean update(T entity) throws RepoException {
        EntityTransaction transaction = null;
        EntityManager entityManager = null;
        try {
            entityManager = PersistenceManager.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(entity);  // Merge for updating
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
    public List<T> findAll() throws RepoException {
        EntityManager entityManager = null;
        try {
            entityManager = PersistenceManager.getEntityManager();
            return entityManager.createQuery("FROM " + entityClass.getName(), entityClass).getResultList();
        } catch (Exception e) {
            throw new RepoException(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public Optional<T> findById(UUID id) throws RepoException {
        EntityManager entityManager = null;
        try {
            entityManager = PersistenceManager.getEntityManager();
            T entity = entityManager.find(entityClass, id);
            return Optional.ofNullable(entity);
        } catch (Exception e) {
            throw new RepoException(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public Boolean delete(UUID id) throws RepoException {
        EntityTransaction transaction = null;
        EntityManager entityManager = null;
        try {
            entityManager = PersistenceManager.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            T entity = entityManager.find(entityClass, id);
            if (entity != null) {
                entityManager.remove(entity);
                transaction.commit();
                return true;
            } else {
                throw new RepoException(entityClass.toString() +" not found with id: " + id);
            }
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
