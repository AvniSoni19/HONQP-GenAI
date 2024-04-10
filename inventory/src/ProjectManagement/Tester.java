package ProjectManagement;
import java.time.LocalDate;
public class Tester {
    public static void main(String[] args) {
        // Create a project
        Project project = new Project("WebAppProject", "Developing a web application", 100000, LocalDate.of(2023, 12, 31));

        // Create a developer
        Developer developer = new Developer("Alice", "Software Engineer", 3);

        // Display project details
        System.out.println("Project Details:");
        System.out.println("Project Name: " + project.getProjectName());
        System.out.println("Project Description: " + project.getProjectDescription());
        System.out.println("Budget: $" + project.getBudget());
        System.out.println("Deadline: " + project.getDeadline());
        System.out.println("Completed: " + (project.isCompleted() ? "Yes" : "No"));
        System.out.println();

        // Display developer details
        System.out.println("Developer Details:");
        System.out.println("Developer Name: " + developer.getName());
        System.out.println("Developer Role: " + developer.getRole());
        System.out.println("Experience Years: " + developer.getExperienceYears() + " years");
        System.out.println();

        // Developer attends a training session
        developer.attendTraining("Java Programming");

        // Mark the project as completed
        project.markAsCompleted();

        // Testing the additional methods

        // Increase project budget
        project.increaseBudget(5000);

        // Extend project deadline
        project.extendProjectDeadline(7);

        // Display project status
        project.displayProjectStatus();

        // Developer requests a vacation
        developer.requestVacation(5);

        // Developer submits a code review
        developer.submitCodeReview("Code changes for feature X.");

        // Developer participates in a team meeting
        developer.participateInTeamMeeting();

        // Display developer performance
        developer.displayPerformance();
    }
}

