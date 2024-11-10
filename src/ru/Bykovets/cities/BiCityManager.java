package ru.Bykovets.cities;

public class BiCityManager extends CityManager {
    private boolean UserCall = false;

    @Override
    public City findCityByName(String name) {
        for (City city : cities) {
            if (city.getName().equals(name)) {
                return city;
            }
        }
        return null;
    }

    @Override
    public boolean addWay(String fromCityName, String toCityName, int cost) {
        City fromCity = findCityByName(fromCityName);
        City toCity = findCityByName(toCityName);

        if (fromCity != null && toCity != null) {
            if (fromCity instanceof BiCity && toCity instanceof BiCity) {
                if (!((BiCity) fromCity).hasPathTo(toCity)) {
                    ((BiCity) fromCity).addWay(toCity, cost);
                    return true;
                } else {
                    if (UserCall) {
                        System.out.println("Путь между городами уже существует");
                    }
                    return false;
                }
            } else {
                if (!fromCity.hasPathTo(toCity)) {
                    fromCity.addWay(toCity, cost);
                    return true;
                } else {
                    if (UserCall) {
                        System.out.println("Путь между городами уже существует");
                    }
                    return false;
                }
            }
        } else {
            if (UserCall) {
                System.out.println("Один или оба города не найдены");
            }
            return false;
        }
    }

    @Override
    public boolean addWay(City fromCity, City toCity, int cost) {
        if (fromCity != null && toCity != null) {
            if (fromCity instanceof BiCity && toCity instanceof BiCity) {
                if (!((BiCity) fromCity).hasPathTo(toCity)) {
                    ((BiCity) fromCity).addWay(toCity, cost);
                    return true;
                } else {
                    if (UserCall) {
                        System.out.println("Путь между городами уже существует");
                    }
                    return false;
                }
            } else {
                if (!fromCity.hasPathTo(toCity)) {
                    fromCity.addWay(toCity, cost);
                    return true;
                } else {
                    if (UserCall) {
                        System.out.println("Путь между городами уже существует");
                    }
                    return false;
                }
            }
        } else {
            if (UserCall) {
                System.out.println("Один или оба города не найдены");
            }
            return false;
        }
    }

    @Override
    public boolean removeWay(City fromCity, City toCity) {
        if (fromCity != null && toCity != null) {
            if (fromCity instanceof BiCity && toCity instanceof BiCity) {
                if (((BiCity) fromCity).hasPathTo(toCity)) {
                    ((BiCity) fromCity).removeWay(toCity);
                    return true;
                } else {
                    if (UserCall) {
                        System.out.println("Путь между городами не существует");
                    }
                    return false;
                }
            } else {
                if (fromCity.hasPathTo(toCity)) {
                    fromCity.removeWay(toCity);
                    return true;
                } else {
                    if (UserCall) {
                        System.out.println("Путь между городами не существует");
                    }
                    return false;
                }
            }
        } else {
            if (UserCall) {
                System.out.println("Один или оба города не найдены");
            }
            return false;
        }
    }



    public void setUserCall(boolean UserCall) {
        this.UserCall = UserCall;
    }
}
