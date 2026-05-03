package ua.edu.sumdu.j2se.pr4;

import java.util.Objects;

public class Employee {

    private String name;
    private int age;
    private double salary;
    private String position;

    public Employee(String name, int age, double salary, String position) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < 18 || age > 100) {
            throw new IllegalArgumentException("Age must be between 18 and 100");
        }
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        if (position == null || position.trim().isEmpty()) {
            throw new IllegalArgumentException("Position cannot be empty");
        }
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18 || age > 100) {
            throw new IllegalArgumentException("Too young or invalid age");
        }
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Invalid salary");
        }
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (position == null || position.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid position");
        }
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + ", position='" + position + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name) &&
                Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary, position);
    }
}