package ua.edu.sumdu.j2se.pr4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @Test
    public void testFullTimeEmployeeCreation() {
        FullTimeEmployee ft = new FullTimeEmployee("Vika", 20, "Staff", 15000.0);
        assertEquals("Vika", ft.getName());
        assertEquals(20, ft.getAge());
        assertTrue(ft.toString().contains("Full-Time"));
    }

    @Test
    public void testContractEmployeeCreation() {
        ContractEmployee ct = new ContractEmployee("Ira", 25, "Contractor", 500.0, 6);
        assertEquals("Ira", ct.getName());
        assertEquals(25, ct.getAge());
        assertTrue(ct.toString().contains("Contract"));
    }

    @Test
    public void testPolymorphismInArray() {
        Employee ft = new FullTimeEmployee("Oleg", 30, "Staff", 20000.0);
        Employee ct = new ContractEmployee("Max", 22, "Contractor", 400.0, 12);
        
        assertNotNull(ft);
        assertNotNull(ct);
        // Перевірка, що toString() викликає перевизначені методи підкласів
        assertTrue(ft.toString().contains("Monthly Salary"));
        assertTrue(ct.toString().contains("Hourly Rate"));
    }

    @Test
    public void testInvalidAge() {
        assertThrows(IllegalArgumentException.class, () -> {
            new FullTimeEmployee("Ivan", 15, "Staff", 10000.0);
        });
    }
}