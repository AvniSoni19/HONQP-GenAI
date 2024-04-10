package Hospitalmanagement;
import java.util.ArrayList;

public class Patient {
    private String name;
    private int age;
    private String address;
    private boolean insurance;
    private ArrayList<String> facilitiesUsed;
    private double totalBill;
    private Patient patient;

    private String email; // Add email field
    private String patientId;
    private static int counter = 001;



    public Patient(String name, int age, String address, boolean insurance, String email) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.insurance = insurance;
        this.email = email; // Initialize the email field
        this.facilitiesUsed = new ArrayList<>();
        this.totalBill = 0.0;
    }
    public void generatePatientId(){
        this.patientId=this.name.substring(0,3).toUpperCase()+ ++Patient.counter;
    }


    public boolean isValidPatient() {
        // Validate email
        if (email != null && email.endsWith("@gmail.com")) {
            // Validate age
            if (age > 0 && age < 120) {
                // Add your additional validation condition here
                // For example, if you want to check if the address is not empty:
                if (address != null && !address.isEmpty()) {
                    return true; // All conditions are met, the patient is valid
                }
            }
        }
        return false; // Any condition is not met, the patient is not valid
    }

    public void calculateBill() {
        for (String facility : facilitiesUsed) {
            if (facility.equals("X-Ray")) {
                totalBill += 100.0;
            } else if (facility.equals("MRI")) {
                totalBill += 200.0;
            }
        }

    }

    public void addFacility(String facilityName, double cost) {
        facilitiesUsed.add(facilityName);
        totalBill += cost;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public boolean hasInsurance() {
        return insurance;
    }

    public double getTotalBill() {
        return totalBill;
    }
    public String getPatientId() {
        return patientId;
    }

}
