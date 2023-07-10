package com.spiel.cities;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloController {


    @FXML
    protected void onOkButtonClick(ActionEvent event) throws IOException {
       // Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-window.fxml")));
        Parent root= HelloApplication.getMainWindowLoader().load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene((root));
        stage.setTitle("Міста");
        stage.setScene(scene);
        stage.show();
    }

}