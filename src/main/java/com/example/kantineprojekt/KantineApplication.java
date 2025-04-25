package com.example.kantineprojekt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KantineApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(KantineApplication.class.getResource("View/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Kantine Scan-selv");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}