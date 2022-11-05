package edu.bsuir.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import edu.bsuir.client.Client;
import edu.bsuir.entities.*;
import edu.bsuir.jsonprocessing.DataForRollingSalaryOfEmployeeJsonStringImpl;
import edu.bsuir.jsonprocessing.JsonStringProcessing;
import edu.bsuir.model.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.List;

public class WorkWithSalarysOfEmployeesController {

    private static final String ADDMONTHRATESALARYOFEMPLOYEE = "ADDMONTHRATESALARYOFEMPLOYEE";
    private static final String ADDDAILYRATESALARYOFEMPLOYEE = "ADDDAILYRATESALARYOFEMPLOYEE";
    private static final String ADDHOURLYRATESALARYOFEMPLOYEE = "ADDHOURLYRATESALARYOFEMPLOYEE";
    private static final String CHECKTHEVALIDFORMOFPAYMENT = "CHECKTHEVALIDFORMOFPAYMENT";
    private static final String VIEWSALARYSOFEMPLOYEE = "VIEWSALARYSOFEMPLOYEE";

    Client client = Client.getInstance();

    JsonStringProcessing dataForRollingSalaryOfEmployeeJsonStringImpl = new DataForRollingSalaryOfEmployeeJsonStringImpl();

    @FXML
    private Button calculate_monthratesalary;

    @FXML
    private Button calculate_dailyratesalary;

    @FXML
    private Button calculate_hourlyratesalary;

    @FXML
    private Button back;

    @FXML
    private TextField field_for_date;

    @FXML
    private TextField field_for_days_or_hours_actually_worked;

    @FXML
    private TextField field_for_login_of_employee;

    @FXML
    private TextField field_for_working_days_per_month;

    @FXML
    private TextArea summa_area;

    @FXML
    private TextArea title_area;

    @FXML
    private Button view_title_valid_form_of_payment;

    @FXML
    private Button view_salarys_of_employee;

    @FXML
    private TableView<SalaryOfEmployeeProperty> table_for_SalarysOfEmployee;

    @FXML
    private TableColumn<SalaryOfEmployeeProperty, String> column_date;

    @FXML
    private TableColumn<SalaryOfEmployeeProperty, String> column_summa;

    private final ObservableList<SalaryOfEmployeeProperty> table_for_SalarysOfEmployeeProperties = FXCollections.observableArrayList();

    public WorkWithSalarysOfEmployeesController() throws IOException {
    }

    public void initialize(){

        calculate_monthratesalary.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                int days_or_hours_actually_worked = Integer.parseInt(field_for_days_or_hours_actually_worked.getText());
                int working_days_per_month = Integer.parseInt(field_for_working_days_per_month.getText());
                String date = field_for_date.getText();
                String login_of_employee = field_for_login_of_employee.getText();
                DataForRollingSalaryOfEmployee dataForRollingSalaryOfEmployee = new DataForRollingSalaryOfEmployee(working_days_per_month,
                        days_or_hours_actually_worked,0,login_of_employee,date);
                String  jsonDataForRollingSalaryOfEmployee = dataForRollingSalaryOfEmployeeJsonStringImpl.stringSerialisation(dataForRollingSalaryOfEmployee);
                String typeOfOperation = ADDMONTHRATESALARYOFEMPLOYEE;
                String serverAnswer = client.dataSendAndTake(typeOfOperation, jsonDataForRollingSalaryOfEmployee);
                summa_area.setText(serverAnswer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        calculate_dailyratesalary.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                int days_or_hours_actually_worked = Integer.parseInt(field_for_days_or_hours_actually_worked.getText());
                String date = field_for_date.getText();
                String login_of_employee = field_for_login_of_employee.getText();
                DataForRollingSalaryOfEmployee dataForRollingSalaryOfEmployee = new DataForRollingSalaryOfEmployee(0,
                        days_or_hours_actually_worked,0,login_of_employee,date);
                String  jsonDataForRollingSalaryOfEmployee = dataForRollingSalaryOfEmployeeJsonStringImpl.stringSerialisation(dataForRollingSalaryOfEmployee);
                String typeOfOperation = ADDDAILYRATESALARYOFEMPLOYEE;
                String serverAnswer = client.dataSendAndTake(typeOfOperation, jsonDataForRollingSalaryOfEmployee);
                summa_area.setText(serverAnswer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        calculate_hourlyratesalary.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                int days_or_hours_actually_worked = Integer.parseInt(field_for_days_or_hours_actually_worked.getText());
                String date = field_for_date.getText();
                String login_of_employee = field_for_login_of_employee.getText();
                DataForRollingSalaryOfEmployee dataForRollingSalaryOfEmployee = new DataForRollingSalaryOfEmployee(0,
                        days_or_hours_actually_worked,0,login_of_employee,date);
                String  jsonDataForRollingSalaryOfEmployee = dataForRollingSalaryOfEmployeeJsonStringImpl.stringSerialisation(dataForRollingSalaryOfEmployee);
                String typeOfOperation = ADDHOURLYRATESALARYOFEMPLOYEE;
                String serverAnswer = client.dataSendAndTake(typeOfOperation, jsonDataForRollingSalaryOfEmployee);
                summa_area.setText(serverAnswer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        view_title_valid_form_of_payment.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                String typeOfOperation = CHECKTHEVALIDFORMOFPAYMENT;
                String titleOfValidFormOfPayment  = client.dataSendAndTake(typeOfOperation, null);
                title_area.setText(titleOfValidFormOfPayment);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        view_salarys_of_employee.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                String typeOfOperation = VIEWSALARYSOFEMPLOYEE;
                String login_of_employee = field_for_login_of_employee.getText();
                String jsonStringList = client.dataSendAndTake(typeOfOperation, login_of_employee);
                ObjectMapper mapper = new ObjectMapper();
                TypeFactory factory = mapper.getTypeFactory();
                CollectionType listType =
                        factory.constructCollectionType(List.class, SalaryOfEmployee.class);
                List <SalaryOfEmployee> salaryOfEmployeeList = mapper.readValue(jsonStringList, listType);
                table_for_SalarysOfEmployee.setItems(table_for_SalarysOfEmployeeProperties);
                column_summa.setCellValueFactory(cellValue -> cellValue.getValue().summaProperty());
                column_date.setCellValueFactory(cellValue -> cellValue.getValue().dateProperty());
                table_for_SalarysOfEmployeeProperties.clear();
                for (int i = 0; i < salaryOfEmployeeList.size(); i++) {
                    SalaryOfEmployeeProperty soe = new SalaryOfEmployeeProperty(salaryOfEmployeeList.get(i));
                    table_for_SalarysOfEmployeeProperties.add(soe);
                }
                table_for_SalarysOfEmployee.setItems(table_for_SalarysOfEmployeeProperties);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        back.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            App.initRootLayout("/workwithformsofpayments.fxml");
        });


    }

}
