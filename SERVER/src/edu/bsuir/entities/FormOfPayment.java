package edu.bsuir.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "form_of_payment")
public class FormOfPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "day_of_start")
    private String date_of_start;

    @OneToMany(mappedBy = "formOfPayment")    //cascade = CascadeType.ALL
    @JsonIgnore
    private List<SalaryOfEmployee> salarysOfEmployees;

    public FormOfPayment() {
    }

    public FormOfPayment(String title, Double rate, String date_of_start) {
        this.title = title;
        this.rate = rate;
        this.date_of_start = date_of_start;
    }

    @Override
    public String toString() {
        return "FormOfPayment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rate=" + rate +
                ", date_of_start='" + date_of_start + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getDate_of_start() {
        return date_of_start;
    }

    public void setDate_of_start(String date_of_start) {
        this.date_of_start = date_of_start;
    }
}
