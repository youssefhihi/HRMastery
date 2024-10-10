package com.hrmastery.app.Utils.JMailler.Validation;

import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeValidation {

    public static List<String> validateEmployee(Employee employee) {
        List<String> errors = new ArrayList<>();

        // Validate name
        if (employee.getName() == null || employee.getName().length() < 2 || employee.getName().length() > 50) {
            errors.add("Name must be between 2 and 50 characters.\n");
        }

        // Validate email
        if (employee.getEmail() == null || !employee.getEmail().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errors.add("Please enter a valid email.\n");
        }

        // Validate address
        if (employee.getAddress() == null || employee.getAddress().length() < 5 || employee.getAddress().length() > 100) {
            errors.add("Address must be between 5 and 100 characters.\n");
        }

        // Validate phone number
        if (employee.getPhoneNumber() == null || !employee.getPhoneNumber().matches("\\d{10}")) {
            errors.add("Phone number must be 10 digits.\n");
        }

        // Validate role
        if (employee.getRole() == null) {
            errors.add("Role must not be null.\n");
        }

        // Validate salary
        if ( employee.getSalary() < 0) {
            errors.add("Salary must be a positive number.\n");
        }

        // Validate number of children
        if ( employee.getNumberOfChildren() < 0) {
            errors.add("Number of children must be zero or a positive integer.\n");
        }

        // Validate job position
        if (employee.getJobPosition() == null || employee.getJobPosition().length() < 2 || employee.getJobPosition().length() > 50) {
            errors.add("Job position must be between 2 and 50 characters.\n");
        }

        // Validate hire date
        if (employee.getHireDate() == null) {
            errors.add("Hire date must not be null.\n");
        }

        // Validate CNSS (social security number)
        if (employee.getCnss() == null || employee.getCnss().length() != 15) {
            errors.add("CNSS must be exactly 15 characters long.\n");
        }

        // Validate department
        if (employee.getDepartment() == null || employee.getDepartment().length() < 2 || employee.getDepartment().length() > 50) {
            errors.add("Department must be between 2 and 50 characters.\n");
        }

        return errors;
    }

}
