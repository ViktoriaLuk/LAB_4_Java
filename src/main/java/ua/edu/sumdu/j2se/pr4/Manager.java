package ua.edu.sumdu.j2se.pr4;

public class Manager extends Employee {
    private int teamSize;

    public Manager(String name, int age, String position, int teamSize) {
        super(name, age, position);
        this.teamSize = teamSize;
    }

    @Override
    public String toString() {
        return super.toString() + " [Type: Manager, Team Size: " + teamSize + "]";
    }
}