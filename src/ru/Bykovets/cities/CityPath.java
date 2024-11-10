package ru.Bykovets.cities;

public class CityPath {
    private City city;
    private int cost;

    public CityPath() {
        this.city = null;
        this.cost = 0;
    }

    public CityPath(City city, int cost) {
        this.city = city;
        this.cost = cost;
    }

    public City getCity() {
        return city;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return city.getName() + ":" + cost;
    }
}