package edu.bsuir.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "salarys_of_employee")
public class SalaryOfEmployee {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "form_of_payment_id")
    private FormOfPayment formOfPayment;

    @Column(name = "summa")
    private double summa;

    @Column(name = "date")
    private String date;

    public SalaryOfEmployee() {
    }

    public SalaryOfEmployee(double summa, String date) {
        this.summa = summa;
        this.date = date;
    }

    public SalaryOfEmployee(double summa, String date,Employee employee,FormOfPayment formOfPayment) {
        this.summa = summa;
        this.date = date;
        this.employee = employee;
        this.formOfPayment = formOfPayment;
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
