package com.hrmastery.app.service.impl;

import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.Utils.Mail.JMailer;
import com.hrmastery.app.Utils.Mail.MailMsg;
import com.hrmastery.app.entity.LeaveRequest;
import com.hrmastery.app.repository.impl.LeaveRequestRepoImpl;
import com.hrmastery.app.repository.inerfaces.LeaveRequestRepo;
import com.hrmastery.app.service.interfaces.LeaveRequestService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class LeaveRequestServiceImpl implements LeaveRequestService {

    private final LeaveRequestRepo leaveRequestRepo = new LeaveRequestRepoImpl();

    private boolean isOverlapping(LeaveRequest newRequest) {
        List<LeaveRequest> approvedRequests = leaveRequestRepo.findApprovedRequestsByEmployeeId(newRequest.getEmployee().getId());

        return approvedRequests.stream()
                .anyMatch(request ->
                        newRequest.getStartDate().isBefore(request.getEndDate()) &&
                                newRequest.getEndDate().isAfter(request.getStartDate())
                );
    }


    @Override
    public String createLeaveRequest(LeaveRequest leaveRequest) throws RepoException {
        if (leaveRequest.getDuration() > leaveRequest.getEmployee().getLeaveBalance()) {
            throw new RepoException("The number of days requested exceeds the leave balance.");

        }
        if (isOverlapping(leaveRequest)) {
            throw new RepoException("Overlapping request");
        }
        try {
            Boolean isAdded = leaveRequestRepo.create(leaveRequest);
            if (isAdded) {
                new JMailer().sendEmail("New Leave Request ", MailMsg.newLeaveRequest(leaveRequest),"youssefhihi18@gmail.com");
                return "LeaveRequest added successfully";
            }
        } catch (RepoException e) {
            throw new RepoException(e.getMessage());
        } catch (Exception e) {
            throw new RepoException(e.getMessage());
        }
        return null;
    }

    @Override
    public String updateLeaveRequest(LeaveRequest leaveRequest) throws RepoException {
        try {
            Boolean isUpdated = leaveRequestRepo.update(leaveRequest);
            if (isUpdated) {
                return "LeaveRequest updated successfully";
            }
        } catch (RepoException e) {
            throw new RepoException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<LeaveRequest> getAllLeaveRequests() throws RepoException {
        return leaveRequestRepo.findAll();
    }

    @Override
    public LeaveRequest getLeaveRequest(UUID leaveRequestId) throws RepoException {
        Optional<LeaveRequest> leaveRequest = leaveRequestRepo.findById(leaveRequestId);
        if (leaveRequest.isPresent()) {
            return leaveRequest.get();
        }else {
            throw new RepoException("LeaveRequest not found");
        }
    }


    @Override
    public String deleteLeaveRequest(UUID leaveRequestId) throws RepoException {
        try{
            Boolean isAdded =  leaveRequestRepo.delete(leaveRequestId);
            if(isAdded) {
                return "LeaveRequest deleted successfully";
            }
        }catch (RepoException e) {
            throw new RepoException(e.getMessage());
        }
        return null;
    }

}
