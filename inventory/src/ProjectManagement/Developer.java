package ProjectManagement;

import Bankmanagement.Account;

public class Developer {
    private String name;
    private String role;
    private int experienceYears;
    private Developer developer;
    private String developerId;
    private static int counter = 001;

    public Developer(String name, String role, int experienceYears) {
        this.name = name;
        this.role = role;
        this.experienceYears = experienceYears;
    }

    // Getter methods for encapsulation
    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public int getExperienceYears() {
        return experienceYears;
    }
    public String generateTransactionId() {
        this.developerId = this.name.substring(0, 3).toUpperCase() + ++Developer.counter;
        return this.developerId;
    }

    // Method to attend a training session
    public void attendTraining(String topic) {
        System.out.println(name + " is attending a training session on " + topic);
        // Additional logic for attending a training session...
    }

    // Method to request a vacation
    public void requestVacation(int days) {
        System.out.println(name + " has requested a vacation for " + days + " days.");
        if(days>0 && days<=10)
            System.out.println("Vacation of " + days + " is approved. Enjoy your holiday");
        else {
            System.out.println("Contact a higher authority");
        }
    }

    // Method to submit a code review
    public void submitCodeReview(String code) {
        System.out.println(name + " has submitted a code review.");
    }

    // Method to participate in a team meeting
    public void participateInTeamMeeting() {
        System.out.println(name + " is participating in a team meeting.");
    }

    // Method to display developer performance
    public void displayPerformance() {
        System.out.println();
        System.out.println("Developer Performance:");
        System.out.println("Developer Name: " + name);
        System.out.println("id "+ generateTransactionId());

        System.out.println("Role: " + role);
        System.out.println("Experience Years: " + experienceYears + " years");
        // Additional logic for displaying performance...
    }
}
