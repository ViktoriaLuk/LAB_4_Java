package ua.edu.sumdu.j2se.pr4;

import java.util.Objects;

public class Employee {
    private String name;
    private int age;
    private String position;

    public Employee(String name, int age, String position) {
        if (age < 18 || age > 100) throw new IllegalArgumentException("Age must be between 18 and 100");
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPosition() { return position; }

    @Override
    public String toString() {
        return String.format("Employee{name='%s', age=%d, position='%s'}", name, age, position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}