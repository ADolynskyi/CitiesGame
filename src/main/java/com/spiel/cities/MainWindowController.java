package com.spiel.cities;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainWindowController {
    public void setAnswerText(String answerText) {
        this.answerLabel.setText(answerText);
    }
    @FXML
    private Label answerLabel;

    @FXML
    private TextField inputField;
    public String getInputText() {
        return inputField.getText();
    }
    @FXML
    protected void makeMove(){
       //тут має бути виклик методу хід (Здається це в тебе turn)
        //наступний рядок для демонстрації роботи, видалити
        setAnswerText(getInputText());
        //Cleaning text field for next input
        inputField.setText("");
    }





}
