package ua.edu.sumdu.j2se.pr4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Налаштування кодування для коректного виводу в консоль
        System.out.println("Лук'яніхіна Вікторія, група ІН-31.1");
        System.out.println("Лабораторна робота №6: Агрегація, статика та Enum");
        
        Scanner scanner = new Scanner(System.in);
        Company myCompany = new Company("MyIT");
        Department devDept = new Department("Development");
        myCompany.addDepartment(devDept);

        while (true) {
            System.out.println("\n1. Create Employee");
            System.out.println("2. Show All");
            System.out.println("3. Exit");
            System.out.print("> ");
            
            String choice = scanner.nextLine();

            if (choice.equals("3")) break;

            if (choice.equals("1")) {
                try {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    if (age < 18 || age > 100) {
                        System.out.println("Error: Age must be between 18 and 100");
                        continue;
                    }

                    System.out.print("Enter salary: ");
                    double salary = Double.parseDouble(scanner.nextLine());
                    if (salary < 0) {
                        System.out.println("Error: Salary cannot be negative");
                        continue;
                    }

                    System.out.println("Select position (1. DEVELOPER, 2. MANAGER, 3. DESIGNER, 4. TESTER): ");
                    int posChoice = Integer.parseInt(scanner.nextLine());
                    Position pos;
                    switch (posChoice) {
                        case 1 -> pos = Position.DEVELOPER;
                        case 2 -> pos = Position.MANAGER;
                        case 3 -> pos = Position.DESIGNER;
                        case 4 -> pos = Position.TESTER;
                        default -> pos = Position.UNKNOWN;
                    }

                    Employee emp = new Employee(name, age, salary, pos);
                    devDept.addEmployee(emp);
                    System.out.println("Success: Employee added!");

                } catch (NumberFormatException e) {
                    System.out.println("Error: Please enter a valid number.");
                }
            } else if (choice.equals("2")) {
                System.out.println("\n--- List of Employees ---");
                for (Employee e : devDept.getEmployees()) {
                    System.out.println(e);
                }
                System.out.println("Total count (static): " + Employee.getCount());
            }
        }
        scanner.close();
        System.out.println("Program finished.");
    }
}