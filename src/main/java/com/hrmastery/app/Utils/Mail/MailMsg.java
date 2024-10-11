package com.hrmastery.app.Utils.Mail;

import com.hrmastery.app.entity.LeaveRequest;

public class MailMsg {

    public static String newLeaveRequest(LeaveRequest leaveRequest) {
        return "<html>" +
                "<body>" +
                "<p>Dear Admin,</p>" +
                "<p>A new leave request has been submitted for your review. Please find the details below:</p>" +
                "<ul>" +
                "<li><strong>Employee Name</strong>: " + leaveRequest.getEmployee().getName() + "</li>" +
                "<li><strong>Start Date</strong>: " + leaveRequest.getStartDate() + "</li>" +
                "<li><strong>End Date</strong>: " + leaveRequest.getEndDate() + "</li>" +
                "<li><strong>Duration</strong>: " + leaveRequest.getDuration() + " day(s)</li>" +
                "<li><strong>Reason</strong>: " + leaveRequest.getReason() + "</li>" +
                "<li><strong>Status</strong>: Pending Approval</li>" +
                "</ul>" +
                "<p>Please take a moment to review this request and decide whether to approve or refuse it.</p>" +
                "<p>To consult leave requests from employees, click here: <a href='http://localhost:8080/leaveRequest/pending'>Consult Leave Requests</a></p>" +
                "<p>Thank you for your attention to this matter.</p>" +
                "<p>Best regards,<br>HRMastery</p>" +
                "</body>" +
                "</html>";
    }


}
