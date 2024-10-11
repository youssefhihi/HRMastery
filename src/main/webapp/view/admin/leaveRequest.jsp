<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Leave Request</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/admin/style/leaveRequest.css">
    <link
            href="https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css"
            rel="stylesheet"
    />
</head>
<body>
<%@ include file="../component/sideBar.jsp" %>
<div class="home_content">
    <!-- Display error messages -->
    <c:if test="${not empty errors}">
    <div class="">
        <c:forEach var="error" items="${errors}">
            <div class="popup error-popup">
                <div class="popup-icon error-icon">
                    <svg
                            class="error-svg"
                            xmlns="http://www.w3.org/2000/svg"
                            viewBox="0 0 20 20"
                            aria-hidden="true"
                    >
                        <path
                                fill-rule="evenodd"
                                d="M10 18a8 8 0 100-16 8 8 0 000 16zM8.707 7.293a1 1 0 00-1.414 1.414L8.586 10l-1.293 1.293a1 1 0 101.414 1.414L10 11.414l1.293 1.293a1 1 0 001.414-1.414L11.414 10l1.293-1.293a1 1 0 00-1.414-1.414L10 8.586 8.707 7.293z"
                                clip-rule="evenodd"
                        ></path>
                    </svg>
                </div>
                <div class="error-message-alert">${error}</div>
                <div class="popup-icon close-icon">
                    <svg
                            xmlns="http://www.w3.org/2000/svg"
                            viewBox="0 0 20 20"
                            class="close-svg"
                    >
                        <path
                                d="m15.8333 5.34166-1.175-1.175-4.6583 4.65834-4.65833-4.65834-1.175 1.175 4.65833 4.65834-4.65833 4.6583 1.175 1.175 4.65833-4.6583 4.6583 4.6583 1.175-1.175-4.6583-4.6583z"
                                class="close-path"
                        ></path>
                    </svg>
                </div>
            </div>
        </c:forEach>
    </div>
    </c:if>
    <div class="container">
        <ul class="responsive-table">
            <li class="table-header">
                <div class="col col-1">Name</div>
                <div class="col col-2">Email</div>
                <div class="col col-3">Start Date</div>
                <div class="col col-4">Duration</div>
                <div class="col col-5">Reason</div>
                <div class="col col-6">Certificate</div>
                <div class="col col-7">Status</div>
                <div class="col col-8">Operations</div>
            </li>

            <c:forEach var="leaveRequest" items="${leaveRequests}">
                <li class="table-row">
                    <div class="col col-1" data-label="name">${leaveRequest.getEmployee().getName()}</div>
                    <div class="col col-2" data-label="email">${leaveRequest.getEmployee().getEmail()}</div>
                    <div class="col col-3" data-label="startDate">${leaveRequest.getStartDate()}</div>
                    <div class="col col-4" data-label="duration">${leaveRequest.getDuration()}</div>
                    <div class="col col-5" data-label="reason">${leaveRequest.getReason()}</div>
                    <div class="col col-6" data-label="certificate">
                        <a href="${pageContext.request.contextPath}${leaveRequest.getCertificate()}">click here</a>
                    </div>
                    <div class="col col-7" data-label="status">${leaveRequest.getStatus()}</div>
                    <div class="col col-8 operations" data-label="operations">
                        <form action="${pageContext.request.contextPath}/LeaveRequest/updateStatus" method="POST">
                            <input type="hidden" name="requestId" value="${leaveRequest.getRequestId()}" />
                            <select name="status" required>
                                <option value="PENDING" ${leaveRequest.getStatus().equals('PENDING') ? 'selected' : ''}>Pending</option>
                                <option value="ACCEPTED" ${leaveRequest.getStatus().equals('ACCEPTED') ? 'selected' : ''}>Approve</option>
                                <option value="REJECTED" ${leaveRequest.getStatus().equals('REJECTED') ? 'selected' : ''}>Reject</option>
                            </select>
                            <button type="submit">Submit</button>
                        </form>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>

</div>
</body>
</html>
