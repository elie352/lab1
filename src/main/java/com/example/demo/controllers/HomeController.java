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

    // PC PARTS - Shows login first
    @FXML
    void openPersonsMng(ActionEvent event) {
        showLoginForModule("pcparts", "PC Parts");
    }

    // CAR MANAGEMENT - Shows login first
    @FXML
    void openCarsManagement(ActionEvent event) {
        showLoginForModule("cars", "Car Management");
    }

    // FRUIT & VEGETABLE MANAGEMENT - Shows login first
    @FXML
    void openProductsManagement(ActionEvent event) {
        showLoginForModule("products", "Fruit & Vegetable");
    }

    // PHONE MANAGEMENT - Shows login first
    @FXML
    void openPhonesManagement(ActionEvent event) {
        showLoginForModule("phones", "Phone Management");
    }

    // Show login dialog for specific module
    private void showLoginForModule(String moduleType, String moduleTitle) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                    .getResource("/com/example/demo/views/login-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 450, 500);

            // Get the controller and set which module is being accessed
            LoginController loginController = fxmlLoader.getController();
            loginController.setRequiredModule(moduleType);

            Stage loginStage = new Stage();
            loginStage.setTitle("Login - " + moduleTitle);
            loginStage.setScene(scene);
            loginStage.setResizable(false);
            loginStage.show();

        } catch (Exception e) {
            showError("Error", "Failed to open login page: " + e.getMessage());
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