package com.spiel.cities;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController {


    @FXML
    protected void onOkButtonClick(ActionEvent event) throws IOException {
        Parent root= HelloApplication.getMainWindowLoader().load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene((root));
        stage.setTitle("Міста");
        stage.setScene(scene);
        stage.show();
    }


}