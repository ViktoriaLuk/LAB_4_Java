package ua.edu.sumdu.j2se.pr4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Employee> employees = new ArrayList<Employee>();

        System.out.print("Введіть кількість працівників: ");
        int count = scanner.nextInt();

        scanner.nextLine();

        for (int i = 0; i < count; i++) {

            System.out.println("\nПрацівник " + (i + 1));

            System.out.print("Ім'я: ");
            String name = scanner.nextLine();

            System.out.print("Вік: ");
            int age = scanner.nextInt();

            System.out.print("Зарплата: ");
            double salary = scanner.nextDouble();

            scanner.nextLine();

            Employee employee = new Employee(name, age, salary);

            employees.add(employee);
        }

        System.out.println("\nСписок працівників:");

        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }

        scanner.close();
    }
}