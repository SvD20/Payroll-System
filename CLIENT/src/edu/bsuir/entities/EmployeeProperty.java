package edu.bsuir.entities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeeProperty {

    private StringProperty login;
    private StringProperty password;

    public EmployeeProperty(Employee employee) {
        login = new SimpleStringProperty(employee.getLogin());
        password = new SimpleStringProperty(employee.getPassword());
    }

    public String getLogin() {
        return login.get();
    }

    public StringProperty loginProperty() {
        return login;
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
}
