package edu.bsuir.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "my_salarys")
public class MySalary {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "summa")
    private double summa;

    @Column(name = "date")
    private String date;

    public MySalary() {}

    public MySalary(double summa, String date) {
        this.summa = summa;
        this.date = date;
    }

    public MySalary(double summa, String date,Employee employee) {
        this.summa = summa;
        this.date = date;
        this.employee = employee;
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
