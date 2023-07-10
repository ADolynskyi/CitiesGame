package com.spiel.cities;
public class Game {
    private final DataSet dataSet = new DataSet();
    private int score = 0;
    private City currentCity = null;

    public Game() {
        dataSet.add(new City("Київ"));
        dataSet.add(new City("Дніпро"));
        dataSet.add(new City("Львів"));
        dataSet.add(new City("Вінниця"));
        dataSet.add(new City("Антверпен"));
        dataSet.add(new City("Миколаїв"));
        dataSet.add(new City("Вільнюс"));
        dataSet.add(new City("Нетішин"));
        dataSet.add(new City("Ялта"));
    }

    public String turn(String value) {
        if (dataSet.contains(value)) {
            if (!dataSet.isUsed(value)) {
                if (currentCity == null) {
                    dataSet.use(value);
                    currentCity = new City(value);
                    return "city";
                } else {
                    if (currentCity.lastChar() == value.toLowerCase().charAt(0)) {
                        dataSet.use(value);
                        currentCity = new City(value);
                        return "city";
                    } else {

                        return "Місто не відповідає умові гри";
                    }
                }
            } else {

                return "Місто вже використовувалось";
            }
        } else  {

            return "А таке місто точно існує? Я його не знаю";
        }

    }

    public String turnAI() {
        char lastChar = currentCity.lastChar();
        currentCity = dataSet.findAITurn(lastChar);
        if(currentCity!=null) {
            return currentCity.toString();
        }else {
          return null;
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}

