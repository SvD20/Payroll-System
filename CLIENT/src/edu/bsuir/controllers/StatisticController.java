package edu.bsuir.controllers;

import edu.bsuir.model.App;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class StatisticController {

    private static String PATHTOFOLDER = "C:/Printouts/your_printout";
    private static String READY = "READY";
    private static String INFOABOUTCOMPANY = "cool title, fair salaries";

    @FXML
    private Button back;

    @FXML
    private Button get_a_printout;

    @FXML
    private Button get_a_salary_diagram;

    @FXML
    private Button get_info_about_company;

    @FXML
    private TextArea info_about_company_area;

    @FXML
    private TextArea path_to_catalog_area;

    @FXML
    private TextArea status_area;

    @FXML
    private TextField field_for_login;

    @FXML
    private LineChart <String,Number> salary_diagram;

    public void initialize(){


        get_a_salary_diagram.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            salary_diagram.getData().clear();
            XYChart.Series<String,Number> series = new XYChart.Series<String, Number>();
            series.getData().add(new XYChart.Data<String, Number>("Sep", 500));
            series.getData().add(new XYChart.Data<String, Number>("Okt", 700));
            series.getData().add(new XYChart.Data<String, Number>("Nov", 600));
            series.getData().add(new XYChart.Data<String, Number>("Dec", 900));
            series.setName("My salary");
            salary_diagram.getData().add(series);
        });



        get_a_printout.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
          path_to_catalog_area.setText(PATHTOFOLDER);
          status_area.setText(READY);
        });

        get_info_about_company.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
          info_about_company_area.setText(INFOABOUTCOMPANY);
        });


        back.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            App.initRootLayout("/workwithmysalary.fxml");
        });
    }



}
