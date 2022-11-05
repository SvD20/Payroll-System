package edu.bsuir.controllers;

import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import edu.bsuir.client.Client;
import edu.bsuir.entities.Employee;
import edu.bsuir.entities.EmployeeProperty;
import edu.bsuir.jsonprocessing.EmployeeJsonStringProcessingImpl;
import edu.bsuir.jsonprocessing.JsonStringProcessing;
import edu.bsuir.model.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;


public class WorkWithEmployeesController {

    private static final String ADDNEWEMPLOYEE = "ADDNEWEMPLOYEE";
    private static final String DELETEEMPLOYEE = "DELETEEMPLOYEE";
    private static final String UPDATEEMPLOYEE = "UPDATEEMPLOYEE";
    private static final String VIEWALLEMPLOYEES = "VIEWALLEMPLOYEES";

    Client client = Client.getInstance();
    JsonStringProcessing employeeJsonStringProcessing = new EmployeeJsonStringProcessingImpl();

    @FXML
    private Button add_new_employee;

    @FXML
    private Button delete_employee;

    @FXML
    private Button go_to_work_with_forms_of_payments;

    @FXML
    private TextField login_field;

    @FXML
    private TextField newpassword_field;

    @FXML
    private TextField password_field;

    @FXML
    private Button update_employee;

    @FXML
    private Button view_employees;

    @FXML
    private TextArea status_area;

    @FXML
    private Button back;

    @FXML
    private TableView<EmployeeProperty> table_for_employees;

    @FXML
    private TableColumn<EmployeeProperty, String> column_login;

    @FXML
    private TableColumn<EmployeeProperty, String> column_password;

    private final ObservableList<EmployeeProperty> table_for_employeesProperties = FXCollections.observableArrayList();


    public WorkWithEmployeesController() throws IOException {
    }

    public void initialize(){

        add_new_employee.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                String login = login_field.getText();
                String password = password_field.getText();
                Employee employee = new Employee(login,password);
                String jsonEmployee = employeeJsonStringProcessing.stringSerialisation(employee);
                String typeOfOperation = ADDNEWEMPLOYEE;
                String serverAnswer = client.dataSendAndTake(typeOfOperation, jsonEmployee);
                status_area.setText(serverAnswer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        delete_employee.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                String login = login_field.getText();
                String password = password_field.getText();
                Employee employee = new Employee(login,password);
                String jsonEmployee = employeeJsonStringProcessing.stringSerialisation(employee);
                String typeOfOperation = DELETEEMPLOYEE;
                String serverAnswer = client.dataSendAndTake(typeOfOperation, jsonEmployee);
                status_area.setText(serverAnswer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        update_employee.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                String login = login_field.getText();
                String newpassword = newpassword_field.getText();
                Employee updatedemployee = new Employee(login,newpassword);
                String jsonupdatedEmployee = employeeJsonStringProcessing.stringSerialisation(updatedemployee);
                String typeOfOperation = UPDATEEMPLOYEE;
                String serverAnswer = client.dataSendAndTake(typeOfOperation, jsonupdatedEmployee);
                status_area.setText(serverAnswer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        view_employees.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                String typeOfOperation = VIEWALLEMPLOYEES;
                String jsonStringList = client.dataSendAndTake(typeOfOperation, null);
                ObjectMapper mapper = new ObjectMapper();
                TypeFactory factory = mapper.getTypeFactory();
                CollectionType listType =
                        factory.constructCollectionType(List.class, Employee.class);
                List <Employee> allemployees = mapper.readValue(jsonStringList, listType);
                table_for_employees.setItems(table_for_employeesProperties);
                column_login.setCellValueFactory(cellValue -> cellValue.getValue().loginProperty());
                column_password.setCellValueFactory(cellValue -> cellValue.getValue().passwordProperty());
                table_for_employeesProperties.clear();
                for (int i = 0; i < allemployees.size(); i++) {
                    EmployeeProperty e = new EmployeeProperty(allemployees.get(i));
                    table_for_employeesProperties.add(e);
                }
                table_for_employees.setItems(table_for_employeesProperties);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        go_to_work_with_forms_of_payments.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            App.initRootLayout("/workwithformsofpayments.fxml");
        });

        back.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            App.initRootLayout("/authorization.fxml");
        });

    }

}

