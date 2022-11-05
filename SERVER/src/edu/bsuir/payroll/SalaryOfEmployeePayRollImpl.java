package edu.bsuir.payroll;

import edu.bsuir.entities.DataForRollingSalaryOfEmployee;
import edu.bsuir.entities.Employee;
import edu.bsuir.entities.FormOfPayment;
import edu.bsuir.entities.SalaryOfEmployee;
import edu.bsuir.services.EmployeeServiceImpl;
import edu.bsuir.services.FormOfPaymentServiceImpl;
import edu.bsuir.services.Service;

import java.util.List;

public class SalaryOfEmployeePayRollImpl implements PayRoll<SalaryOfEmployee>{

    Service employeeService = new EmployeeServiceImpl();
    Service formOfPaymentService = new FormOfPaymentServiceImpl();

    Employee employee = null;
    FormOfPayment formOfPayment = null;

    @Override
    public SalaryOfEmployee payroll_by_month_rate(FormOfPayment validFormOfPayment, DataForRollingSalaryOfEmployee dataForRollingSalaryOfEmployee) {
        double summa = validFormOfPayment.getRate()/(dataForRollingSalaryOfEmployee.getWorking_days_per_month()
                *dataForRollingSalaryOfEmployee.getDays_actually_worked());
        String date = dataForRollingSalaryOfEmployee.getDate();
        List<Employee>employeesList = employeeService.findAllEntities();
        for (Employee emp: employeesList ){
            if(emp.getLogin().equals(dataForRollingSalaryOfEmployee.getLogin_of_employee())){
                 employee = emp;
            }
        }

        List<FormOfPayment>formOfPaymentList = formOfPaymentService.findAllEntities();
        for (FormOfPayment form: formOfPaymentList){
            if(form.getTitle().equals(validFormOfPayment.getTitle())){
                formOfPayment = form;
            }
        }

        SalaryOfEmployee salaryOfEmployee = new SalaryOfEmployee(summa,date,employee,formOfPayment);
        return salaryOfEmployee;
    }

    @Override
    public SalaryOfEmployee payroll_by_daily_rate(FormOfPayment validFormOfPayment, DataForRollingSalaryOfEmployee dataForRollingSalaryOfEmployee){
        double summa = validFormOfPayment.getRate()*dataForRollingSalaryOfEmployee.getDays_actually_worked();
        String date = dataForRollingSalaryOfEmployee.getDate();

        List<Employee>employeesList = employeeService.findAllEntities();
        for (Employee emp: employeesList ){
            if(emp.getLogin().equals(dataForRollingSalaryOfEmployee.getLogin_of_employee())){
                employee = emp;
            }
        }

        List<FormOfPayment>formOfPaymentList = formOfPaymentService.findAllEntities();
        for (FormOfPayment form: formOfPaymentList){
            if(form.getTitle().equals(validFormOfPayment.getTitle())){
                formOfPayment = form;
            }
        }
        SalaryOfEmployee salaryOfEmployee = new SalaryOfEmployee(summa,date,employee,formOfPayment);
        return salaryOfEmployee;
    }

    @Override
    public SalaryOfEmployee payroll_by_hourly_rate(FormOfPayment validFormOfPayment, DataForRollingSalaryOfEmployee dataForRollingSalaryOfEmployee) {
        double summa = (validFormOfPayment.getRate())*(dataForRollingSalaryOfEmployee.getHours_actually_worked());
        String date = dataForRollingSalaryOfEmployee.getDate();

        List<Employee>employeesList = employeeService.findAllEntities();
        for (Employee emp: employeesList ){
            if(emp.getLogin().equals(dataForRollingSalaryOfEmployee.getLogin_of_employee())){
                employee = emp;
            }
        }

        List<FormOfPayment>formOfPaymentList = formOfPaymentService.findAllEntities();
        for (FormOfPayment form: formOfPaymentList){
            if(form.getTitle().equals(validFormOfPayment.getTitle())){
                formOfPayment = form;
            }
        }

        SalaryOfEmployee salaryOfEmployee = new SalaryOfEmployee(summa,date,employee,formOfPayment);
        return salaryOfEmployee;
    }
}
