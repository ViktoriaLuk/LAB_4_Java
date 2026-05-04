package ua.edu.sumdu.j2se.pr4;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees = new ArrayList<>(); // Агрегація

    public Department(String name) {
        this.name = name;
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public List<Employee> getEmployees() { return employees; }
    public String getName() { return name; }
}