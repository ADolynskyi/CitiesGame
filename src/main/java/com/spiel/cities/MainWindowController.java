package com.spiel.cities;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainWindowController {
    public void setAnswerText(String answerText) {
        this.answerText.setText(answerText);
    }
    @FXML
    private Label answerText;

    public String getInputText() {
        return inputText.getText();
    }

    @FXML
    private TextField inputText;

    @FXML
    protected void makeMove(){
       //тут має бути виклик методу хід (Здається це в тебе turn)
        //наступний рядок для демонстрації роботи, видалити
        //answerText.setText(inputText.getText());
        setAnswerText(getInputText());
        //Cleaning text field for next input
        inputText.setText("");
    }





}
