package com.hrmastery.app.servlet;

import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.Utils.Validation.RecruitmentValidation;
import com.hrmastery.app.entity.Recruitment;
import com.hrmastery.app.enums.Role;
import com.hrmastery.app.service.impl.RecruitmentServiceImpl;
import com.hrmastery.app.service.interfaces.RecruitmentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class RecruitmentServlet {


    RecruitmentService recruitmentService;
    public void init() {
        recruitmentService = new RecruitmentServiceImpl();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        getRecruitments(req, res);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        String action = req.getServletPath();

        switch (action) {
            case "/recruitments/add":
                createRecruitment(req, res);
                break;
            case "/recruitments/delete":
                deleteRecruitment(req, res);
                break;
            case "/recruitments/apply":
            default:
                break;
        }
    }


    private void createRecruitment(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
        Recruitment recruitment = new Recruitment(

        );
        try {
//            errors.addAll(RecruitmentValidation.validateRecruitment(recruitment));
            if (errors.isEmpty()) {
                success =  recruitmentService.createRecruitment(recruitment);
                req.setAttribute("success", success);
            }
        } catch (RepoException e) {
            errors.add(e.getMessage());
        }
        req.setAttribute("errors", errors);
        getRecruitments(req,res);
    }





    private void deleteRecruitment(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<String> errors = new ArrayList<>();
        String success ;
        try {
            success =  recruitmentService.deleteRecruitment(UUID.fromString(req.getParameter("id")));
            req.setAttribute("success", success);
        } catch (RepoException e) {
            errors.add(e.getMessage());
        }
        req.setAttribute("errors", errors);
        getRecruitments(req,res);
    }

    public void getRecruitments(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        List<Recruitment> recruitments = recruitmentService.getAllRecruitments();
        req.setAttribute("recruitments", recruitments);
        req.getServletContext().getRequestDispatcher("/view/employee/recruiter/dashboard.jsp").forward(req,res);
    }

    public void destroy() {
    }
}
