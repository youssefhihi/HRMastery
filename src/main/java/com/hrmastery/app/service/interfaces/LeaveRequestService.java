package com.hrmastery.app.service.interfaces;

import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.entity.Employee;
import com.hrmastery.app.entity.LeaveRequest;
import com.hrmastery.app.enums.StatusLeaveRequest;

import java.util.List;
import java.util.UUID;

public interface LeaveRequestService {
    String createLeaveRequest(LeaveRequest LeaveRequest) throws RepoException;
    String updateLeaveRequest(LeaveRequest LeaveRequest) throws RepoException;
    List<LeaveRequest> getAllLeaveRequests() throws RepoException;
    LeaveRequest getLeaveRequest(UUID LeaveRequestId) throws RepoException;
    String deleteLeaveRequest(UUID LeaveRequestId) throws RepoException;
    String updateStatus(UUID leaveRequestId, StatusLeaveRequest newStatus) throws RepoException;
}
