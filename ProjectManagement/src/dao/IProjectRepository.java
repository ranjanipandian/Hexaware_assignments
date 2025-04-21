package dao;

import java.util.List;
import entity.Employee;
import entity.Project;
import entity.Task;

public interface IProjectRepository {
    boolean createEmployee(Employee emp);
    boolean createProject(Project proj);
    boolean createTask(Task task);
    boolean assignProjectToEmployee(int projectId, int employeeId);
    boolean assignTaskInProjectToEmployee(int taskId, int projectId, int employeeId);
    boolean deleteEmployee(int empId);
    boolean deleteProject(int projectId);
    List<Task> getAllTasks(int empId, int projectId);
}
