package proiect_pao.service;
import proiect_pao.models.*;
import java.util.ArrayList;
import java.util.Arrays;
import repository.ClinicRepository;
import java.util.Scanner;
import repository.*;


public class ClinicService {

    private static ClinicService INSTANCE = null;
    private final ClinicRepository clinicRepository = new ClinicRepository();


    public static synchronized ClinicService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ClinicService();
        }
        return INSTANCE;
    }
    
    public void addClinicFromInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the clinics's name:");
        String name = scan.nextLine();
        System.out.println("Enter the clinics address:");
        String address = scan.nextLine();
        System.out.println("Enter the clinics opening hour:");
        String openingHour = scan.nextLine();
        System.out.println("Enter the clinics closing hour:");
        String closingHour = scan.nextLine();
        Clinic clinic = new Clinic(name, address, openingHour, closingHour);
        addClinic(clinic);
    }
    
    public void addClinic(Clinic clinic) {
        clinicRepository.insertClinicInDatabase(clinic);
    }
    
    private void removeClinic(String name) {
        clinicRepository.removeClinicFromDatabase(name);
    }
    
    public void removeClinicFromInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the clinic's name:");
        String name = scan.nextLine();
        removeClinic(name);
    }
    
    public ArrayList<Clinic> createFirstClinics() {
        Clinic clinic1= new Clinic("clinic01","str. a, nr. 1","10:00","22:00");
        Clinic clinic2= new Clinic("clinic02","str. b, nr. 2","9:00","21:00");
        return new ArrayList<>(Arrays.asList(clinic1,clinic2));
    }
    
    public void addInitialClinics(){
        ArrayList<Clinic> clinics = createFirstClinics();
        for(Clinic l: clinics){
            addClinic(l);
        }
    }
    
    public void modifyClinic(Clinic clinic, String newname){
        clinicRepository.updatename(newname,clinic.getName());
    }

    public void modifyClinicFromInput(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the clinics's name:");
        String name = scan.nextLine();
        System.out.println("Enter the new name for clinic:");
        String newname = scan.nextLine();
        Clinic clinic = clinicRepository.getClinicFromDatabase(name);
        if(clinic == null){
            System.out.println("The clinic is not registered!");
        }
        else {
            modifyClinic(clinic, newname);
        }
    }
}