package ua.edu.sumdu.j2se.pr4;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @Test
    void shouldThrowExceptionWhenInvalidSalary() {

        Employee employee =
                new Employee(
                        "Anna",
                        20,
                        10000,
                        "Manager"
                );

        assertThrows(
                IllegalArgumentException.class,
                () -> employee.setSalary(-1)
        );
    }

    @Test
    void shouldThrowExceptionWhenInvalidConstructor() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Employee(
                        "",
                        -5,
                        -100,
                        ""
                )
        );
    }
}