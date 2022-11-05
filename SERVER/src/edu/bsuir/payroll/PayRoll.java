package edu.bsuir.payroll;

import edu.bsuir.entities.DataForRollingSalaryOfEmployee;
import edu.bsuir.entities.FormOfPayment;

public interface PayRoll <T>{

    T payroll_by_month_rate (FormOfPayment validFormOfPayment, DataForRollingSalaryOfEmployee dataForRollingSalaryOfEmployee);

    T payroll_by_daily_rate(FormOfPayment validFormOfPayment,DataForRollingSalaryOfEmployee dataForRollingSalaryOfEmployee);

    T payroll_by_hourly_rate(FormOfPayment validFormOfPayment,DataForRollingSalaryOfEmployee dataForRollingSalaryOfEmployee);

}





