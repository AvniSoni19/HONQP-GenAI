package ProjectManagement;
import java.time.LocalDate;


public class Project {
    private String projectName;
    private String projectDescription;
    private double budget;
    private LocalDate deadline;
    private boolean completed;

    public Project(String projectName, String projectDescription, double budget, LocalDate deadline) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.budget = budget;
        this.deadline = deadline;
        this.completed = false;
    }

    // Getter methods for encapsulation
    public String getProjectName() {
        return projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public double getBudget() {
        return budget;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public boolean isCompleted() {
        return completed;
    }

    // Method to mark the project as completed
    public void markAsCompleted() {
        completed = true;
        System.out.println("Project '" + projectName + "' marked as completed.");
    }

    // Method to increase project budget
    public void increaseBudget(double amount) {
        if (amount > 0) {
            budget += amount;
            System.out.println("Budget increased by $" + amount + ". New budget: $" + budget);
        } else {
            System.out.println("Invalid amount for budget increase. Please provide a positive value.");
        }
    }

    // Method to extend project deadline
    public void extendProjectDeadline(int days) {
        if (days > 0) {
            deadline = deadline.plusDays(days);
            System.out.println("Deadline extended by " + days + " days. New deadline: " + deadline);
        } else {
            System.out.println("Invalid number of days for deadline extension. Please provide a positive value.");
        }
    }

    // Method to display project status
    public void displayProjectStatus() {
        System.out.println();
        System.out.println("Project Status:");
        System.out.println("Project Name: " + projectName);
        System.out.println("Completed: " + (completed ? "Yes" : "No"));
        System.out.println("Budget: $" + budget);
        System.out.println("Deadline: " + deadline);
    }
}
