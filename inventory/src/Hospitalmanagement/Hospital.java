package Hospitalmanagement;
import java.util.ArrayList;

public class Hospital {
    private ArrayList<Patient> patients;

    public Hospital() {
        patients = new ArrayList<>();
    }

    public void admitPatient(Patient patient) {
        patients.add(patient);
    }

    public void provideFacility(Patient patient, String facilityName, double cost) {
        if (patients.contains(patient)) {
            patient.addFacility(facilityName, cost);
        } else {
            System.out.println("Patient not admitted to the hospital.");
        }
    }
}
