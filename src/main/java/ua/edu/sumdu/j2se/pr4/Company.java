package ua.edu.sumdu.j2se.pr4;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public String getName() { return name; }

    public List<Employee> findByName(String name) {
        List<Employee> found = new ArrayList<Employee>();
        for (Employee e : employees) {
            if (e.getName().equalsIgnoreCase(name)) {
                found.add(e);
            }
        }
        return found;
    }

    public List<Employee> findByPosition(String position) {
        List<Employee> found = new ArrayList<Employee>();
        for (Employee e : employees) {
            if (e.getPosition().equalsIgnoreCase(position)) {
                found.add(e);
            }
        }
        return found;
    }

    public List<Employee> findByAgeRange(int min, int max) {
        List<Employee> found = new ArrayList<Employee>();
        for (Employee e : employees) {
            if (e.getAge() >= min && e.getAge() <= max) {
                found.add(e);
            }
        }
        return found;
    }
}