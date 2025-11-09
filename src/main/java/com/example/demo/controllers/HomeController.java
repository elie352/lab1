package com.example.demo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Button personsMngBtn;

    @FXML
    private Button carsMngBtn;

    @FXML
    private Button productsMngBtn;

    @FXML
    private Button phonesMngBtn;

    // PC PARTS
    @FXML
    void openPersonsMng(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                    .getResource("/com/example/demo/views/persons-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 900, 600);
            Stage stage = new Stage();
            stage.setTitle("PC PARTS");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            showError("PC Parts Error", e.getMessage());
            e.printStackTrace();
        }
    }

    // CAR MANAGEMENT
    @FXML
    void openCarsManagement(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                    .getResource("/com/example/demo/views/cars-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 900, 600);
            Stage stage = new Stage();
            stage.setTitle("Car Management");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            showError("Car Management Error", e.getMessage());
            e.printStackTrace();
        }
    }

    // FRUIT & VEGETABLE MANAGEMENT
    @FXML
    void openProductsManagement(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                    .getResource("/com/example/demo/views/products-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 900, 600);
            Stage stage = new Stage();
            stage.setTitle("Fruit & Vegetable Management");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            showError("Products Management Error", e.getMessage());
            e.printStackTrace();
        }
    }

    // PHONE MANAGEMENT
    @FXML
    void openPhonesManagement(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                    .getResource("/com/example/demo/views/phones-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 900, 600);
            Stage stage = new Stage();
            stage.setTitle("Phone Management");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            showError("Phone Management Error", e.getMessage());
            e.printStackTrace();
        }
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}