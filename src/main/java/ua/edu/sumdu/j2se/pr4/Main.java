package ua.edu.sumdu.j2se.pr4;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Main {
    public static void main(String[] args) {
        System.out.println("Лук'яніхіна Вікторія, група ІН-31.1");
        System.out.println("Лабораторна робота №9");
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        String jsonFile = "input.json";

        loadFromJson(employees, jsonFile);

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Create new object");
            System.out.println("2. Show all objects");
            System.out.println("3. Exit");
            System.out.print("> ");
            System.out.flush();
            
            String choice = scanner.nextLine();
            
            if (choice.equals("3")) {
                saveToJson(employees, jsonFile);
                System.out.println("Вихід...");
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
            System.out.flush();

            String typeChoice = scanner.nextLine();
            if (typeChoice.equals("5")) break;

            try {
                System.out.print("Enter name: ");
                System.out.flush();
                String name = scanner.nextLine();
                if (name.matches(".*\\d.*")) {
                    System.out.println("Error: Name cannot contain numbers.");
                    continue;
                }

                System.out.print("Enter age: ");
                System.out.flush();
                int age = Integer.parseInt(scanner.nextLine());
                if (age < 18 || age > 100) {
                    System.out.println("Error: Age must be between 18 and 100");
                    continue;
                }

                System.out.print("Enter position: ");
                System.out.flush();
                String position = scanner.nextLine();

                switch (typeChoice) {
                    case "1":
                        System.out.print("Enter monthly salary: ");
                        System.out.flush();
                        double salary = Double.parseDouble(scanner.nextLine());
                        employees.add(new FullTimeEmployee(name, age, position, salary));
                        break;
                    case "2":
                        System.out.print("Enter hourly rate: ");
                        System.out.flush();
                        double rate = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter contract period (months): ");
                        System.out.flush();
                        int months = Integer.parseInt(scanner.nextLine());
                        employees.add(new ContractEmployee(name, age, position, rate, months));
                        break;
                    case "3":
                        System.out.print("Enter university: ");
                        System.out.flush();
                        String uni = scanner.nextLine();
                        employees.add(new Intern(name, age, position, uni));
                        break;
                    case "4":
                        System.out.print("Enter team size: ");
                        System.out.flush();
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

    public static void saveToJson(ArrayList<Employee> employees, String fileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(employees, writer);
            System.out.println("Data successfully saved to " + fileName);
        } catch (IOException e) {
            System.out.println("JSON write error: " + e.getMessage());
        }
    }

    public static void loadFromJson(ArrayList<Employee> employees, String fileName) {
        File file = new File(fileName);
        if (!file.exists()) return;

        Gson gson = new Gson();
        try (FileReader reader = new FileReader(file)) {
            Type listType = new TypeToken<ArrayList<Employee>>() {}.getType();
            ArrayList<Employee> loadedData = gson.fromJson(reader, listType);
            if (loadedData != null) {
                employees.addAll(loadedData);
                System.out.println("Data restored from JSON");
            }
        } catch (Exception e) {
            System.out.println("JSON upload error: " + e.getMessage());
        }
    }
}