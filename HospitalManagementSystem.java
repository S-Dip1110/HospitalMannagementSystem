 import java.util.ArrayList;
 import java.util.Scanner;
 
 class Patient {
     private int id;
     private String name;
     private int age;
     private String disease;
 
     public Patient(int id, String name, int age, String disease) {
         this.id = id;
         this.name = name;
         this.age = age;
         this.disease = disease;
     }
 
     public int getId() {
         return id;
     }
 
     public String getName() {
         return name;
     }
 
     public int getAge() {
         return age;
     }
 
     public String getDisease() {
         return disease;
     }
 
     public void displayPatient() {
         System.out.println("\nPatient ID: " + id);
         System.out.println("Name: " + name);
         System.out.println("Age: " + age);
         System.out.println("Disease: " + disease);
     }
 }
 
 public class HospitalManagementSystem {
     static ArrayList<Patient> patients = new ArrayList<>();
     static Scanner scanner = new Scanner(System.in);
     static int patientIdCounter = 1;
 
     public static void main(String[] args) {
         while (true) {
             System.out.println("\n--- Hospital Management System ---");
             System.out.println("1. Add Patient");
             System.out.println("2. View All Patients");
             System.out.println("3. Delete Patient");
             System.out.println("4. Exit");
             System.out.print("Choose an option: ");
 
             int choice = scanner.nextInt();
             scanner.nextLine();
 
             switch (choice) {
                 case 1:
                     addPatient();
                     break;
                 case 2:
                     viewPatients();
                     break;
                 case 3:
                     deletePatient();
                     break;
                 case 4:
                     System.out.println("Exiting the system. Goodbye!");
                     System.exit(0);
                 default:
                     System.out.println("Invalid option. Please try again.");
             }
         }
     }
 
     public static void addPatient() {
         System.out.print("Enter patient name: ");
         String name = scanner.nextLine();
 
         System.out.print("Enter patient age: ");
         int age = scanner.nextInt();
         scanner.nextLine();
 
         System.out.print("Enter patient disease: ");
         String disease = scanner.nextLine();
 
         Patient newPatient = new Patient(patientIdCounter++, name, age, disease);
         patients.add(newPatient);
         System.out.println("Patient added successfully.");
     }
 
     public static void viewPatients() {
         if (patients.isEmpty()) {
             System.out.println("No patients found.");
             return;
         }
 
         System.out.println("\n--- List of Patients ---");
         for (Patient patient : patients) {
             patient.displayPatient();
         }
     }
 
     public static void deletePatient() {
         System.out.print("Enter the Patient ID to delete: ");
         int id = scanner.nextInt();
         scanner.nextLine();
 
         boolean removed = false;
         for (int i = 0; i < patients.size(); i++) {
             if (patients.get(i).getId() == id) {
                 patients.remove(i);
                 removed = true;
                 System.out.println("Patient record deleted successfully.");
                 break;
             }
         }
 
         if (!removed) {
             System.out.println("Patient with ID " + id + " not found.");
         }
     }
 }