module com.kosthi.movieticketsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens com.kosthi.movieticketsystem to javafx.fxml;
    exports com.kosthi.movieticketsystem;
    exports com.kosthi.movieticketsystem.controller;
    exports com.kosthi.movieticketsystem.test;
    opens com.kosthi.movieticketsystem.controller to javafx.fxml;
}