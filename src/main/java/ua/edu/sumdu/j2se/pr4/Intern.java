package ua.edu.sumdu.j2se.pr4;

public class Intern extends Employee {
    private String university;

    public Intern(String name, int age, String position, String university) {
        super(name, age, position);
        this.university = university;
    }

    @Override
    public String toString() {
        return super.toString() + " [Type: Intern, University: " + university + "]";
    }
}