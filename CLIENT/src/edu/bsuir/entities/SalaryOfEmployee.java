package edu.bsuir.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SalaryOfEmployee {

    @JsonIgnore
    private int id;
    @JsonIgnore
    private Employee employee;
    @JsonIgnore
    private FormOfPayment formOfPayment;

    private double summa;
    private String date;

    public SalaryOfEmployee() {
    }

    public SalaryOfEmployee(double summa, String date) {
        this.summa = summa;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public FormOfPayment getFormOfPayment() {
        return formOfPayment;
    }

    public void setFormOfPayment(FormOfPayment formOfPayment) {
        this.formOfPayment = formOfPayment;
    }

    public double getSumma() {
        return summa;
    }

    public void setSumma(double summa) {
        this.summa = summa;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SalaryOfEmployee{" +
                "id=" + id +
                ", employee=" + employee +
                ", formOfPayment=" + formOfPayment +
                ", summa=" + summa +
                ", date='" + date + '\'' +
                '}';
    }
}
