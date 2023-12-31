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
            greeting(stage, "Комп'ютер виграв", game.getScore(),game.getHintScore());
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
                    greeting(stage, "Ви виграли", game.getScore(),game.getHintScore());
                }
            } else {
                infoLabel.setText(turnResult);
            }
        }
        inputField.setText("");

    }

    public void greeting(Stage stage, String result, int score, int hintScore) {
        infoLabel.setText("");
        Image icon = new Image("city.png");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Чудова гра");
        String rightPluralForm;
        String rightPluralForm2;
        if (score % 10 == 1) {
            rightPluralForm = " бал";
        } else if (score % 10 == 2 || score % 10 == 3 || score % 10 == 4) {
            rightPluralForm = " бали";
        } else {
            rightPluralForm = " балів";
        }
        if (hintScore % 10 == 1) {
            rightPluralForm2 = " підказку";
        } else if (hintScore % 10 == 2 || hintScore % 10 == 3 || hintScore % 10 == 4) {
            rightPluralForm2 = " підказки";
        } else {
            rightPluralForm2 = " підказок";
        }
        alert.setHeaderText(result + ", з рахунком в " + score + rightPluralForm+
                "\nТи використав "+hintScore+rightPluralForm2);
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

    @FXML
    public void giveUp() {
        Stage stage = (Stage) inputField.getScene().getWindow();
        greeting(stage, "Комп'ютер виграв", game.getScore(),game.getHintScore());
    }

    @FXML
    public void getHint(){
        if(game.getScore()>4){
            game.setHintScore(game.getHintScore()+1);
            infoLabel.setText(game.hintForUser());
        }else {
            infoLabel.setText("Щоб отримати підказку, згадай чотири міста");
        }


    }
}
