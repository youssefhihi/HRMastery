package com.hrmastery.app.repository.inerfaces;

import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.entity.LeaveRequest;
import com.hrmastery.app.enums.StatusLeaveRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LeaveRequestRepo {

    Boolean create(LeaveRequest leaveRequest);

    Boolean update(LeaveRequest leaveRequest);

    List<LeaveRequest> findAll();

    Optional<LeaveRequest> findById(UUID id);

    Boolean delete(UUID id);

    List<LeaveRequest> findApprovedRequestsByEmployeeId(UUID employeeId) throws RepoException;

    Boolean updateStatus(UUID leaveRequestId, StatusLeaveRequest newStatus) throws RepoException ;
}
