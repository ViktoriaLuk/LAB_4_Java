package ua.edu.sumdu.j2se.pr4;


public enum Position {
    DEVELOPER,
    MANAGER,
    DESIGNER,
    TESTER,
    UNKNOWN;

    @Override
    public String toString() {
       
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}