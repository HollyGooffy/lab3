package ru.Bykovets.cities;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private List<CityPath> paths;

    public City() {
        this.name = "Unnamed";
        this.paths = new ArrayList<>();
    }

    public City(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название города не может быть пустым или null");
        }
        this.name = name;
        this.paths = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addWay(City city, int cost) {
        if (city == null) {
            throw new IllegalArgumentException("Город не может быть null");
        }
        if (!hasPathTo(city)) {
            paths.add(new CityPath(city, cost));
        }
    }

    public void removeWay(City city) {
        for (int i = 0; i < paths.size(); i++) {
            if (paths.get(i).getCity().getName().equals(city.getName())) {
                paths.remove(i);
                break;
            }
        }
    }

    public List<CityPath> getPaths() {
        return new ArrayList<>(paths);
    }

    public boolean hasPathTo(City city) {
        for (CityPath path : paths) {
            if (path.getCity().getName().equals(city.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(": ");
        for (CityPath path : paths) {
            sb.append(path.toString()).append(" ");
        }
        return sb.toString().trim();
    }
}