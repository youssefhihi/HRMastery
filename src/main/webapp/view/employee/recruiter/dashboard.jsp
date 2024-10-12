<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/admin/style/admin.css">
    <link
            href="https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css"
            rel="stylesheet"
    />
</head>
<body>
<%@ include file="../../component/sideBar.jsp" %>
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
    <button class="showFormButton">create recruitment</button>
    <div class="container">
        <ul class="responsive-table">
            <li class="table-header">
                <div class="col col-1">Title  </div>
                <div class="col col-2"> Description</div>
                <div class="col col-3">skills</div>
                <div class="col col-4">Start Date</div>
                <div class="col col-4">date End</div>
                <div class="col col-4">Operations</div>
            </li>
            <c:forEach var="recruitment" items="${recruitments}">
                <li class="table-row">
                    <div class="col col-1" data-label="name">${recruitment.getTitle()}</div>
                    <div class="col col-2" data-label="email">${recruitment.getDesc()}</div>
                    <div class="col col-3" data-label="department">${recruitment.getSkills()}</div>
                    <div class="col col-4" data-label="phone">${recruitment.getStartDate()}</div>
                    <div class="col col-5" data-label="post">${recruitment.getEndDate()}</div>
                    <div class="col col-5 operations" data-label="operations">
                        <form class="deleteForm" action="${pageContext.request.contextPath}/recruitments" method="post" onsubmit="return confirm('Are you sure you want to delete this recruitment?')">
                            <input type="hidden" name="id" value="${recruitment.getId()}" />
                            <button type="submit" class="delete-icon">
                                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 30 30">
                                    <path d="M 14.984375 2.4863281 A 1.0001 1.0001 0 0 0 14 3.5 L 14 4 L 8.5 4 A 1.0001 1.0001 0 0 0 7.4863281 5 L 6 5 A 1.0001 1.0001 0 1 0 6 7 L 24 7 A 1.0001 1.0001 0 1 0 24 5 L 22.513672 5 A 1.0001 1.0001 0 0 0 21.5 4 L 16 4 L 16 3.5 A 1.0001 1.0001 0 0 0 14.984375 2.4863281 z M 6 9 L 7.7929688 24.234375 C 7.9109687 25.241375 8.7633438 26 9.7773438 26 L 20.222656 26 C 21.236656 26 22.088031 25.241375 22.207031 24.234375 L 24 9 L 6 9 z"></path>
                                </svg>
                            </button>
                        </form>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div id="form-container">
        <h2 id="form-title">Add Employee</h2>
        <form id="recruitmentForm" action="${pageContext.request.contextPath}/recruitments/add" method="post">
            <div class="form-group">
                <label for="title">Title:</label>
                <input type="text" id="title" name="title">
                <span id="titleValid" class="error-message">Please enter a valid title.</span>
            </div>

            <div class="form-group">
                <label for="description">Description:</label>
                <input type="text" id="description" name="description">
                <span id="descriptionValid" class="error-message">Please enter a valid description .</span>
            </div>

            <div class="form-group">
                <label for="skills">Skills:</label>
                <input type="text" id="skills" name="skills">
                <span id="skillsValid" class="error-message">Please enter a valid skills.</span>
            </div>
            <div class="form-group">
                <label for="endDate">End Date:</label>
                <input type="date" id="endDate" name="endDate">
                <span id="endDateValid" class="error-message">Please enter a valid Date .</span>
            </div>

            <button type="submit" id="submit-btn">Save</button>
        </form>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/admin.js"></script>
</body>
</html>