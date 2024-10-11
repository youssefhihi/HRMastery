package com.hrmastery.app.Utils.Validation;
import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.entity.LeaveRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LeaveRequestValidation {

    public static List<String> validateLeaveRequest(LeaveRequest leaveRequest) {
        List<String> errors = new ArrayList<>();

        // Validate start date
        if (leaveRequest.getStartDate() == null) {
            errors.add("Start date must not be null.\n");
        }

        if (leaveRequest.getStartDate().isBefore(LocalDateTime.now()) || leaveRequest.getStartDate().isEqual(LocalDateTime.now())) {
            errors.add("Start date must be in the future, not today or in the past.\n");
        }


        // Validate duration
        if (leaveRequest.getDuration() == null || leaveRequest.getDuration() <= 0) {
            errors.add("Duration must be a positive integer.\n");
        }

        // Validate certificate
        if (leaveRequest.getCertificate() == null ) {
            errors.add("Certificate must not be null.\n");
        }

        // Validate status
        if (leaveRequest.getStatus() == null) {
            errors.add("Status must not be null.\n");
        }

        // Validate reason
        if (leaveRequest.getReason() == null || leaveRequest.getReason().length() < 5 || leaveRequest.getReason().length() > 250) {
            errors.add("Reason must be between 5 and 250 characters.\n");
        }

        // Validate employee
        if (leaveRequest.getEmployee() == null) {
            errors.add("Employee must not be null.\n");
        }

        return errors;
    }

}