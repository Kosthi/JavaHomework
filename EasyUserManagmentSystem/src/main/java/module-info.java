module com.koschei.eums {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.koschei.eums to javafx.fxml;
    exports com.koschei.eums;
    exports com.koschei.eums.controller;
    opens com.koschei.eums.controller to javafx.fxml;
}