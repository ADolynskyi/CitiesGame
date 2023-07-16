package com.spiel.cities;

import java.io.FileReader;
import java.io.IOException;

public class Game {
    public static final String SUCCESS_VALUE = "city";
    public static final String SURRENDER_VALUE = "Здаюсь";
    private final DataSet dataSet = new DataSet();
    private int score = 0;



    private  int hintScore=0;
    private City currentCity = null;

    public Game() {
        readNamesToSet(dataSet);
    }


    public String turn(String value) {
        if (dataSet.contains(value)) {
            if (!dataSet.isUsed(value)) {
                if (currentCity == null) {
                    dataSet.use(value);
                    currentCity = new City(value);
                    currentCity.removeInappropriateEnding();
                    return SUCCESS_VALUE;
                } else {
                    currentCity.removeInappropriateEnding();
                    if (currentCity.lastChar() == value.toLowerCase().charAt(0)) {
                        dataSet.use(value);
                        currentCity = new City(value);
                        currentCity.removeInappropriateEnding();
                        return SUCCESS_VALUE;
                    } else {
                        return "Місто не відповідає умові гри";
                    }
                }
            } else {
                return "Місто вже використовувалось";
            }
        } else {
            return "А таке місто точно існує? Я його не знаю";
        }
    }

    public String turnAI() {
        char lastChar = currentCity.lastChar();
        currentCity = dataSet.findAITurn(lastChar, true);
        if (currentCity != null) {
            return currentCity.toString();
        } else {
            return null;
        }
    }
    public String hintForUser(){
        currentCity.removeInappropriateEnding();
        char lastChar = currentCity.lastChar();
         City city;
         city = dataSet.findAITurn(lastChar, false);
        if (city != null) {
            return city.toString();
        } else {
            return "Міст з такою літерою не залишилось(:";
        }

    }

    public int getScore() {
        return score;
    }
    public int getHintScore() {
        return hintScore;
    }
    public void setHintScore(int hintScore){
        this.hintScore=hintScore;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void readNamesToSet(DataSet dataSet) {
        try (FileReader reader = new FileReader("src/main/resources/CityNames.txt")) {
            StringBuilder word = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                if (c != 13) {
                    if (c == 10) {
                        City city = new City(word.toString());
                        dataSet.add(city);
                        word = new StringBuilder();
                    } else {
                        word.append((char) c);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}

