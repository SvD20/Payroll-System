package edu.bsuir.entities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SalaryOfEmployeeProperty {

    private StringProperty summa;
    private StringProperty date;

    public SalaryOfEmployeeProperty(SalaryOfEmployee salaryOfEmployee) {
        summa = new SimpleStringProperty(String.valueOf(salaryOfEmployee.getSumma()));
        date = new SimpleStringProperty(salaryOfEmployee.getDate());
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getSumma() {
        return summa.get();
    }

    public StringProperty summaProperty() {
        return summa;
    }

    public void setSumma(String summa) {
        this.summa.set(summa);
    }
}
