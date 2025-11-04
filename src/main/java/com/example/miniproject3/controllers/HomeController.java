package com.example.miniproject3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;

public class HomeController {

    @FXML
    private Button personsMngBtn; // kept name to match existing FXML

    @FXML
    void openPersonsMng(ActionEvent event) {
        String fxmlPath = "/com/example/miniproject3/views/products-view.fxml"; // updated to products view
        try {
            URL resource = getClass().getResource(fxmlPath);
            if (resource == null) {
                String msg = "FXML not found at: " + fxmlPath + "\nMake sure the file is located in src/main/resources" +
                        "/com/example/miniproject3/views/products-view.fxml";
                showAlert("FXML Not Found", msg);
                System.err.println(msg);
                return;
            }

            FXMLLoader loader = new FXMLLoader(resource);
            Parent root = loader.load();
            Scene scene = new Scene(root, 900, 550);
            Stage stage = new Stage();
            stage.setTitle("Fruit & Vegetable Shop Management");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Loading Error", e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }

    private void showAlert(String title, String message) {
        // runLater not required here because this runs on FX thread from button action,
        // but it's safe to use Platform.runLater if you call this from another thread.
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
