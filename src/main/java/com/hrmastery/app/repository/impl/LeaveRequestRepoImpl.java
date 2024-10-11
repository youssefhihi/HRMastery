package com.hrmastery.app.repository.impl;


import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.entity.LeaveRequest;
import com.hrmastery.app.persistence.PersistenceManager;
import com.hrmastery.app.repository.inerfaces.LeaveRequestRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import com.hrmastery.app.enums.StatusLeaveRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class LeaveRequestRepoImpl extends RepoImpl<LeaveRequest> implements LeaveRequestRepo {

    public LeaveRequestRepoImpl() {
        super(LeaveRequest.class);
    }

    @Override
    public Boolean create(LeaveRequest leaveRequest) throws RepoException {
        return super.create(leaveRequest);
    }

    @Override
    public Boolean update(LeaveRequest leaveRequest) throws RepoException {
        return super.update(leaveRequest);
    }

    @Override
    public List<LeaveRequest> findAll() throws RepoException {
        return super.findAll();
    }

    @Override
    public Optional<LeaveRequest> findById(UUID id) throws RepoException {
        return super.findById(id);
    }

    @Override
    public Boolean delete(UUID id) throws RepoException {
        return super.delete(id);
    }

    @Override
    public List<LeaveRequest> findApprovedRequestsByEmployeeId(UUID employeeId) throws RepoException {
        EntityManager entityManager = null;
        try {
            entityManager = PersistenceManager.getEntityManager();
            String jpql = "SELECT lr FROM LeaveRequest lr WHERE lr.employee.id = :employeeId AND lr.status = :status";
            TypedQuery<LeaveRequest> query = entityManager.createQuery(jpql, LeaveRequest.class);
            query.setParameter("employeeId", employeeId);
            query.setParameter("status", StatusLeaveRequest.ACCEPTED);
            return query.getResultList();
        } catch (Exception e) {
            throw new RepoException(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    @Override
    public Boolean updateStatus(UUID leaveRequestId, StatusLeaveRequest newStatus) throws RepoException  {
        EntityManager entityManager = null;
        try {
            entityManager = PersistenceManager.getEntityManager();
            entityManager.getTransaction().begin();
            String jpql = "SELECT lr FROM LeaveRequest lr WHERE lr.id = :leaveRequestId";
            TypedQuery<LeaveRequest> query = entityManager.createQuery(jpql, LeaveRequest.class);
            query.setParameter("leaveRequestId", leaveRequestId);
            LeaveRequest leaveRequest = query.getSingleResult();
            if (leaveRequest != null) {
                leaveRequest.setStatus(newStatus);
                entityManager.merge(leaveRequest);
                entityManager.getTransaction().commit();

                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RepoException("Error updating leave request status: " + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }




}
