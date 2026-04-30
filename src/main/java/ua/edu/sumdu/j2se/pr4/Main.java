package ua.edu.sumdu.j2se.pr4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Головний клас програми.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Employee> employees =
                new ArrayList<Employee>();

        boolean running = true;

        while (running) {

            System.out.println("\nМЕНЮ");
            System.out.println("1. Створити працівника");
            System.out.println("2. Вивести всіх працівників");
            System.out.println("3. Вийти");

            System.out.print("Ваш вибір: ");

            try {

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:

                        System.out.print("Ім'я: ");
                        String name = scanner.nextLine();

                        System.out.print("Вік: ");
                        int age = scanner.nextInt();

                        System.out.print("Зарплата: ");
                        double salary = scanner.nextDouble();

                        scanner.nextLine();

                        System.out.print("Посада: ");
                        String position = scanner.nextLine();

                        Employee employee =
                                new Employee(
                                        name,
                                        age,
                                        salary,
                                        position
                                );

                        employees.add(employee);

                        System.out.println(
                                "Працівника додано");

                        break;

                    case 2:

                        if (employees.isEmpty()) {

                            System.out.println(
                                    "Список порожній");

                        } else {

                            for (Employee emp : employees) {
                                System.out.println(emp);
                            }
                        }

                        break;

                    case 3:

                        running = false;

                        System.out.println(
                                "Програму завершено");

                        break;

                    default:

                        System.out.println(
                                "Невірний пункт меню");
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "Помилка: неправильний тип даних");

                scanner.nextLine();

            } catch (IllegalArgumentException e) {

                System.out.println(
                        "Помилка: " + e.getMessage());
            }
        }

        scanner.close();
    }
}