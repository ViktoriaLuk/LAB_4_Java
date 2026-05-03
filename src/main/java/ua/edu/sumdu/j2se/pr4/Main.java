package ua.edu.sumdu.j2se.pr4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Create Employee\n2. Show All\n3. Exit");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                addEmployee();
            } else if (choice.equals("2")) {
                employees.forEach(System.out::println);
            } else if (choice.equals("3")) {
                break;
            } else {
                System.out.println("Unknown command");
            }
        }
    }

    private static void addEmployee() {
        try {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter salary: ");
            double salary = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter position: ");
            String position = scanner.nextLine();

            employees.add(new Employee(name, age, salary, position));
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}