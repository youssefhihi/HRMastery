package com.hrmastery.app.repository.inerfaces;

import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.entity.LeaveRequest;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LeaveRequestRepo {

    Boolean create(LeaveRequest leaveRequest);

    Boolean update(LeaveRequest leaveRequest);

    List<LeaveRequest> findAll();

    Optional<LeaveRequest> findById(UUID id);

    Boolean delete(UUID id);

    public List<LeaveRequest> findApprovedRequestsByEmployeeId(UUID employeeId) throws RepoException;
}
