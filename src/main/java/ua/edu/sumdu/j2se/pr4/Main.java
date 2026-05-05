package ua.edu.sumdu.j2se.pr4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Лук'яніхіна Вікторія, група ІН-31.1");
        System.out.println("Лабораторна робота №8");
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Create new object");
            System.out.println("2. Show all objects");
            System.out.println("3. Exit");
            System.out.print("> ");
            
            String choice = scanner.nextLine();
            
            if (choice.equals("3")) {
                break;
            } else if (choice.equals("1")) {
                createObjectMenu(employees, scanner);
            } else if (choice.equals("2")) {
                showAll(employees);
            }
        }
        
        scanner.close();
        System.out.println("Program finished.");
    }

    private static void createObjectMenu(ArrayList<Employee> employees, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Select Type to Create ---");
            System.out.println("1. Full-Time Employee");
            System.out.println("2. Contract Employee");
            System.out.println("3. Intern");
            System.out.println("4. Manager");
            System.out.println("5. Back to main menu");
            System.out.print("> ");

            String typeChoice = scanner.nextLine();
            if (typeChoice.equals("5")) break;

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

                System.out.print("Enter position: ");
                String position = scanner.nextLine();

                switch (typeChoice) {
                    case "1":
                        System.out.print("Enter monthly salary: ");
                        double salary = Double.parseDouble(scanner.nextLine());
                        employees.add(new FullTimeEmployee(name, age, position, salary));
                        break;
                    case "2":
                        System.out.print("Enter hourly rate: ");
                        double rate = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter contract period (months): ");
                        int months = Integer.parseInt(scanner.nextLine());
                        employees.add(new ContractEmployee(name, age, position, rate, months));
                        break;
                    case "3":
                        System.out.print("Enter university: ");
                        String uni = scanner.nextLine();
                        employees.add(new Intern(name, age, position, uni));
                        break;
                    case "4":
                        System.out.print("Enter team size: ");
                        int size = Integer.parseInt(scanner.nextLine());
                        employees.add(new Manager(name, age, position, size));
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        continue;
                }
                System.out.println("Success: Object added!");
                break; 

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }

    private static void showAll(ArrayList<Employee> employees) {
        System.out.println("\n--- List of All Objects (Polymorphism) ---");
        if (employees.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (Employee e : employees) {
                System.out.println(e);
            }
        }
    }
}