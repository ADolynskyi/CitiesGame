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
import java.util.Optional;


public class HelloApplication extends Application {
     static FXMLLoader mainWindowLoader;
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
        mainWindowLoader= createMainWindowLoader();

            }

    public void logout(Stage stage){
        Image icon = new Image("city.png");
        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Вихід");
        alert.setHeaderText("Ви хочете покинути гру");
        alert.setContentText("Ви впевнені, що хочете покинути гру");
        Stage dialogStage = (Stage) alert.getDialogPane().getScene().getWindow();
        dialogStage.getIcons().add(icon);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if(buttonType.isPresent() && buttonType.get()== ButtonType.OK){
            stage.close();
        }
    }
    private FXMLLoader createMainWindowLoader(){
        return new FXMLLoader(Objects.requireNonNull(getClass().getResource("main-window.fxml")));
    }
    public static FXMLLoader getMainWindowLoader() {
        return mainWindowLoader;
    }

    public static void main(String[] args) {
        launch();
    }
}