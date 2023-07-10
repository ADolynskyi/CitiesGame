package com.spiel.cities;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainWindowController {
    @FXML
    private Label answerLabel;



    @FXML
    private TextField inputField;
    private Game game= new Game();

    @FXML
    protected void makeMove(){
        if(inputField.getText().equals("")){
            answerLabel.setText("Введіть місто");
        }else if(inputField.getText().equals("Здаюсь")){
            ////виклик методу привітання
            answerLabel.setText("Комп'ютер вигравз рахунком "+game.getScore()+" бали" );
            game=new Game();
            }else {
                   String turnResult= game.turn(inputField.getText());
                   if (turnResult.equals("city")) {
                       game.setScore(game.getScore()+1);
                       String cityFromAI=game.turnAI();
                            if (cityFromAI!=null) {
                                answerLabel.setText(cityFromAI);
                                inputField.setText("");
                                }else {
                                //виклик методу привітання
                                answerLabel.setText("Ви виграли з рахунком "+game.getScore()+" бали" );
                                game=new Game();
                            }
                   }else {
                       answerLabel.setText(turnResult);
                   }
            }
        inputField.setText("");

    }


}
