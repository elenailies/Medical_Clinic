package Menu;
import config.DatabaseSetup;
import proiect_pao.service.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
    private static ClinicService clinicService;
    private static DoctorService doctorService;
    private static MedicalOfficeService medicalOfficeService;
    private static MedicineService medicineService;
    private static DatabaseSetup databaseSetup;

    private static int ClinicOptions(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add a clinic;");
        System.out.println("2. Remove a clinic;");
        System.out.println("3. Modify a clinic's name;");
        System.out.println("Choose one of the above options:");
        return scanner.nextInt();
    }
    
    private static int DoctorOptions(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add a doctor;");
        System.out.println("2. Remove a doctor;");
        System.out.println("3. Modify a doctor's clinic (transfer a doctor);");
        System.out.println("Choose one of the above options:");
        return scanner.nextInt();
    }
    
    private static int MedicalOfficeOptions(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add a madical office;");
        System.out.println("2. Remove a medical office;");
        System.out.println("3. Modify a medical office;");
        System.out.println("Choose one of the above options:");
        return scanner.nextInt();
    }
    
    private static int MedicineOptions(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add a madicine;");
        System.out.println("2. Remove a medicine;");
        System.out.println("3. Modify a medicine;");
        System.out.println("Choose one of the above options:");
        return scanner.nextInt();
    }
 
    private static int Options() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Options for clinics");
        System.out.println("2. Options for doctors");
        System.out.println("3. Options for medical offices");
        System.out.println("4. Options for medicine");
        System.out.println("5. End program");
        System.out.println("Choose one of the above options:");
        return scanner.nextInt();
    }

    private static void initialise(){
    	
        databaseSetup = new DatabaseSetup();
        clinicService = ClinicService.getInstance();
        doctorService = DoctorService.getInstance();
        medicineService = MedicineService.getInstance();
        medicalOfficeService = MedicalOfficeService.getInstance();
    }

    public static void ClinicsMenu(){
        int opt = ClinicOptions();
        if (opt == 1) {
            clinicService.addClinicFromInput();
         
        }
        if (opt == 2) {
            clinicService.removeClinicFromInput();
         
        }
        if (opt == 3) {
            clinicService.modifyClinicFromInput();
         
        }
        
    }
    
    public static void MedicalOfficesMenu(){
        int opt = MedicalOfficeOptions();
        if (opt == 1) {
            medicalOfficeService.addMedicalOfficeFromInput();
         
        }
        if (opt == 2) {
        	medicalOfficeService.removeMedicalOfficeFromInput();
         
        }
        if (opt == 3) {
        	medicalOfficeService.modifyMedicalOfficeFromInput();
         
        }
        
    }
    
    public static void DoctorsMenu(){
        int opt = DoctorOptions();
        if (opt == 1) {
            doctorService.addDoctorFromInput();
         
        }
        if (opt == 2) {
            doctorService.removeDoctorFromInput();
         
        }
        if (opt == 3) {
            doctorService.modifyDoctorFromInput();
         
        }
        
    }
    
    public static void MedicinesMenu(){
        int opt = MedicineOptions();
        if (opt == 1) {
            medicineService.addMedicineFromInput();
         
        }
        if (opt == 2) {
            medicineService.removeMedicineFromInput();
         
        }
        if (opt == 3) {
            medicineService.modifyMedicineFromInput();
         
        }
        
    }


    public static void startApp(){
        Scanner scan = new Scanner(System.in);
        initialise();
        clinicService.addInitialClinics();
        doctorService.addInitialDoctors();
        medicineService.addInitialMedicines();
        medicalOfficeService.addInitialMedicalOffices();
        databaseSetup.setUp();
        try {
            int opt = Options();
            while (opt != -1) {
                if (opt == 0) {
                    opt = Options();
                }
                if (opt == 1) {
                    ClinicsMenu();
                }
                if (opt == 2) {
                    DoctorsMenu();
                }
                if (opt == 3) {
                    MedicalOfficesMenu();
                }
                if (opt == 4) {
                    MedicinesMenu();
                }
                if(opt == 5){
                
                    break;
                }
                if (opt < 0 || opt > 4) {
                    System.out.println("The entered option is invalid!");
                }

                System.out.print("Write the word 'next' to continue . . . \n");
                String aux = scan.nextLine();
                while (!aux.equals("next"))
                {
                    System.out.print("Write the word 'next' to continue!\n");
                    aux = scan.nextLine();
                }
                opt = 0;
            }
        }

        catch (InputMismatchException exception) {
            System.out.println("Invalid input! You have to enter a number");
        }

    }

}