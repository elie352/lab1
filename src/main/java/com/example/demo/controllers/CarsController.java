package com.example.demo.controllers;

import com.example.demo.models.Car;
import com.example.demo.models.CarsStore;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class CarsController {
    @FXML
    private TableView<Car> carsTable;
    @FXML
    private TableColumn<Car, String> brandCol;
    @FXML
    private TableColumn<Car, String> modelCol;
    @FXML
    private TableColumn<Car, Double> priceCol;
    @FXML
    private TableColumn<Car, Integer> mileageCol;
    @FXML
    private TableColumn<Car, Double> engineSizeCol;
    @FXML
    private TableColumn<Car, String> colorCol;
    @FXML
    private TableColumn<Car, Integer> yearCol;

    @FXML
    private TextField brandFld;
    @FXML
    private TextField modelFld;
    @FXML
    private TextField priceFld;
    @FXML
    private TextField mileageFld;
    @FXML
    private TextField engineSizeFld;
    @FXML
    private TextField colorFld;
    @FXML
    private TextField yearFld;

    @FXML
    private Button addBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private Text errorMsg;

    private final CarsStore carStore = new CarsStore();

    @FXML
    public void initialize() {
        setupTableColumns();
        loadCarsData();
        setupSelectionListener();
    }

    private void setupTableColumns() {
        brandCol.setCellValueFactory(cellData -> cellData.getValue().brandProperty());
        modelCol.setCellValueFactory(cellData -> cellData.getValue().modelProperty());
        priceCol.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        mileageCol.setCellValueFactory(cellData -> cellData.getValue().mileageProperty().asObject());
        engineSizeCol.setCellValueFactory(cellData -> cellData.getValue().engineSizeProperty().asObject());
        colorCol.setCellValueFactory(cellData -> cellData.getValue().colorProperty());
        yearCol.setCellValueFactory(cellData -> cellData.getValue().yearProperty().asObject());
    }

    private void loadCarsData() {
        ObservableList<Car> cars = carStore.getCarsList();
        carsTable.setItems(cars);
    }

    private void setupSelectionListener() {
        carsTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                populateFields(newValue);
            }
        });
    }

    private void populateFields(Car car) {
        brandFld.setText(car.getBrand());
        modelFld.setText(car.getModel());
        priceFld.setText(String.valueOf(car.getPrice()));
        mileageFld.setText(String.valueOf(car.getMileage()));
        engineSizeFld.setText(String.valueOf(car.getEngineSize()));
        colorFld.setText(car.getColor());
        yearFld.setText(String.valueOf(car.getYear()));
    }

    @FXML
    void addCar(ActionEvent event) {
        List<String> errors = validateCarData();

        if (errors.isEmpty()) {
            Car newCar = createCarFromFields();
            carStore.addCar(newCar);
            clearFields();
            showSuccess("Car added successfully!");
        } else {
            showErrors(errors);
        }
    }

    @FXML
    void updateCar(ActionEvent event) {
        Car selectedCar = carsTable.getSelectionModel().getSelectedItem();

        if (selectedCar == null) {
            showError("Please select a car to update");
            return;
        }

        List<String> errors = validateCarData();

        if (errors.isEmpty()) {
            updateCarFromFields(selectedCar);
            carsTable.refresh();
            showSuccess("Car updated successfully!");
        } else {
            showErrors(errors);
        }
    }

    @FXML
    void deleteCar(ActionEvent event) {
        Car selectedCar = carsTable.getSelectionModel().getSelectedItem();

        if (selectedCar == null) {
            showError("Please select a car to delete");
            return;
        }

        carStore.deleteCar(selectedCar);
        clearFields();
        showSuccess("Car deleted successfully!");
    }

    private List<String> validateCarData() {
        List<String> errors = new ArrayList<>();

        if (brandFld.getText().trim().isEmpty()) {
            errors.add("Brand is required");
        }
        if (modelFld.getText().trim().isEmpty()) {
            errors.add("Model is required");
        }
        if (colorFld.getText().trim().isEmpty()) {
            errors.add("Color is required");
        }

        if (!isValidDouble(priceFld.getText())) {
            errors.add("Invalid price");
        }
        if (!isValidInteger(mileageFld.getText())) {
            errors.add("Invalid mileage");
        }
        if (!isValidDouble(engineSizeFld.getText())) {
            errors.add("Invalid engine size");
        }
        if (!isValidInteger(yearFld.getText())) {
            errors.add("Invalid year");
        }

        return errors;
    }

    private boolean isValidDouble(String text) {
        try {
            double value = Double.parseDouble(text.trim());
            return value >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidInteger(String text) {
        try {
            int value = Integer.parseInt(text.trim());
            return value >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private Car createCarFromFields() {
        return new Car(
                brandFld.getText().trim(),
                modelFld.getText().trim(),
                Double.parseDouble(priceFld.getText().trim()),
                Integer.parseInt(mileageFld.getText().trim()),
                Double.parseDouble(engineSizeFld.getText().trim()),
                colorFld.getText().trim(),
                Integer.parseInt(yearFld.getText().trim())
        );
    }

    private void updateCarFromFields(Car car) {
        carStore.updateCar(
                car,
                brandFld.getText().trim(),
                modelFld.getText().trim(),
                Double.parseDouble(priceFld.getText().trim()),
                Integer.parseInt(mileageFld.getText().trim()),
                Double.parseDouble(engineSizeFld.getText().trim()),
                colorFld.getText().trim(),
                Integer.parseInt(yearFld.getText().trim())
        );
    }

    private void clearFields() {
        brandFld.clear();
        modelFld.clear();
        priceFld.clear();
        mileageFld.clear();
        engineSizeFld.clear();
        colorFld.clear();
        yearFld.clear();
        carsTable.getSelectionModel().clearSelection();
    }

    private void showSuccess(String message) {
        errorMsg.setText(message);
        errorMsg.setStyle("-fx-fill: green;");
    }

    private void showError(String message) {
        errorMsg.setText(message);
        errorMsg.setStyle("-fx-fill: red;");
    }

    private void showErrors(List<String> errors) {
        errorMsg.setText(String.join("\n", errors));
        errorMsg.setStyle("-fx-fill: red;");
    }
}