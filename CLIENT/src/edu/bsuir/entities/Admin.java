package edu.bsuir.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Admin {

    @JsonIgnore
    private int id;

    private String login;
    private String password;

    public Admin() {
    }

    public Admin( String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
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
}
