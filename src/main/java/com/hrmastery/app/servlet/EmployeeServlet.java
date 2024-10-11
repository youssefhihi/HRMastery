package com.hrmastery.app.servlet;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.Utils.Validation.EmployeeValidation;
import com.hrmastery.app.entity.Employee;
import com.hrmastery.app.enums.Role;
import com.hrmastery.app.service.impl.EmployeeServiceImpl;
import com.hrmastery.app.service.interfaces.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "employeeServlet", value = {"/employees", "/employees/add","/employees/edit","/employees/update"})
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService;
    public void init() {
        employeeService = new EmployeeServiceImpl();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        if(req.getServletPath().equals("/employees/edit")) {
            Employee employee = employeeService.getEmployee(UUID.fromString(req.getParameter("employee")));
            req.setAttribute("employee", employee);
            getServletContext().getRequestDispatcher("/view/admin/UpdateEmployee.jsp").forward(req, res);
        }else{
            getEmployees(req, res);
        }
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
         String action = req.getServletPath();

        switch (action) {
            case "/employees/add":
                createEmployee(req, res);
                break;
            case "/employees/update":
                updateEmployee(req, res);
                break;
            case "/employees":
                deleteEmployee(req, res);
                break;
            default:
                break;
        }
    }


    private void createEmployee(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<String> errors = new ArrayList<>();
        String success ;
        String hireDateString = req.getParameter("hireDate");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date hireDate = null;
        try {
         hireDate = dateFormat.parse(hireDateString);
        } catch (ParseException e) {
            errors.add(e.getMessage());
        }
            Employee employee = new Employee(
                req.getParameter("name"),
                req.getParameter("email"),
                req.getParameter("address"),
                req.getParameter("phoneNumber"),
                Role.employee,
                Double.parseDouble(req.getParameter("salary")),
                Integer.parseInt(req.getParameter("numberOfChildren")),
                req.getParameter("jobPosition"),
                hireDate,
                req.getParameter("cnss"),
                req.getParameter("department"),
                Integer.parseInt(req.getParameter("leaveBalance"))
        );
        employee.setPassword("1234567890");
        try {
            errors.addAll(EmployeeValidation.validateEmployee(employee));
            if (errors.isEmpty()) {
            success =  employeeService.createEmployee(employee);
            req.setAttribute("success", success);
            }
        } catch (RepoException e) {
           errors.add(e.getMessage());
        }
        req.setAttribute("errors", errors);
        getEmployees(req,res);
    }

    private void updateEmployee(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<String> errors = new ArrayList<>();
        String success ;
        String hireDateString = req.getParameter("hireDate");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date hireDate = null;
        try {
            hireDate = dateFormat.parse(hireDateString);
        } catch (ParseException e) {
            errors.add(e.getMessage());
        }
        Employee employee = new Employee(
                req.getParameter("name"),
                req.getParameter("email"),
                req.getParameter("address"),
                req.getParameter("phoneNumber"),
                Role.employee,
                Double.parseDouble(req.getParameter("salary")),
                Integer.parseInt(req.getParameter("numberOfChildren")),
                req.getParameter("jobPosition"),
                hireDate,
                req.getParameter("cnss"),
                req.getParameter("department"),
                Integer.parseInt(req.getParameter("leaveBalance"))

        );
        employee.setId(UUID.fromString(req.getParameter("id")));
        employee.setPassword("1234567890");
        try {
            errors.addAll(EmployeeValidation.validateEmployee(employee));
            if (errors.isEmpty()) {
                success =  employeeService.updateEmployee(employee);
                req.setAttribute("success", success);
            }
        } catch (RepoException e) {
            errors.add(e.getMessage());
        }
        req.setAttribute("errors", errors);
        getEmployees(req,res);
    }



    private void deleteEmployee(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<String> errors = new ArrayList<>();
        String success ;
        try {
            success =  employeeService.deleteEmployee(UUID.fromString(req.getParameter("id")));
            req.setAttribute("success", success);
        } catch (RepoException e) {
            errors.add(e.getMessage());
        }
        req.setAttribute("errors", errors);
        getEmployees(req,res);
    }

    public void getEmployees(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        List<Employee> employees = employeeService.getAllEmployees();
        req.setAttribute("employees", employees);
        getServletContext().getRequestDispatcher("/view/admin/dashboard.jsp").forward(req,res);
    }

    public void destroy() {
    }
}