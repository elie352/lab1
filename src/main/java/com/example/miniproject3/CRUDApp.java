package com.example.miniproject3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;

public class CRUDApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        String fxmlPath = "/com/example/miniproject3/views/products-view.fxml";
        URL resource = getClass().getResource(fxmlPath);

        System.out.println("Looking for FXML at: " + fxmlPath);
        System.out.println("Result = " + resource);

        if (resource == null) {
            throw new RuntimeException("FXML not found at " + fxmlPath);
        }


        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Scene scene = new Scene(fxmlLoader.load(), 900, 550);
        stage.setTitle("Fruit & Vegetable Shop Management System");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}
