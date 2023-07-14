package com.spiel.cities;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {


    @FXML
    protected void onOkButtonClick(ActionEvent event) throws IOException {
        Parent root = HelloApplication.getMainWindowLoader().load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene((root));
        stage.setTitle("Міста");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void setRulesButtonClick() {
        Image icon = new Image("city.png");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Міста");
        alert.setHeaderText("Правила гри");
        alert.setContentText("1. Гра розпочинається із введення міста гравцем \n" +
                "2. Комп'ютер шукає місто у відповідь\n" +
                "3. Потім гравець шукає місто\n" +
                "4. Назва міста у відповідь має розпочинаєтися з станьої літери назви попередньго міста\n" +
                "\t4.1 Якщо остання літера \"и\" або м'який знак то береться літера перед нею\n" +
                "5. Виграє той хто згадає більше міст \n" +
                "6. Щоб здатись введіть в поле міста \"Здаюсь\" ");

        Stage dialogStage = (Stage) alert.getDialogPane().getScene().getWindow();
        dialogStage.getIcons().add(icon);
        dialogStage.setHeight(500);

        alert.showAndWait();

    }

}