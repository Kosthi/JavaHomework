module com.kosthi.eums {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kosthi.eums to javafx.fxml;
    exports com.kosthi.eums;
}