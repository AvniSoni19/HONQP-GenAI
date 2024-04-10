package Hospitalmanagement;
public class Tester {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Patient patient1 = new Patient("Ayush Singh", 30, "123 abc St", true, "shiv@gmail.com");

        hospital.admitPatient(patient1);

        if (patient1.isValidPatient()) {
            System.out.println("Patient information is valid.");
        } else {
            System.out.println("Patient information is invalid.");
        }

        hospital.provideFacility(patient1, "X-Ray", 100.0);
        hospital.provideFacility(patient1, "MRI", 200.0);

        patient1.calculateBill();

        // Generate the patient ID and print it
        patient1.generatePatientId();
        System.out.println("Generated ID for " + patient1.getName() + ": " + patient1.getPatientId());

        System.out.println("Total bill for " + patient1.getName() + ": Rs" + patient1.getTotalBill());
    }
}
