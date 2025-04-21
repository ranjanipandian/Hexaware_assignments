package test;

import dao.ProjectRepositoryImpl;
import exception.EmployeeNotFoundException;
import exception.ProjectNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ExceptionTest {

    @Test
    void testEmployeeNotFoundExceptionThrown() {
        ProjectRepositoryImpl repo = new ProjectRepositoryImpl();
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> {
            repo.assignProjectToEmployee(101, 999); // Assuming 999 doesn't exist
        });
    }

    @Test
    void testProjectNotFoundExceptionThrown() {
        ProjectRepositoryImpl repo = new ProjectRepositoryImpl();
        Assertions.assertThrows(ProjectNotFoundException.class, () -> {
            repo.assignProjectToEmployee(999, 1); // Assuming 999 project doesn't exist
        });
    }
}
