package edu.bsuir.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class MySalary {

    @JsonIgnore
    private int id;

    @JsonIgnore
    private Employee employee;

    private double summa;
    private String date;

    public MySalary() {}

    public MySalary(double summa, String date) {
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
        return "MySalary{" +
                "id=" + id +
                ", employee=" + employee +
                ", summa=" + summa +
                ", date='" + date + '\'' +
                '}';
    }
}
