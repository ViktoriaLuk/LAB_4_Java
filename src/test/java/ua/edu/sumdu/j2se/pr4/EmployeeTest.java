package ua.edu.sumdu.j2se.pr4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @Test
    public void testEmployeeCreation() {
        // Тепер замість "Developer" пишемо Position.DEVELOPER
        Employee employee = new Employee("Vika", 20, 25000.0, Position.DEVELOPER);
        
        assertEquals("Vika", employee.getName());
        assertEquals(Position.DEVELOPER, employee.getPosition());
    }

    @Test
    public void testStaticCount() {
        int initialCount = Employee.getCount();
        new Employee("Test1", 25, 30000.0, Position.MANAGER);
        new Employee("Test2", 30, 35000.0, Position.DESIGNER);
        
        // Перевіряємо, що лічильник збільшився на 2
        assertEquals(initialCount + 2, Employee.getCount());
    }

    @Test
    public void testCopyConstructor() {
        Employee original = new Employee("Original", 22, 20000.0, Position.TESTER);
        Employee copy = new Employee(original); // Використовуємо конструктор копіювання
        
        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getPosition(), copy.getPosition());
    }
}