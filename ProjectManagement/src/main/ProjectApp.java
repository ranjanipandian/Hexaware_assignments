package main;

import java.util.*;
import dao.*;
import entity.*;

public class ProjectApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IProjectRepository repo = new ProjectRepositoryImpl();

        while (true) {
            System.out.println("\n--- Project Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Add Project");
            System.out.println("3. Add Task");
            System.out.println("4. Assign Project to Employee");
            System.out.println("5. Assign Task in Project to Employee");
            System.out.println("6. Delete Employee");
            System.out.println("7. Delete Project");
            System.out.println("8. List Tasks for Employee in Project");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Designation: ");
                        String designation = sc.nextLine();

                        System.out.print("Enter Gender: ");
                        String gender = sc.nextLine();

                        System.out.print("Enter Salary: ");
                        double salary = Double.parseDouble(sc.nextLine());

                        System.out.print("Enter Project ID: ");
                        int projectId = Integer.parseInt(sc.nextLine());

                        Employee emp = new Employee(0, name, designation, gender, salary, projectId);
                        boolean empCreated = repo.createEmployee(emp);
                        System.out.println(empCreated ? "\u2705 Employee added successfully." : "\u274C Failed to add employee.");
                        break;

                    case 2:
                        System.out.print("Enter Project Name: ");
                        String projectName = sc.nextLine();
                        System.out.print("Enter Description: ");
                        String description = sc.nextLine();
                        System.out.print("Enter Start Date (YYYY-MM-DD): ");
                        String startDate = sc.nextLine();
                        System.out.print("Enter Status: ");
                        String status = sc.nextLine();

                        Project proj = new Project(0, projectName, description, startDate, status);
                        boolean projCreated = repo.createProject(proj);
                        System.out.println(projCreated ? "\u2705 Project added successfully." : "\u274C Failed to add project.");
                        break;

                    case 3:
                        try {
                            System.out.print("Enter Task Name: ");
                            String taskName = sc.nextLine();

                            System.out.print("Enter Project ID: ");
                            int taskProjectId = Integer.parseInt(sc.nextLine());

                            System.out.print("Enter Employee ID: ");
                            int taskEmployeeId = Integer.parseInt(sc.nextLine());

                            System.out.print("Enter Status (Assigned / Started / Completed): ");
                            String taskStatus = sc.nextLine();

                            Task task = new Task(0, taskName, taskProjectId, taskEmployeeId, taskStatus);

                            boolean taskCreated = repo.createTask(task);
                            System.out.println(taskCreated ? "\u2705 Task added successfully." : "\u274C Failed to add task.");
                        } catch (NumberFormatException nfe) {
                            System.out.println("\u274C Invalid input. Please enter numeric values for IDs.");
                        } catch (Exception ex) {
                            System.out.println("\u274C Error adding task: " + ex.getMessage());
                        }
                        break;

                    case 4:
                        System.out.print("Enter Project ID: ");
                        int assignProjId = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter Employee ID: ");
                        int assignEmpId = Integer.parseInt(sc.nextLine());

                        boolean assigned = repo.assignProjectToEmployee(assignProjId, assignEmpId);
                        System.out.println(assigned ? "\u2705 Project assigned to employee." : "\u274C Assignment failed.");
                        break;

                    case 5:
                        System.out.print("Enter Task ID: ");
                        int assignTaskId = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter Project ID: ");
                        int assignTaskProjectId = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter Employee ID: ");
                        int assignTaskEmployeeId = Integer.parseInt(sc.nextLine());

                        boolean taskAssigned = repo.assignTaskInProjectToEmployee(assignTaskId, assignTaskProjectId, assignTaskEmployeeId);
                        System.out.println(taskAssigned ? "\u2705 Task assigned in project!" : "\u274C Assignment failed.");
                        break;

                    case 6:
                        System.out.print("Enter Employee ID to delete: ");
                        int deleteEmpId = Integer.parseInt(sc.nextLine());
                        boolean empDeleted = repo.deleteEmployee(deleteEmpId);
                        System.out.println(empDeleted ? "\u2705 Employee deleted." : "\u274C Failed to delete employee.");
                        break;

                    case 7:
                        System.out.print("Enter Project ID to delete: ");
                        int deleteProjId = Integer.parseInt(sc.nextLine());
                        boolean projDeleted = repo.deleteProject(deleteProjId);
                        System.out.println(projDeleted ? "\u2705 Project deleted." : "\u274C Failed to delete project.");
                        break;

                    case 8:
                        System.out.print("Enter Employee ID: ");
                        int empId = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter Project ID: ");
                        int projId = Integer.parseInt(sc.nextLine());

                        List<Task> taskList = repo.getAllTasks(empId, projId);
                        if (taskList.isEmpty()) {
                            System.out.println("No tasks assigned.");
                        } else {
                            System.out.println("Tasks assigned:");
                            for (Task t : taskList) {
                                System.out.println("Task ID: " + t.getTaskId()
                                        + ", Name: " + t.getTaskName()
                                        + ", Status: " + t.getStatus());
                            }
                        }
                        break;

                    case 9:
                        System.out.println("Exiting application. Goodbye!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid option! Try again.");
                }
            } catch (Exception ex) {
                System.out.println("\u2757 Unexpected Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}
