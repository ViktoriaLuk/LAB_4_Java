package ua.edu.sumdu.j2se.pr4;

public class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int age, String position, double monthlySalary) {
        super(name, age, position);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return super.toString() + " [Type: Full-Time, Monthly Salary: " + monthlySalary + "]";
    }
}