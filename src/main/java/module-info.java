module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.controllers;
    exports com.example.demo.models;
    opens com.example.demo.controllers to javafx.fxml;
}