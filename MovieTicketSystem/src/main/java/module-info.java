module com.kosthi.movieticketsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kosthi.movieticketsystem to javafx.fxml;
    exports com.kosthi.movieticketsystem;
    exports com.kosthi.movieticketsystem.controller;
    opens com.kosthi.movieticketsystem.controller to javafx.fxml;
}