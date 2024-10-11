package com.hrmastery.app.entity;

import com.hrmastery.app.enums.Role;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee extends User{
    @Column(name = "salary" ,nullable = false)
    private double salary;

    @Column(name = "numberOfChildren", nullable = false)
    private int numberOfChildren;

    @Column(name = "jobPosition" , nullable = false)
    private String jobPosition;

    @Column(name = "hireDate" , nullable = false)
    private Date hireDate;

    @Column(name = "cnss", nullable = false, unique = true)
    private String cnss;

    @Column(name = "department" , nullable = false)
    private String department;

    @Column(name = "leaveBalance" , nullable = false)
    private Integer leaveBalance;

    @OneToMany(mappedBy = "employee" , cascade = CascadeType.ALL)
    private List<LeaveRequest> LeaveRequests;

    @OneToMany(mappedBy = "employee" , cascade = CascadeType.ALL)
    private List<HistoryUpdate> historyUpdates;


    public Employee() {}

    public Employee(String name, String email, String address, String phoneNumber, Role role, double salary, int numberOfChildren, String jobPosition, Date hireDate, String cnss, String department, Integer leaveBalance) {
        super(name, email, address, phoneNumber, role);
        this.salary = salary;
        this.numberOfChildren = numberOfChildren;
        this.jobPosition = jobPosition;
        this.hireDate = hireDate;
        this.cnss = cnss;
        this.department = department;
        this.leaveBalance = leaveBalance;
    }

    public List<LeaveRequest> getLeaveRequests() {
        return LeaveRequests;
    }

    public void setLeaveRequests(List<LeaveRequest> leaveRequests) {
        LeaveRequests = leaveRequests;
    }

    public List<HistoryUpdate> getHistoryUpdates() {
        return historyUpdates;
    }

    public void setHistoryUpdates(List<HistoryUpdate> historyUpdates) {
        this.historyUpdates = historyUpdates;
    }

    public Integer getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(Integer leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getCnss() {
        return cnss;
    }

    public void setCnss(String cnss) {
        this.cnss = cnss;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
