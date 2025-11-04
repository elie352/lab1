module com.example.miniproject3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    // allow FXMLLoader to access controllers and model classes via reflection
    opens com.example.miniproject3 to javafx.fxml;
    opens com.example.miniproject3.controllers to javafx.fxml;
    opens com.example.miniproject3.models to javafx.fxml, javafx.base;

    // export packages if other modules need to access them (optional)
    exports com.example.miniproject3;
    exports com.example.miniproject3.controllers;
    exports com.example.miniproject3.models;
}
