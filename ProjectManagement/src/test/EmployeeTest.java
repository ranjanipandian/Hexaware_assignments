package test;

import entity.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class EmployeeTest {

    @Test
    void testEmployeeCreationAndGetters() {
        Employee emp = new Employee(1, "Alice", "Developer", "Female", 50000.0, 101);
        Assertions.assertEquals(1, emp.getId());
        Assertions.assertEquals("Alice", emp.getName());
        Assertions.assertEquals("Developer", emp.getDesignation());
        Assertions.assertEquals("Female", emp.getGender());
        Assertions.assertEquals(50000.0, emp.getSalary());
        Assertions.assertEquals(101, emp.getProjectId());
    }

    @Test
    void testEmployeeSetters() {
        Employee emp = new Employee();
        emp.setId(2);
        emp.setName("Bob");
        emp.setDesignation("Tester");
        emp.setGender("Male");
        emp.setSalary(45000.0);
        emp.setProjectId(102);

        Assertions.assertEquals(2, emp.getId());
        Assertions.assertEquals("Bob", emp.getName());
        Assertions.assertEquals("Tester", emp.getDesignation());
        Assertions.assertEquals("Male", emp.getGender());
        Assertions.assertEquals(45000.0, emp.getSalary());
        Assertions.assertEquals(102, emp.getProjectId());
    }
}
