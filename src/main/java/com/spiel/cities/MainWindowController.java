package com.spiel.cities;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Optional;

public class MainWindowController {
    @FXML
    private Label answerLabel;
    @FXML
    private Label infoLabel;
    @FXML
    private TextField inputField;
    private Game game = new Game();

    @FXML
    protected void makeMove() {
        if (inputField.getText().equals("")) {
            infoLabel.setText("Введіть місто");
        } else if (inputField.getText().equalsIgnoreCase(Game.SURRENDER_VALUE)) {
            Stage stage = (Stage) inputField.getScene().getWindow();
            greeting(stage, "Комп'ютер виграв", game.getScore());
        } else {
            String turnResult = game.turn(inputField.getText());
            if (turnResult.equals(Game.SUCCESS_VALUE)) {
                game.setScore(game.getScore() + 1);
                String cityFromAI = game.turnAI();
                if (cityFromAI != null) {
                    answerLabel.setText(cityFromAI);
                    inputField.setText("");
                    infoLabel.setText("");
                } else {
                    Stage stage = (Stage) inputField.getScene().getWindow();
                    greeting(stage, "Ви виграли", game.getScore());
                }
            } else {
                infoLabel.setText(turnResult);
            }
        }
        inputField.setText("");

    }

    public void greeting(Stage stage, String result, int score) {
        Image icon = new Image("city.png");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Чудова гра");
        alert.setHeaderText(result + ", з рахунком в " + score + " бали(ів)");
        alert.setContentText("Бажаєте зіграти ще?");
        Stage dialogStage = (Stage) alert.getDialogPane().getScene().getWindow();
        dialogStage.getIcons().add(icon);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.isPresent() && buttonType.get() == ButtonType.OK) {
            answerLabel.setText("");
            game = new Game();
        } else {
            stage.close();
        }
    }
}
