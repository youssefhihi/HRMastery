<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin | Update Employee</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/employee.css">
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
    <div id="form-container">
        <h2 id="form-title">Update Employee</h2>
        <form id="employeeForm" action="${pageContext.request.contextPath}/employees/update" method="post">
            <input type="hidden" name="id" value="${employee.getId()}">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" value="${employee.getName()}">
                <span id="nameValid" class="error-message">Please enter a valid name.</span>
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="${employee.getEmail()}">
                <span id="emailValid" class="error-message">Please enter a valid email address.</span>
            </div>

            <div class="form-group">
                <label for="password">Email:</label>
                <input type="password" id="password" name="password" value="${employee.getPassword()}">
                <span id="passwordValid" class="error-message">Please enter a valid password.</span>
            </div>

            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" id="address" name="address" value="${employee.getAddress()}">
                <span id="addressValid" class="error-message">Please enter a valid address.</span>
            </div>
            <div class="form-group">
                <label for="phoneNumber">Phone Number:</label>
                <input type="text" id="phoneNumber" name="phoneNumber" value="${employee.getPhoneNumber()}">
                <span id="phoneNumberValid" class="error-message">Please enter a valid Phone Number .</span>
            </div>

            <div class="form-group">
                <label for="department">Department:</label>
                <input type="text" id="department" name="department" value="${employee.getDepartment()}">
                <span id="departmentValid" class="error-message">Please enter a valid department.</span>
            </div>

            <div class="form-group">
                <label for="salary">Salary:</label>
                <input type="number" step="0.01" id="salary" name="salary" value="${employee.getSalary()}">
                <span id="salaryValid" class="error-message">Please enter a valid salary.</span>
            </div>

            <div class="form-group">
                <label for="children">Number of Children:</label>
                <input type="number" id="children" name="numberOfChildren" value="${employee.getNumberOfChildren()}">
                <span id="childrenValid" class="error-message">Please enter a valid number of children.</span>
            </div>

            <div class="form-group">
                <label for="jobPosition">Job Position:</label>
                <input type="text" id="jobPosition" name="jobPosition" value="${employee.getJobPosition()}">
                <span id="jobPositionValid" class="error-message">Please enter a valid job position.</span>
            </div>

            <div class="form-group">
                <label for="hireDate">Hire Date:</label>
                <input type="date" id="hireDate" name="hireDate" value="${employee.getHireDate()}">
                <span id="hireDateValid" class="error-message">Please enter a valid hire date, Hire date cannot be in the future.</span>
            </div>

            <div class="form-group">
                <label for="cnss">CNSS:</label>
                <input type="text" id="cnss" name="cnss" value="${employee.getCnss()}">
                <span id="cnssValid" class="error-message">Please enter a valid CNSS number.</span>
            </div>

            <button type="submit" id="submit-btn">Save</button>
        </form>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/admin.js"></script>
</body>
</html>