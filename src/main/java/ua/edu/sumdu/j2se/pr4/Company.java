package ua.edu.sumdu.j2se.pr4;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private List<Department> departments = new ArrayList<>(); // Агрегація

    public Company(String name) {
        this.name = name;
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public String getName() { return name; }
}