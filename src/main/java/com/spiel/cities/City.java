package com.spiel.cities;

public class City {
    private static final String INAPPROPRIATE_ENDING = "иь";
    private final String name;

    public City(String name) {
        name = removeInappropriateEnding(name);
        this.name = name;
    }

    private String removeInappropriateEnding(String value) {
        while (INAPPROPRIATE_ENDING.contains(value.toLowerCase().substring(value.length() - 1))) {
            value = value.substring(0, value.length() - 1);
        }
        return value;
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
