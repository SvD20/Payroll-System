package edu.bsuir.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import edu.bsuir.client.Client;
import edu.bsuir.entities.FormOfPayment;
import edu.bsuir.entities.FormOfPaymentProperty;
import edu.bsuir.jsonprocessing.FormOfPaymentJsonStringProcessingImpl;
import edu.bsuir.jsonprocessing.JsonStringProcessing;
import edu.bsuir.model.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.List;

public class WorkWithFormsOfPaymentsController {

    private static final String ADDFORMOFPAYMENT = "ADDFORMOFPAYMENT";
    private static final String DELETEFORMOFPAYMENT = "DELETEFORMOFPAYMENT";
    private static final String UPDATEFORMOFPAYMENT = "UPDATEFORMOFPAYMENT";
    private static final String VIEWFORMSOFPAYMENTS = "VIEWFORMSOFPAYMENTS";
    private static final String MAKETHEFORMVALID = "MAKETHEFORMVALID";

    private static final String HELPTEXT = "Maketheformvalid: title + dateofstart\n" +
            "Add: title + dateofstart + rate\n" +
            "Update: title + newrate+newdayofstart\n" +
            "Delete: title+dateofstart";

    Client client = Client.getInstance();

    JsonStringProcessing formOfPaymentJsonStringProcessing = new FormOfPaymentJsonStringProcessingImpl();

    @FXML
    private Button add_form_of_payment;

    @FXML
    private TextField date_of_start_field;

    @FXML
    private Button delete_form_of_payment;

    @FXML
    private Button go_to_work_with_salarys;

    @FXML
    private Button make_the_form_valid;

    @FXML
    private TextField new_date_of_start_field;

    @FXML
    private TextField newrate_field;

    @FXML
    private TextField rate_field;

    @FXML
    private TableView<FormOfPaymentProperty> table_for_forms_of_payments;

    @FXML
    private TableColumn<FormOfPaymentProperty, String> column_title;

    @FXML
    private TableColumn<FormOfPaymentProperty, String> column_dateofstart;

    @FXML
    private TableColumn<FormOfPaymentProperty, Double> column_rate;

    private final ObservableList<FormOfPaymentProperty> formOfPaymentProperties = FXCollections.observableArrayList();

    @FXML
    private TextField title_field;

    @FXML
    private Button update_form_of_payment;

    @FXML
    private Button view_forms_of_payments;

    @FXML
    private Button back;

    @FXML
    private TextArea status;

    @FXML
    private Button help;

    @FXML
    private TextArea help_area;

    public WorkWithFormsOfPaymentsController() throws IOException {
    }

    public void initialize(){

        add_form_of_payment.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                String title = title_field.getText();
                String date_of_start = date_of_start_field.getText();
                double rate = Double.parseDouble(rate_field.getText());
                FormOfPayment formOfPayment = new FormOfPayment(title,rate,date_of_start);
                String jsonFormOfPayment = formOfPaymentJsonStringProcessing.stringSerialisation(formOfPayment);
                String typeOfOperation = ADDFORMOFPAYMENT;
                String serverAnswer = client.dataSendAndTake(typeOfOperation,jsonFormOfPayment);
                status.setText(serverAnswer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        delete_form_of_payment.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                String title = title_field.getText();
                String date_of_start = date_of_start_field.getText();
                FormOfPayment formOfPayment = new FormOfPayment(title,null,date_of_start);
                String jsonFormOfPayment = formOfPaymentJsonStringProcessing.stringSerialisation(formOfPayment);
                String typeOfOperation = DELETEFORMOFPAYMENT;
                String serverAnswer = client.dataSendAndTake(typeOfOperation,jsonFormOfPayment );
                status.setText(serverAnswer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        update_form_of_payment.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                String title = title_field.getText();
                String new_date_of_start = new_date_of_start_field.getText();
                double new_rate = Double.parseDouble(newrate_field.getText());
                FormOfPayment formOfPayment = new FormOfPayment(title,new_rate,new_date_of_start);
                String jsonFormOfPayment = formOfPaymentJsonStringProcessing.stringSerialisation(formOfPayment);
                String typeOfOperation = UPDATEFORMOFPAYMENT;
                String serverAnswer = client.dataSendAndTake(typeOfOperation, jsonFormOfPayment);
                status.setText(serverAnswer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        view_forms_of_payments.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                String typeOfOperation = VIEWFORMSOFPAYMENTS;
                String jsonStringList = client.dataSendAndTake(typeOfOperation, null);
                ObjectMapper mapper = new ObjectMapper();
                TypeFactory factory = mapper.getTypeFactory();
                CollectionType listType =
                        factory.constructCollectionType(List.class, FormOfPayment.class);
                List <FormOfPayment> formsOfPayments = mapper.readValue(jsonStringList, listType);
                table_for_forms_of_payments.setItems(formOfPaymentProperties);
                column_title.setCellValueFactory(cellValue -> cellValue.getValue().titleProperty());
                column_rate.setCellValueFactory(cellValue -> cellValue.getValue().rateProperty().asObject());
                column_dateofstart.setCellValueFactory(cellValue -> cellValue.getValue().date_of_startProperty());
                formOfPaymentProperties.clear();
                for (int i = 0; i < formsOfPayments.size(); i++) {
                    FormOfPaymentProperty f = new FormOfPaymentProperty(formsOfPayments.get(i));
                    formOfPaymentProperties.add(f);
                }
                table_for_forms_of_payments.setItems(formOfPaymentProperties);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        make_the_form_valid.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                String title = title_field.getText();
                String date_of_start = date_of_start_field.getText();
                FormOfPayment formOfPayment = new FormOfPayment(title,null,date_of_start);
                String jsonFormOfPayment = formOfPaymentJsonStringProcessing.stringSerialisation(formOfPayment);
                String typeOfOperation = MAKETHEFORMVALID;
                String serverAnswer = client.dataSendAndTake(typeOfOperation,jsonFormOfPayment);
                status.setText(serverAnswer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        go_to_work_with_salarys.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            App.initRootLayout("/workwithsalarysofemployees.fxml");
        });

        back.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            App.initRootLayout("/workwithemployees.fxml");
        });

        help.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            help_area.setText(HELPTEXT);
        });

    }

}





