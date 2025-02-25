package com.example.informediscograficanre3615290;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InformeDiscografica extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        int canvas_w = 600;
        int canvas_h = 400;
        FXMLLoader fxmlLoader = new FXMLLoader(InformeDiscografica.class.getResource("Informe-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), canvas_w, canvas_h);
        stage.setTitle("Informe Discográfica NRE3615290");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}