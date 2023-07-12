package com.spiel.cities;

public class City {
    private static final String INAPPROPRIATE_ENDING = "иь";
    private String name;

    public City(String name) {
        this.name = name;
    }

    public void removeInappropriateEnding() {
        while (INAPPROPRIATE_ENDING.contains(this.name.toLowerCase().substring(this.name.length() - 1))) {
            this.name = this.name.substring(0, this.name.length() - 1);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return this.name.equalsIgnoreCase(city.name);
    }


    public char lastChar() {
        return name.toLowerCase().charAt(name.length() - 1);
    }

    public char firstChar() {
        return name.toLowerCase().charAt(0);
    }
}
