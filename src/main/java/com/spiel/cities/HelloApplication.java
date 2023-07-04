package com.spiel.cities;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root =FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Scene scene = new Scene(root);
        stage.setTitle("Вітаємо!!!");
        Image icon = new Image("city.png");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
            event.consume();
            logout(stage);
        });
    }
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public void logout(Stage stage){
        Image icon = new Image("city.png");
        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Вихід");
        alert.setHeaderText("Ви хочете покинути гру");
        alert.setContentText("Ви впевнені, що хочете покинути гру");
        Stage dialogStage = (Stage) alert.getDialogPane().getScene().getWindow();
        dialogStage.getIcons().add(icon);


        if(alert.showAndWait().get()== ButtonType.OK){
            System.out.println("you are exited");
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}