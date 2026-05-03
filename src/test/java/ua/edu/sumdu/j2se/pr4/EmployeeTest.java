package ua.edu.sumdu.j2se.pr4;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class EmployeeTest {

    @Test
    void shouldThrowExceptionWhenInvalidConstructorData() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Employee("", 10, -100, "Intern");
        });
    }

    @Test
    void shouldThrowExceptionWhenInvalidSalaryInSetter() {
        Employee emp = new Employee("Viktoria", 20, 1000, "Dev");
        assertThrows(IllegalArgumentException.class, () -> {
            emp.setSalary(-500);
        });
    }
}