package edu.bsuir.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

public class FormOfPayment {

    @JsonIgnore
    private int id;

    private String title;
    private Double rate;
    private String date_of_start;

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
