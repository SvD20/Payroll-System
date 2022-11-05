package edu.bsuir.controllers;

import edu.bsuir.client.Client;
import edu.bsuir.entities.Admin;
import edu.bsuir.entities.Employee;
import edu.bsuir.jsonprocessing.AdminJsonStringProcessingImpl;
import edu.bsuir.jsonprocessing.EmployeeJsonStringProcessingImpl;
import edu.bsuir.jsonprocessing.JsonStringProcessing;
import edu.bsuir.model.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class AuthorizationController {

    private static String LOGINASADMIN = "LOGINASADMIN";
    private static String LOGINASEMPLOYEE = "LOGINASEMPLOYEE";

    Client client = Client.getInstance();
    JsonStringProcessing adminJsonStringProcessing = new AdminJsonStringProcessingImpl();
    JsonStringProcessing employeeJsonStringProcessing = new EmployeeJsonStringProcessingImpl();

    @FXML
    private Button login_as_admin;

    @FXML
    private Button login_as_employee;

    @FXML
    private TextField login_field;

    @FXML
    private TextField password_field;

    @FXML
    private TextArea result_of_authorization;

    public AuthorizationController() throws IOException {
    }

    public void initialize(){

        login_as_admin.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                String login = login_field.getText();
                String password = password_field.getText();
                Admin admin = new Admin(login,password);
                String jsonAdmin = adminJsonStringProcessing.stringSerialisation(admin);
                String typeOfOperation = LOGINASADMIN;
                String serverAnswer = client.dataSendAndTake(typeOfOperation, jsonAdmin);
                if (serverAnswer.equals("Success")) {
                    App.initRootLayout("/workwithemployees.fxml");
                } else {
                    result_of_authorization.setText(serverAnswer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        login_as_employee.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                String login = login_field.getText();
                String password = password_field.getText();
                Employee employee = new Employee(login,password);
                String jsonEmployee = employeeJsonStringProcessing.stringSerialisation(employee);
                String typeOfOperation = LOGINASEMPLOYEE;
                String serverAnswer = client.dataSendAndTake(typeOfOperation, jsonEmployee);
                if (serverAnswer.equals("Success")) {
                    App.initRootLayout("/workwithmysalary.fxml");
                } else {
                    result_of_authorization.setText(serverAnswer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


    }

}

