package test;

import entity.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TaskTest {

    @Test
    void testTaskCreationAndGetters() {
        Task task = new Task(201, "Design Module", 101, 1, "Assigned");
        Assertions.assertEquals(201, task.getTaskId());
        Assertions.assertEquals("Design Module", task.getTaskName());
        Assertions.assertEquals(101, task.getProjectId());
        Assertions.assertEquals(1, task.getEmployeeId());
        Assertions.assertEquals("Assigned", task.getStatus());
    }

    @Test
    void testTaskSetters() {
        Task task = new Task();
        task.setTaskId(202);
        task.setTaskName("Testing Module");
        task.setProjectId(102);
        task.setEmployeeId(2);
        task.setStatus("started");

        Assertions.assertEquals(202, task.getTaskId());
        Assertions.assertEquals("Testing Module", task.getTaskName());
        Assertions.assertEquals(102, task.getProjectId());
        Assertions.assertEquals(2, task.getEmployeeId());
        Assertions.assertEquals("started", task.getStatus());
    }
}
