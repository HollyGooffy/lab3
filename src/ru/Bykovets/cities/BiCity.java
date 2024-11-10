package ru.Bykovets.cities;

public class BiCity extends City {
    public BiCity(String name) {
        super(name);
    }

    @Override
    public void addWay(City city, int cost) {
        if (!hasPathTo(city)) {
            super.addWay(city, cost);
            if (city instanceof BiCity) {
                city.addWay(this, cost);
            }
        }
    }

    @Override
    public void removeWay(City city) {
        super.removeWay(city);
        if (city instanceof BiCity && !((BiCity) city).isDelete) {
            ((BiCity) city).isDelete = true;
            city.removeWay(this);
            ((BiCity) city).isDelete = false;
        }
    }

    private boolean isDelete = false;
}