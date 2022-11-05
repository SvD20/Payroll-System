package edu.bsuir.controllers;

import edu.bsuir.model.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class WorkWithMySalaryController {

    @FXML
    private Button back;

    @FXML
    private Button calculate_salary;

    @FXML
    private TableColumn<?, ?> column_mysalarydate;

    @FXML
    private TableColumn<?, ?> column_mysalarysumma;

    @FXML
    private TableColumn<?, ?> column_salaryofemployeedate;

    @FXML
    private TableColumn<?, ?> column_salaryofemployeesumma;

    @FXML
    private TextField field_for_date;

    @FXML
    private TextField field_for_days_or_hours_actually_worked;

    @FXML
    private TextField field_for_login;

    @FXML
    private TextField field_for_working_days_per_month;

    @FXML
    private Button go_to_work_with_statistic;

    @FXML
    private TextArea info_area;

    @FXML
    private TextArea summa_area;

    @FXML
    private TableView<?> table_for_MySalary;

    @FXML
    private TableView<?> table_for_SalarysOfEmployee;

    @FXML
    private Button take_info;

    @FXML
    private Button view_admins_payrolls;

    @FXML
    private Button view_my_payrolls;

    public void initialize(){

        go_to_work_with_statistic.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            App.initRootLayout("/workwithstatistic.fxml");
        });

        back.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            App.initRootLayout("/authorization.fxml");
        });
    }

}
