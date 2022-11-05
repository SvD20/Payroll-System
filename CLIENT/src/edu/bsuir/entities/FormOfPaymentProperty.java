package edu.bsuir.entities;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FormOfPaymentProperty {

    private StringProperty title;
    private DoubleProperty rate;
    private StringProperty date_of_start;

    public FormOfPaymentProperty(FormOfPayment formOfPayment) {
        title = new SimpleStringProperty(formOfPayment.getTitle());
        rate = new SimpleDoubleProperty(formOfPayment.getRate());
        date_of_start= new SimpleStringProperty(formOfPayment.getDate_of_start());
    }

    public String getDate_of_start() {
        return date_of_start.get();
    }

    public StringProperty date_of_startProperty() {
        return date_of_start;
    }

    public void setDate_of_start(String date_of_start) {
        this.date_of_start.set(date_of_start);
    }

    public double getRate() {
        return rate.get();
    }

    public DoubleProperty rateProperty() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate.set(rate);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }
}
