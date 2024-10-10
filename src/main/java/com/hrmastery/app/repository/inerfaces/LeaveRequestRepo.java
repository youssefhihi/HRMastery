package com.hrmastery.app.repository.inerfaces;

import com.hrmastery.app.entity.LeaveRequest;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LeaveRequestRepo {

    LeaveRequest create(LeaveRequest leaveRequest);

    LeaveRequest update(LeaveRequest leaveRequest);

    List<LeaveRequest> findAll();

    Optional<LeaveRequest> findById(UUID id);

    void delete(UUID id);
}
