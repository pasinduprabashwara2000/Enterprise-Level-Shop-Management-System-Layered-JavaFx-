module edu.ijse.layered.fx.sms {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.sql;
    requires jasperreports;

    opens edu.ijse.layered.fx.sms.controller to javafx.fxml;

    exports edu.ijse.layered.fx.sms;
}