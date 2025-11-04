package com.example.demo.controllers;

import com.example.demo.models.Person;
import com.example.demo.models.PersonsStore;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class PersonsController {

    @FXML
    private Button addBtn;

    @FXML
    private TableColumn<Person, SimpleStringProperty> addressCol;

    @FXML
    private TextField addressFld;

    @FXML
    private TableColumn<Person, SimpleIntegerProperty> ageCol;

    @FXML
    private TextField ageFld;

    @FXML
    private Button deleteBtn;

    @FXML
    private TableColumn<Person, SimpleStringProperty> nameCol;

    @FXML
    private TextField nameFld;

    @FXML
    private TableView<Person> personsTable;

    @FXML
    private Button updateBtn;

    @FXML
    private Text errorMsg;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ChoiceBox<String> typeChoiceBox;

    @FXML
    private TableColumn<Person, SimpleStringProperty> storeDateCol;

    @FXML
    private TableColumn<Person, SimpleStringProperty> termCol;

    private final PersonsStore personStore = new PersonsStore();

    @FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        storeDateCol.setCellValueFactory(new PropertyValueFactory<>("storeDate"));
        termCol.setCellValueFactory(new PropertyValueFactory<>("termOfUse"));

        typeChoiceBox.getItems().addAll("Used", "New");

        ObservableList<Person> persons = personStore.getPersonsList();
        personsTable.setItems(persons);

        personsTable.getSelectionModel().selectedItemProperty().addListener(evt -> {
            Person selectedPerson = personsTable.getSelectionModel().getSelectedItem();
            if(selectedPerson != null) {
                nameFld.setText(selectedPerson.getName());
                ageFld.setText(Integer.toString(selectedPerson.getAge()));
                addressFld.setText(selectedPerson.getAddress());
                if (selectedPerson.getStoreDate() != null && !selectedPerson.getStoreDate().isEmpty())
                    datePicker.setValue(java.time.LocalDate.parse(selectedPerson.getStoreDate()));
                else
                    datePicker.setValue(null);
                typeChoiceBox.setValue(selectedPerson.getTermOfUse());
            }
        });
    }

    @FXML
    void addPerson(ActionEvent event) {
        String error = "";
        boolean isValid = true;

        String name = nameFld.getText();
        if(name.isEmpty()) {
            error += "Error: Part Name is required\n";
            isValid = false;
        }

        Integer age = null;
        if(ageFld.getText().isEmpty()) {
            error += "Error: Price is required\n";
            isValid = false;
        }
        else try {
            age = Integer.parseInt(ageFld.getText());
        }catch(NumberFormatException ex){
            error += "Error: Invalid Price value\n";
            isValid = false;
        }

        String address = addressFld.getText();
        if(address.isEmpty()) {
            error += "Error: Quantity is required\n";
            isValid = false;
        }

        String storeDate = (datePicker.getValue() != null) ? datePicker.getValue().toString() : "";
        String termOfUse = (typeChoiceBox.getValue() != null) ? typeChoiceBox.getValue() : "";

        if(isValid) {
            personStore.addPerson(new Person(name, age, address, storeDate, termOfUse));

            nameFld.clear();
            ageFld.clear();
            addressFld.clear();
            datePicker.setValue(null);
            typeChoiceBox.setValue(null);
            errorMsg.setText("");
        }
        else
            errorMsg.setText(error);
    }

    @FXML
    void deletePerson(ActionEvent event) {
        Person selectedPerson = personsTable.getSelectionModel().getSelectedItem();

        if(selectedPerson != null) {
            personStore.deletePerson(selectedPerson);
        }
    }

    @FXML
    void updatePerson(ActionEvent event) {
        Person selectedPerson = personsTable.getSelectionModel().getSelectedItem();

        if(selectedPerson != null)
        {
            String error = "";
            boolean isValid = true;

            String name = nameFld.getText();
            if(name.isEmpty()) {
                error += "Error: Part Name is required!\n";
                isValid = false;
            }

            Integer age = null;
            if(ageFld.getText().isEmpty()){
                error += "Error: Price is required!\n";
                isValid = false;
            }
            else try {
                age = Integer.parseInt(ageFld.getText());
            }catch(NumberFormatException ex){
                error += "Error: Invalid Price value!\n";
                isValid = false;
            }

            String address = addressFld.getText();
            if(address.isEmpty()){
                error += "Error: Quantity is required!";
                isValid = false;
            }

            String storeDate = (datePicker.getValue() != null) ? datePicker.getValue().toString() : "";
            String termOfUse = (typeChoiceBox.getValue() != null) ? typeChoiceBox.getValue() : "";

            if(isValid) {
                personStore.updatePerson(selectedPerson, name, age, address, storeDate, termOfUse);
                errorMsg.setText("");
            }
            else
                errorMsg.setText(error);
        }
    }
}
