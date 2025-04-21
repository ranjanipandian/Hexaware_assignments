package dao;

import java.sql.*;
import java.util.*;
import entity.*;
import exception.*;
import util.DBConnUtil;

public class ProjectRepositoryImpl implements IProjectRepository {
    Connection conn;

    public ProjectRepositoryImpl() {
        conn = DBConnUtil.getConnection("db.properties");
    }

    @Override
    public boolean createEmployee(Employee emp) {
        String sql = "INSERT INTO Employee(name, designation, gender, salary, projectId) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDesignation());
            ps.setString(3, emp.getGender());
            ps.setDouble(4, emp.getSalary());
            ps.setInt(5, emp.getProjectId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error inserting employee: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean createProject(Project proj) {
        String sql = "INSERT INTO Project(projectName, description, startDate, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, proj.getProjectName());
            ps.setString(2, proj.getDescription());
            ps.setString(3, proj.getStartDate());
            ps.setString(4, proj.getStatus());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error inserting project: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean createTask(Task task) {
        String sql = "INSERT INTO Task(taskName, projectId, employeeId, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, task.getTaskName());
            ps.setInt(2, task.getProjectId());
            ps.setInt(3, task.getEmployeeId());
            ps.setString(4, task.getStatus());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error inserting task: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean assignProjectToEmployee(int projectId, int employeeId) {
        String sql = "UPDATE Employee SET projectId = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, projectId);
            ps.setInt(2, employeeId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error assigning project: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean assignTaskInProjectToEmployee(int taskId, int projectId, int employeeId) {
        String sql = "UPDATE Task SET projectId = ?, employeeId = ? WHERE taskId = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, projectId);
            ps.setInt(2, employeeId);
            ps.setInt(3, taskId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error assigning task: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteEmployee(int empId) {
        String sql = "DELETE FROM Employee WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, empId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteProject(int projectId) {
        String sql = "DELETE FROM Project WHERE projectId = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, projectId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting project: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Task> getAllTasks(int empId, int projectId) {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM Task WHERE employeeId = ? AND projectId = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, empId);
            ps.setInt(2, projectId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Task task = new Task(
                    rs.getInt("taskId"),
                    rs.getString("taskName"),
                    rs.getInt("projectId"),
                    rs.getInt("employeeId"),
                    rs.getString("status")
                );
                tasks.add(task);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching tasks: " + e.getMessage());
        }
        return tasks;
    }
}
