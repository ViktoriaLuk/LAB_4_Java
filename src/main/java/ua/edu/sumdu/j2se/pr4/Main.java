package ua.edu.sumdu.j2se.pr4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Лук'яніхіна Вікторія, група ІН-31.1");
        System.out.println("Лабораторна робота №7: Наслідування, поліморфізм та колекції");
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add Full-Time Employee");
            System.out.println("2. Add Contract Employee");
            System.out.println("3. Show All (Polymorphism Demo)");
            System.out.println("4. Exit");
            System.out.print("> ");
            
            String choice = scanner.nextLine();
            if (choice.equals("4")) break;

            if (choice.equals("1") || choice.equals("2")) {
                try {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    if (name.matches(".*\\d.*")) {
                        System.out.println("Error: Name cannot contain numbers.");
                        continue;
                    }

                    System.out.print("Enter age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    if (age < 18 || age > 100) {
                        System.out.println("Error: Age must be between 18 and 100");
                        continue;
                    }

                    double salary = 0;
                    double rate = 0;
                    int months = 0;

                    if (choice.equals("1")) {
                        System.out.print("Enter monthly salary: ");
                        salary = Double.parseDouble(scanner.nextLine());
                    } else {
                        System.out.print("Enter hourly rate: ");
                        rate = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter contract period (months): ");
                        months = Integer.parseInt(scanner.nextLine());
                    }

                    System.out.print("Enter position (e.g. Developer, Manager): ");
                    String position = scanner.nextLine();

                    if (choice.equals("1")) {
                        employees.add(new FullTimeEmployee(name, age, position, salary));
                    } else {
                        employees.add(new ContractEmployee(name, age, position, rate, months));
                    }
                    System.out.println("Success: Employee added!");

                } catch (NumberFormatException e) {
                    System.out.println("Error: Please enter a valid number.");
                }
            } else if (choice.equals("3")) {
                System.out.println("\n--- List of Employees (Polymorphism) ---");
                if (employees.isEmpty()) {
                    System.out.println("The list is empty.");
                } else {
                    for (Employee e : employees) {
                        System.out.println(e);
                    }
                }
            }
        }
        scanner.close();
        System.out.println("Program finished.");
    }
}