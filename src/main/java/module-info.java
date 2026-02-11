module edu.ijse.layered.fx.sms {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.sql;

    opens edu.ijse.layered.fx.sms to javafx.fxml;
    exports edu.ijse.layered.fx.sms;
}