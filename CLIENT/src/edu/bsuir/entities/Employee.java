package edu.bsuir.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;


public class Employee {

    @JsonIgnore
    private int id;

    private String login;
    private String password;

    @JsonIgnore
    private List<MySalary> mysalarys;
    @JsonIgnore
    private List<SalaryOfEmployee> salarysofemployee;

    public Employee() {
    }

    public Employee(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void addMySalaryToEmployee(MySalary mySalary){
         if(mysalarys == null){
             mysalarys = new ArrayList<>();
         }
         mysalarys.add(mySalary);
         mySalary.setEmployee(this);
    }

    public void addSalaryOfEmployeeToEmployee(SalaryOfEmployee salaryOfEmployee){
        if(salarysofemployee == null){
            salarysofemployee = new ArrayList<>();
        }
        salarysofemployee.add(salaryOfEmployee);
        salaryOfEmployee.setEmployee(this);
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<MySalary> getMysalarys() {
        return mysalarys;
    }

    public void setMysalarys(List<MySalary> mysalarys) {
        this.mysalarys = mysalarys;
    }

    public List<SalaryOfEmployee> getSalarysofemployee() {
        return salarysofemployee;
    }

    public void setSalarysofemployee(List<SalaryOfEmployee> salarysofemployee) {
        this.salarysofemployee = salarysofemployee;
    }
}
