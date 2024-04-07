module com.test {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    exports  com.test.model;
    opens com.test.model to javafx.fxml;
    exports com.test.controller;
    opens com.test.controller to javafx.fxml;
    exports com.test.view;
    opens com.test.view to javafx.fxml;
}