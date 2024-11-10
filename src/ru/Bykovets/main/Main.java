package ru.Bykovets.main;

import ru.Bykovets.cities.BiCity;
import ru.Bykovets.cities.BiCityManager;
import ru.Bykovets.cities.City;
import ru.Bykovets.beards.Beard;
import ru.Bykovets.beards.kukushka;
import ru.Bykovets.beards.popugai;
import ru.Bykovets.beards.vorobey;
import ru.Bykovets.geometry.Point3D;

import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /* Задания 1.10 и 3.3 */
        System.out.println("Задание 1.10 и 3.3");
        BiCityManager cityManager = new BiCityManager();

        BiCity cityA = new BiCity("A");
        BiCity cityB = new BiCity("B");
        BiCity cityC = new BiCity("C");
        BiCity cityD = new BiCity("D");
        BiCity cityE = new BiCity("E");
        BiCity cityF = new BiCity("F");

        cityManager.addCity(cityA);
        cityManager.addCity(cityB);
        cityManager.addCity(cityC);
        cityManager.addCity(cityD);
        cityManager.addCity(cityE);
        cityManager.addCity(cityF);

        // Город А
        cityManager.addWay("A", "B", 5);
        cityManager.addWay("A", "F", 1);
        cityManager.addWay("A", "D", 6);

        // Город B
        cityManager.addWay("B", "A", 5);
        cityManager.addWay("B", "C", 3);

        // Город C
        cityManager.addWay("C", "B", 3);
        cityManager.addWay("C", "D", 4);

        // Город D
        cityManager.addWay("D", "C", 4);
        cityManager.addWay("D", "E", 2);
        cityManager.addWay("D", "A", 6);

        // Город E
        cityManager.addWay("E", "F", 2);

        // Город F
        cityManager.addWay("F", "E", 2);
        cityManager.addWay("F", "B", 1);

        // Печать информации о городах
        cityManager.printCities();
        System.out.println();

        while (true) {
            System.out.println("Выбрать действие:");
            System.out.println("1. Добавить дорогу");
            System.out.println("2. Удалить дорогу");
            System.out.println("3. Показать все города и дороги");
            System.out.println("4. Выйти");


            int choice = 0;

            while (true) {
                System.out.print("Введите номер действия: ");
                if (in.hasNextInt()) {
                    choice = in.nextInt();
                    in.nextLine();
                    break;
                } else {
                    System.out.println("Пожалуйста, введите целое число.");
                    in.nextLine();
                }
            }

            if (choice == 1) {
                System.out.println("Введите название изначального города: ");
                String fromCity = in.nextLine();
                System.out.println("Введите город прибытия: ");
                String toCity = in.nextLine();
                System.out.println("Введите стоимость дороги: ");

                int cost = 0;
                while (true) {
                    if (in.hasNextInt()) {
                        cost = in.nextInt();
                        in.nextLine();
                        break;
                    } else {
                        System.out.println("Пожалуйста, введите целое число для стоимости дороги.");
                        in.nextLine();
                    }
                }

                City fromCityTo = cityManager.findCityByName(fromCity);
                City toCityFrom = cityManager.findCityByName(toCity);

                if (fromCityTo != null && toCityFrom != null) {
                    cityManager.addWay(fromCityTo, toCityFrom, cost);
                    if (cityManager.addWay(fromCityTo, toCityFrom, cost)) {
                        System.out.println("Дорога добавлена");
                    }
                    cityManager.setUserCall(false);
                } else {
                    System.out.println("Один или оба города не найдены");
                }
            } else if (choice == 2) {
                System.out.println("Введите город отправления: ");
                String fromCity = in.nextLine();
                System.out.println("Введите город назначения: ");
                String toCity = in.nextLine();

                City fromCityTo = cityManager.findCityByName(fromCity);
                City toCityFrom = cityManager.findCityByName(toCity);

                if (fromCityTo != null && toCityFrom != null) {
                    cityManager.setUserCall(true);
                    if (cityManager.removeWay(fromCityTo, toCityFrom)) {
                        System.out.println("Дорога удалена");
                    }
                    cityManager.setUserCall(false);

                } else {
                    System.out.println("Один или оба города не найдены");
                }

            } else if (choice == 3) {
                cityManager.printCities();
                System.out.println();
            } else if (choice == 4) {
                System.out.println();
                break;

            } else {
                System.out.println("Неправильный ввод");
            }
        }


        /* Задание 3.5 и задание 8.4 */
        System.out.println("Задание 3.5");

        Point3D[] point3D = new Point3D[3];

        for (int i = 0; i < 3; i++) {
            double x = 0, y = 0, z = 0;
            while (true) {
                System.out.println("Введите координаты точки " + (i + 1) + " (X Y Z): ");
                if (in.hasNextDouble()) {
                    x = in.nextDouble();
                    if (in.hasNextInt()) {
                        y = in.nextDouble();
                        if (in.hasNextDouble()) {
                            z = in.nextDouble();
                            point3D[i] = new Point3D(x, y, z);
                            break;
                        }
                    }
                }
                in.next();
            }
        }
        System.out.println("Результат: ");
        for (int i = 0; i < point3D.length; i++) {
            System.out.println(point3D[i].toString());
        }
        System.out.println();

        // Проверяем клонирование
        System.out.println("\nПроверка клонирования:");
        try {
            for (int i = 0; i < point3D.length; i++) {
                Point3D original = point3D[i];
                Point3D copy = original.clone();

                System.out.printf("Оригинал: %s%n", original.toString());
                System.out.printf("Копия: %s%n", copy.toString());
                System.out.printf("Сравнение по equals: %b%n%n", original.equals(copy));
            }
        } catch (CloneNotSupportedException e) {
            System.out.println("Ошибка при клонировании: " + e.getMessage());
        }




        /* Задание 5.9 */

        System.out.println("Задание 5.9");
        System.out.println();
        BiCityManager cityManager2 = new BiCityManager();

        BiCity cityA_new = new BiCity("A");
        City cityB_new = new City("B");
        BiCity cityC_new = new BiCity("C");
        BiCity cityD_new = new BiCity("D");
        City cityE_new = new City("E");

        cityManager2.addCity(cityA_new);
        cityManager2.addCity(cityB_new);
        cityManager2.addCity(cityC_new);
        cityManager2.addCity(cityD_new);
        cityManager2.addCity(cityE_new);

        // Город А
        cityManager2.addWay("A", "B", 1);
        cityManager2.addWay("A", "C", 1);

        // Город B
        cityManager2.addWay("B", "A", 1);
        cityManager2.addWay("B", "C", 1);
        cityManager2.addWay("B", "D", 1);

        // Город C
        cityManager2.addWay("C", "A", 1);

        // Город D
        cityManager2.addWay("D", "B", 1);
        cityManager2.addWay("D", "E", 1);

        // Город E
        cityManager2.addWay("E", "C", 1);
        cityManager2.addWay("E", "D", 1);

        // Печать информации о городах
        cityManager2.printCities();
        System.out.println();






        /* Задание 4.3 */
        System.out.println("Задание 4.3");
        Beard vorobey = new vorobey();
        Beard kukushka = new kukushka();
        Beard popugai = new popugai("текст попугая");


        vorobey.songes();
        kukushka.songes();
        popugai.songes();


        /* Задание 7.3 */
        System.out.println("Задание 7.3");
        if (args.length != 2) {
            System.out.println("Пожалуйста, введите два числа в качестве аргументов командной строки.");
            return;
        }

        String xStr = args[0];
        String yStr = args[1];

        try {
            double result = power(xStr, yStr);
            System.out.println("Результат: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число: " + e.getMessage());
        }
    }

    public static double power(String xStr, String yStr) {
        int x = Integer.parseInt(xStr);
        int y = Integer.parseInt(yStr);
        return Math.pow(x, y);
    }

}


