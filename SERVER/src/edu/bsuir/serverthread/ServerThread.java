package edu.bsuir.serverthread;

import edu.bsuir.entities.*;
import edu.bsuir.jsonprocessing.*;
import edu.bsuir.payroll.PayRoll;
import edu.bsuir.payroll.SalaryOfEmployeePayRollImpl;
import edu.bsuir.services.*;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThread extends Thread{

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    private static final String LOGINASADMIN = "LOGINASADMIN";
    private static final String LOGINASEMPLOYEE = "LOGINASEMPLOYEE";
    private static final String ADDNEWEMPLOYEE = "ADDNEWEMPLOYEE";
    private static final String DELETEEMPLOYEE = "DELETEEMPLOYEE";
    private static final String UPDATEEMPLOYEE = "UPDATEEMPLOYEE";
    private static final String VIEWALLEMPLOYEES = "VIEWALLEMPLOYEES";
    private static final String ADDFORMOFPAYMENT = "ADDFORMOFPAYMENT";
    private static final String DELETEFORMOFPAYMENT = "DELETEFORMOFPAYMENT";
    private static final String UPDATEFORMOFPAYMENT = "UPDATEFORMOFPAYMENT";
    private static final String VIEWFORMSOFPAYMENTS = "VIEWFORMSOFPAYMENTS";
    private static final String MAKETHEFORMVALID = "MAKETHEFORMVALID";
    private static final String ADDMONTHRATESALARYOFEMPLOYEE = "ADDMONTHRATESALARYOFEMPLOYEE";
    private static final String ADDDAILYRATESALARYOFEMPLOYEE = "ADDDAILYRATESALARYOFEMPLOYEE";
    private static final String ADDHOURLYRATESALARYOFEMPLOYEE = "ADDHOURLYRATESALARYOFEMPLOYEE";
    private static final String CHECKTHEVALIDFORMOFPAYMENT = "CHECKTHEVALIDFORMOFPAYMENT";
    private static final String VIEWSALARYSOFEMPLOYEE = "VIEWSALARYSOFEMPLOYEE";

    private static final String SUCCESS = "Success";
    private static final String FAIL = "Fail";

    FormOfPayment VALIDFORMOFPAYMENT = null;

    private int id_of_employee = 0;
    private int id_of_formOfPayment = 0 ;
    private List<SalaryOfEmployee> salaryOfEmployeeList_;

    JsonStringProcessing adminJsonStringProcessing = new AdminJsonStringProcessingImpl();
    EmployeeJsonStringProcessingImpl employeeJsonStringProcessing = new EmployeeJsonStringProcessingImpl();
    FormOfPaymentJsonStringProcessingImpl formOfPaymentJsonStringProcessing = new FormOfPaymentJsonStringProcessingImpl();
    JsonStringProcessing dataForRollingSalaryOfEmployeeJsonStringProcessing = new DataForRollingSalaryOfEmployeeJsonStringProcessingImpl();
    SalaryOfEmployeeJsonStringProcessingImpl salaryOfEmployeeJsonStringProcessing = new SalaryOfEmployeeJsonStringProcessingImpl();

    Service adminService = new AdminServiceImpl();
    Service employeeService = new EmployeeServiceImpl();
    Service formOfPaymentService = new FormOfPaymentServiceImpl();
    Service salaryOfEmployeeService = new SalaryOfEmployeeServiceImpl();

    PayRoll salaryOfEmployeePayRollImpl = new SalaryOfEmployeePayRollImpl();

    public ServerThread(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }

    @Override
    public void run() {

        try {
            while (true) {
                String typeOfOperation = in.readLine();
                String jsonStringObject = in.readLine();
                switch (typeOfOperation){
                    case LOGINASADMIN:
                        Admin admin = (Admin) adminJsonStringProcessing.stringDeserialisation(jsonStringObject);
                        List<Admin> adminList = adminService.findAllEntities();
                        for (Admin ad: adminList){
                            if(ad.getLogin().equals(admin.getLogin()) && ad.getPassword().equals(admin.getPassword())){
                                send(SUCCESS);
                            }
                            else{
                                send(FAIL);
                            }
                        }
                        break;
                    case LOGINASEMPLOYEE:
                        Employee employee = (Employee) employeeJsonStringProcessing.stringDeserialisation(jsonStringObject);
                        List<Employee> employeeList = employeeService.findAllEntities();
                        for (Employee empl: employeeList){
                            if(empl.getLogin().equals(employee.getLogin()) && empl.getPassword().equals(employee.getPassword())){
                                send(SUCCESS);
                            }
                            else{
                                send(FAIL);
                            }
                        }
                        break;
                    case ADDNEWEMPLOYEE:
                        Employee newemployee = (Employee) employeeJsonStringProcessing.stringDeserialisation(jsonStringObject);
                        employeeService.saveEntity(newemployee);
                        send(SUCCESS);
                        break;
                    case DELETEEMPLOYEE:
                        Employee deletedemployee = (Employee) employeeJsonStringProcessing.stringDeserialisation(jsonStringObject);
                        List<Employee> deletedList = employeeService.findAllEntities();
                        for (Employee empl: deletedList){
                            if((empl.getLogin().equals(deletedemployee.getLogin()) && empl.getPassword().equals(deletedemployee.getPassword()))==true){
                                employeeService.deleteEntity(empl);
                                send(SUCCESS);
                            }
                            else{
                                send(FAIL);
                            }
                        }
                        break;
                    case UPDATEEMPLOYEE:
                        Employee updatedemployee = (Employee) employeeJsonStringProcessing.stringDeserialisation(jsonStringObject);
                        List<Employee> updatedList = employeeService.findAllEntities();
                        for (Employee empl: updatedList){
                            if(empl.getLogin().equals(updatedemployee.getLogin())){
                                employeeService.deleteEntity(empl);
                                employeeService.saveEntity(updatedemployee);
                                send(SUCCESS);
                            }
                            else{
                                send(FAIL);
                            }
                        }
                        break;
                    case VIEWALLEMPLOYEES:
                        List<Employee> viewEmployeeList = employeeService.findAllEntities();
                        String jsonViewEmployeeList = employeeJsonStringProcessing.stringListSerialisation(viewEmployeeList);
                        send(jsonViewEmployeeList);
                        break;
                    case ADDFORMOFPAYMENT:
                        FormOfPayment newFormOfPayment = (FormOfPayment) formOfPaymentJsonStringProcessing.stringDeserialisation(jsonStringObject);
                        formOfPaymentService.saveEntity(newFormOfPayment);
                        send(SUCCESS);
                        break;
                    case DELETEFORMOFPAYMENT:
                        FormOfPayment deletedFormOfPayment = (FormOfPayment) formOfPaymentJsonStringProcessing.stringDeserialisation(jsonStringObject);
                        List<FormOfPayment> deletedFormOfPaymentList = formOfPaymentService.findAllEntities();
                        for (FormOfPayment formOfPayment: deletedFormOfPaymentList){
                            if(formOfPayment.getTitle().equals(deletedFormOfPayment.getTitle()) && formOfPayment.getDate_of_start().equals(deletedFormOfPayment.getDate_of_start())){
                                formOfPaymentService.deleteEntity(formOfPayment);
                                send(SUCCESS);
                            }
                            else{
                                send(FAIL);
                            }
                        }
                        break;
                    case UPDATEFORMOFPAYMENT:
                        FormOfPayment updatedFormOfPayment = (FormOfPayment) formOfPaymentJsonStringProcessing.stringDeserialisation(jsonStringObject);
                        List<FormOfPayment> updatedFormOfPaymentList = formOfPaymentService.findAllEntities();
                        for (FormOfPayment formOfPayment: updatedFormOfPaymentList){
                            if(formOfPayment.getTitle().equals(updatedFormOfPayment.getTitle())){
                                formOfPaymentService.deleteEntity(formOfPayment);
                                formOfPaymentService.saveEntity(updatedFormOfPayment);
                                send(SUCCESS);
                            }
                            else{
                                send(FAIL);
                            }
                        }
                        break;
                    case VIEWFORMSOFPAYMENTS:
                        List<FormOfPayment> viewFormOfPaymentList = formOfPaymentService.findAllEntities();
                        String jsonviewFormOfPaymentList = formOfPaymentJsonStringProcessing.stringListSerialisation(viewFormOfPaymentList);
                        send(jsonviewFormOfPaymentList);
                        break;
                    case MAKETHEFORMVALID:
                        FormOfPayment validFormOfPayment = (FormOfPayment) formOfPaymentJsonStringProcessing.stringDeserialisation(jsonStringObject);
                        List<FormOfPayment> validFormOfPaymentList = formOfPaymentService.findAllEntities();
                        for (FormOfPayment formOfPayment: validFormOfPaymentList){
                            if(formOfPayment.getTitle().equals(validFormOfPayment.getTitle()) && formOfPayment.getDate_of_start().equals(validFormOfPayment.getDate_of_start())){
                                VALIDFORMOFPAYMENT = formOfPayment;
                                send(SUCCESS);
                            }
                            else{
                                send(FAIL);
                            }
                        }
                        break;
                    case ADDMONTHRATESALARYOFEMPLOYEE:
                        DataForRollingSalaryOfEmployee newDataForRollingSalaryOfEmployee = (DataForRollingSalaryOfEmployee)dataForRollingSalaryOfEmployeeJsonStringProcessing.stringDeserialisation(jsonStringObject);
                        SalaryOfEmployee newSalaryOfEmployee = (SalaryOfEmployee) salaryOfEmployeePayRollImpl.payroll_by_month_rate(VALIDFORMOFPAYMENT,newDataForRollingSalaryOfEmployee);
                        salaryOfEmployeeService.saveEntity(newSalaryOfEmployee);
                        send(String.valueOf(newSalaryOfEmployee.getSumma()));
                        break;
                    case ADDDAILYRATESALARYOFEMPLOYEE:
                        DataForRollingSalaryOfEmployee new_DataForRollingSalaryOfEmployee = (DataForRollingSalaryOfEmployee)dataForRollingSalaryOfEmployeeJsonStringProcessing.stringDeserialisation(jsonStringObject);
                        SalaryOfEmployee new_SalaryOfEmployee = (SalaryOfEmployee) salaryOfEmployeePayRollImpl.payroll_by_month_rate(VALIDFORMOFPAYMENT,new_DataForRollingSalaryOfEmployee);
                        salaryOfEmployeeService.saveEntity(new_SalaryOfEmployee);
                        send(String.valueOf(new_SalaryOfEmployee.getSumma()));
                        break;
                    case ADDHOURLYRATESALARYOFEMPLOYEE:
                        DataForRollingSalaryOfEmployee new__DataForRollingSalaryOfEmployee = (DataForRollingSalaryOfEmployee)dataForRollingSalaryOfEmployeeJsonStringProcessing.stringDeserialisation(jsonStringObject);
                        SalaryOfEmployee new__SalaryOfEmployee = (SalaryOfEmployee) salaryOfEmployeePayRollImpl.payroll_by_month_rate(VALIDFORMOFPAYMENT,new__DataForRollingSalaryOfEmployee);
                        salaryOfEmployeeService.saveEntity(new__SalaryOfEmployee);
                        send(String.valueOf(new__SalaryOfEmployee.getSumma()));
                        break;
                    case CHECKTHEVALIDFORMOFPAYMENT:
                        String titleOfValidFormOfPayment = VALIDFORMOFPAYMENT.getTitle();
                        send(titleOfValidFormOfPayment);
                        break;
                    case VIEWSALARYSOFEMPLOYEE:
                        String login_of_employee = jsonStringObject;
                        id_of_formOfPayment = VALIDFORMOFPAYMENT.getId();
                        List<Employee> employees = employeeService.findAllEntities();
                        for (Employee empl: employees){
                            if(empl.getLogin().equals(login_of_employee)){
                                id_of_employee = empl.getId();
                            }
                        }
                        List<SalaryOfEmployee> salaryOfEmployeeList = salaryOfEmployeeService.findAllEntities();
                        salaryOfEmployeeList_ =  new ArrayList<SalaryOfEmployee>();
                        for (SalaryOfEmployee soe: salaryOfEmployeeList){
                            if(soe.getEmployee().getId()==id_of_employee && soe.getFormOfPayment().getId() == id_of_formOfPayment ){
                                salaryOfEmployeeList_.add(soe);
                            }
                        }
                        String jsonSalaryOfEmployeeList = salaryOfEmployeeJsonStringProcessing.stringListSerialisation(salaryOfEmployeeList_);
                        send(jsonSalaryOfEmployeeList);
                        break;

                }

            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        System.out.println("Новая нить закончила свою работу,сокет общения закрыт, присоединитесь снова");
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void send(String serverAnswer) {
        try {
            out.write(serverAnswer + "\n");
            out.flush();
        } catch (IOException ignored) {

        }
    }


}
