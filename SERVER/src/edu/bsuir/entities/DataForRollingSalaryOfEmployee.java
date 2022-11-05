package edu.bsuir.entities;

public class DataForRollingSalaryOfEmployee {

    private int working_days_per_month;
    private int days_actually_worked;
    private int hours_actually_worked;
    private String date;
    private String login_of_employee;

    public DataForRollingSalaryOfEmployee() {
    }

    public DataForRollingSalaryOfEmployee(int working_days_per_month, int days_actually_worked, int hours_actually_worked,String login_of_employee, String date) {
        this.working_days_per_month = working_days_per_month;
        this.days_actually_worked = days_actually_worked;
        this.hours_actually_worked = hours_actually_worked;
        this.login_of_employee = login_of_employee;
        this.date = date;
    }

    @Override
    public String toString() {
        return "DataForRollingSalaryOfEmployee{" +
                "working_days_per_month=" + working_days_per_month +
                ", days_actually_worked=" + days_actually_worked +
                ", hours_actually_worked=" + hours_actually_worked +
                ", date='" + date + '\'' +
                ", login_of_employee='" + login_of_employee + '\'' +
                '}';
    }

    public String getLogin_of_employee() {
        return login_of_employee;
    }

    public void setLogin_of_employee(String login_of_employee) {
        this.login_of_employee = login_of_employee;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDays_actually_worked() {
        return days_actually_worked;
    }

    public void setDays_actually_worked(int days_actually_worked) {
        this.days_actually_worked = days_actually_worked;
    }

    public int getHours_actually_worked() {
        return hours_actually_worked;
    }

    public void setHours_actually_worked(int hours_actually_worked) {
        this.hours_actually_worked = hours_actually_worked;
    }

    public int getWorking_days_per_month() {
        return working_days_per_month;
    }

    public void setWorking_days_per_month(int working_days_per_month) {
        this.working_days_per_month = working_days_per_month;
    }
}
