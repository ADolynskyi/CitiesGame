package com.spiel.cities;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class DataSet {
    private final HashMap<City, Boolean> citiesUsed = new HashMap<>();

    public void add(City city) {
        citiesUsed.put(city, false);
    }

    public boolean contains(String value) {
        return citiesUsed.containsKey(new City(value));
    }

    public boolean isUsed(String value) {
        return citiesUsed.get(new City(value));
    }

    public void use(String value) {
        citiesUsed.put(new City(value), true);
    }

    public City findAITurn(char c) {
        AtomicBoolean found = new AtomicBoolean(false);
        AtomicReference<City> city = new AtomicReference<>();
        citiesUsed.forEach((key, used) -> {
            if (!found.get() && !used && key.firstChar() == c) {
                city.set(key);
                found.set(true);
            }
        });
        if (found.get()) {
            citiesUsed.put(city.get(), true);
            return city.get();
        } else {
            return null;
        }
    }
}
