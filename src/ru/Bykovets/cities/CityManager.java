package ru.Bykovets.cities;

import java.util.ArrayList;
import java.util.List;

public class CityManager {
    public List<City> cities;

    public CityManager() {
        this.cities = new ArrayList<>();
    }

    public void addCity(City city) {
        cities.add(city);
    }

    public City findCityByName(String name) {
        for (City city : cities) {
            if (city.getName().equals(name)) {
                return city;
            }
        }
        return null;
    }

    public boolean addWay(String fromCityName, String toCityName, int cost) {
        City fromCity = findCityByName(fromCityName);
        City toCity = findCityByName(toCityName);

        if (fromCity != null && toCity != null) {
            return addWay(fromCity, toCity, cost);
        } else {
            System.out.println("Один или оба города не найдены");
            return false;
        }
    }

    public boolean addWay(City fromCity, City toCity, int cost) {
        if (fromCity != null && toCity != null) {
            if (!fromCity.hasPathTo(toCity)) {
                fromCity.addWay(toCity, cost);
                return true;
            } else {
                System.out.println("Путь между городами уже существует");
                return false;
            }
        } else {
            System.out.println("Один или оба города не найдены");
            return false;
        }
    }

    public boolean removeWay(City fromCity, City toCity) {
        if (fromCity != null && toCity != null) {
            if (fromCity.hasPathTo(toCity)) {
                fromCity.removeWay(toCity);
                return true;
            } else {
                System.out.println("Путь между городами не существует");
                return false;
            }
        } else {
            System.out.println("Один или оба города не найдены");
            return false;
        }
    }

    public void printCities() {
        for (City city : cities) {
            System.out.println(city);
        }
    }
}
