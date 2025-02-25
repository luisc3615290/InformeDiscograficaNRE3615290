module com.example.informediscograficanre3615290 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jasperreports;
    requires java.sql;


    opens com.example.informediscograficanre3615290 to javafx.fxml;
    exports com.example.informediscograficanre3615290;
}