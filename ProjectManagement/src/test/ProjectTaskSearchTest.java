package test;

import dao.ProjectRepositoryImpl;
import entity.Employee;
import entity.Project;
import entity.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class ProjectTaskSearchTest {

    @Test
    void testGetAllTasksAssignedToEmployee() {
        ProjectRepositoryImpl repo = new ProjectRepositoryImpl();

        // Setup: Add dummy data
        Employee emp = new Employee(10, "TestUser", "Developer", "Other", 60000.0, 200);
        Project proj = new Project(200, "Test Project", "Sample", "2024-01-01", "started");
        Task task = new Task(300, "Build UI", 200, 10, "Assigned");

        repo.createEmployee(emp);
        repo.createProject(proj);
        repo.createTask(task);

        List<Task> tasks = repo.getAllTasks(10, 200);
        Assertions.assertNotNull(tasks);
        Assertions.assertFalse(tasks.isEmpty());
        Assertions.assertEquals("Build UI", tasks.get(0).getTaskName());
    }
}
