
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/employeePart.css">

</head>
<body>
<div class="container">
    <h1>Leave Request</h1>
    <form id="leaveRequestForm" action="${pageContext.request.contextPath}/leaveRequest/add" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="employeeNam">Employee id:</label>
            <input type="text" id="employeeNam" name="employeeId">
            <div id="nameError" class="error-message">Name must be 2-50 characters long.</div>
        </div>
        <div class="form-group">
            <label for="startDate">Start Date:</label>
            <input type="date" id="startDate" name="startDate">
            <div id="startDateError" class="error-message">Start date must be today or in the future.</div>
        </div>

        <div class="form-group">
            <label for="duration">Duration (days):</label>
            <input type="number" id="duration" min="1" name="duration" >
            <div id="durationError" class="error-message">Duration must be at least 1 day.</div>
        </div>
        <div class="form-group">
            <label for="reason">Reason for Leave:</label>
            <textarea id="reason" rows="4" name="reason" ></textarea>
            <div id="reasonError" class="error-message">Reason must be at least 10 characters long.</div>
        </div>
        <div class="form-group">
            <label for="certificate">Upload Certificate (PDF):</label>
            <input type="file" id="certificate" name="certificate" accept=".pdf">
            <div id="certificateError" class="error-message">File must be a PDF.</div>
        </div>
        <button type="submit" id="submitBtn">Submit Request</button>
    </form>
</div>
</body>
</html>
