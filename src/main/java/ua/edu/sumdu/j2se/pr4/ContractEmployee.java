package ua.edu.sumdu.j2se.pr4;

public class ContractEmployee extends Employee {
    private double hourlyRate;
    private int contractPeriodMonths;

    public ContractEmployee(String name, int age, String position, double hourlyRate, int months) {
        super(name, age, position);
        this.hourlyRate = hourlyRate;
        this.contractPeriodMonths = months;
    }

    @Override
    public String toString() {
        return super.toString() + " [Type: Contract, Hourly Rate: " + hourlyRate + ", Period: " + contractPeriodMonths + "m]";
    }
}