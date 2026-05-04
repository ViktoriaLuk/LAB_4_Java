package ua.edu.sumdu.j2se.pr4;

public class Employee {
    private String name;
    private int age;
    private double salary;
    private Position position; // Використовуємо enum
    private static int count = 0; // Статичне поле

    public Employee(String name, int age, double salary, Position position) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
        count++; // Збільшуємо лічильник при створенні
    }

    // Конструктор копіювання
    public Employee(Employee other) {
        this(other.name, other.age, other.salary, other.position);
    }

    public static int getCount() {
        return count;
    }

    public String getName() { return name; }
    public Position getPosition() { return position; }

    @Override
public String toString() {
    return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + ", position='" + position + "'}";
  }
}