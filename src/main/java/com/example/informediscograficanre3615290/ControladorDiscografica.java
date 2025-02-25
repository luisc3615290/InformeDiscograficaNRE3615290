package com.example.informediscograficanre3615290;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControladorDiscografica implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private String urlDB ="jdbc:sqlite:db/chinook.db";
    //private ObservableList<Pelicula> ListaPeliculas = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
        ListaPeliculas.add(new Pelicula(1,"Inception", 2010));
        ListaPeliculas.add(new Pelicula(2,"The darck Knight", 2008));
        ListaPeliculas.add(new Pelicula(3, "Forrest Gump", 1994));
        ListaPeliculas.add(new Pelicula(4, "The Matrix", 1999));
        System.out.println(ListaPeliculas);

         */

    }





    public void openInformeClientes(ActionEvent actionEvent) {
        try {
            String jasperFilePath = "informeResources/InformeDiscografica01_Clientes.jrxml";
            InputStream inputStream = InformeDiscografica.class.getResourceAsStream(jasperFilePath);

            // Compilar el informe JRXML a un archivo Jasper
            System.out.println("Compilando : " + jasperFilePath);
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

            Connection conn = DriverManager.getConnection(urlDB);

            // Al informe compilado le cargamos los parametros y la conexión a la base de datos
            // como nuestro informe no tiene nada de eso proporcionamos objetos vacios.
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,new HashMap<>(),new JREmptyDataSource());

            // Mostramos el informe (el valor true al cerrar el informe se cierra la aplicación.
            JasperViewer.viewReport(jasperPrint, true);
        } catch (Exception e) {
            System.out.println("Error al abrir el informe");
            e.printStackTrace();
        }

    }


    public void openInformeArtistas(ActionEvent actionEvent) {
    }

    public void openCerrarDialog(ActionEvent actionEvent) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Close App");
        alerta.setHeaderText("Confirmar cerrar aplicaclión");

        Optional<ButtonType> resultado = alerta.showAndWait();

        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            System.exit(0);
        }

    }
}