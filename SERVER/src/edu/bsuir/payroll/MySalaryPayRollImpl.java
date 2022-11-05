package edu.bsuir.payroll;

import edu.bsuir.entities.DataForRollingSalaryOfEmployee;
import edu.bsuir.entities.Employee;
import edu.bsuir.entities.FormOfPayment;
import edu.bsuir.entities.MySalary;
import edu.bsuir.services.EmployeeServiceImpl;
import edu.bsuir.services.Service;

import java.util.List;

public class MySalaryPayRollImpl implements PayRoll<MySalary>{

    Service employeeService = new EmployeeServiceImpl();

    Employee employee = null;

    @Override
    public MySalary payroll_by_month_rate(FormOfPayment validFormOfPayment, DataForRollingSalaryOfEmployee dataForRollingSalaryOfEmployee) {
        double summa = validFormOfPayment.getRate()/(dataForRollingSalaryOfEmployee.getWorking_days_per_month()
                *dataForRollingSalaryOfEmployee.getDays_actually_worked());
        String date = dataForRollingSalaryOfEmployee.getDate();
        List<Employee> employeesList = employeeService.findAllEntities();
        for (Employee emp: employeesList ){
            if(emp.getLogin().equals(dataForRollingSalaryOfEmployee.getLogin_of_employee())){
                employee = emp;
            }
        }
        MySalary mySalary = new MySalary(summa,date,employee);
        return mySalary;
    }

    @Override
    public MySalary payroll_by_daily_rate( FormOfPayment validFormOfPayment, DataForRollingSalaryOfEmployee dataForRollingSalaryOfEmployee) {
        double summa = validFormOfPayment.getRate()*dataForRollingSalaryOfEmployee.getDays_actually_worked();
        String date = dataForRollingSalaryOfEmployee.getDate();

        List<Employee>employeesList = employeeService.findAllEntities();
        for (Employee emp: employeesList ){
            if(emp.getLogin().equals(dataForRollingSalaryOfEmployee.getLogin_of_employee())){
                employee = emp;
            }
        }

        MySalary mySalary = new MySalary(summa,date,employee);
        return mySalary;
    }

    @Override
    public MySalary payroll_by_hourly_rate(FormOfPayment validFormOfPayment, DataForRollingSalaryOfEmployee dataForRollingSalaryOfEmployee) {
        double summa = validFormOfPayment.getRate()*dataForRollingSalaryOfEmployee.getHours_actually_worked();
        String date = dataForRollingSalaryOfEmployee.getDate();

        List<Employee>employeesList = employeeService.findAllEntities();
        for (Employee emp: employeesList ){
            if(emp.getLogin().equals(dataForRollingSalaryOfEmployee.getLogin_of_employee())){
                employee = emp;
            }
        }
        MySalary mySalary = new MySalary(summa,date,employee);
        return mySalary;
    }
}
