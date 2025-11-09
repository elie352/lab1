package com.example.demo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField usernameFld;

    @FXML
    private PasswordField passwordFld;

    @FXML
    private Button loginBtn;

    private String requiredModule;

    public void setRequiredModule(String module) {
        this.requiredModule = module;
    }

    @FXML
    void handleLogin(ActionEvent event) {
        String username = usernameFld.getText().trim().toLowerCase();
        String password = passwordFld.getText();

        // Check credentials
        boolean valid = false;

        if (requiredModule.equals("pcparts") && username.equals("pc parts") && password.equals("12345678")) {
            valid = true;
        } else if (requiredModule.equals("cars") && username.equals("car parts") && password.equals("12345678")) {
            valid = true;
        } else if (requiredModule.equals("products") && username.equals("fruits") && password.equals("12345678")) {
            valid = true;
        } else if (requiredModule.equals("phones") && username.equals("phone") && password.equals("12345678")) {
            valid = true;
        }

        if (valid) {
            try {
                openModule();
                Stage stage = (Stage) loginBtn.getScene().getWindow();
                stage.close();
            } catch (Exception e) {
                showError("Error opening page!");
            }
        } else {
            showError("Wrong username or password!");
        }
    }

    private void openModule() throws Exception {
        String fxmlFile = "";
        String title = "";

        if (requiredModule.equals("pcparts")) {
            fxmlFile = "/com/example/demo/views/persons-view.fxml";
            title = "PC PARTS";
        } else if (requiredModule.equals("cars")) {
            fxmlFile = "/com/example/demo/views/cars-view.fxml";
            title = "Car Management";
        } else if (requiredModule.equals("products")) {
            fxmlFile = "/com/example/demo/views/products-view.fxml";
            title = "Fruit & Vegetable";
        } else if (requiredModule.equals("phones")) {
            fxmlFile = "/com/example/demo/views/phones-view.fxml";
            title = "Phone Management";
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Scene scene = new Scene(loader.load(), 900, 600);
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Failed");
        alert.setContentText(message);
        alert.showAndWait();
    }
}