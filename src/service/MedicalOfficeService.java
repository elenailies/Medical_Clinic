package proiect_pao.service;
import proiect_pao.models.*;
import java.util.ArrayList;
import java.util.Arrays;
import repository.MedicalOfficeRepository;
import java.util.Scanner;
import repository.*;


public class MedicalOfficeService {

    private static MedicalOfficeService INSTANCE = null;
    private final MedicalOfficeRepository medicalOfficeRepository = new MedicalOfficeRepository();


    public static synchronized MedicalOfficeService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MedicalOfficeService();
        }
        return INSTANCE;
    }
    
    public void addMedicalOfficeFromInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter medical office name:");
        String name = scan.nextLine();
        System.out.println("Enter medical office address:");
        String clinicName = scan.nextLine();
        
        MedicalOffice medicalOffice = new MedicalOffice(name, clinicName);
        addMedicalOffice(medicalOffice);
    }
    
    public void addMedicalOffice(MedicalOffice medicalOffice) {
    	medicalOfficeRepository.insertMedicalOfficeInDatabase(medicalOffice);
    }
    
    private void removeMedicalOffice(String name) {
    	medicalOfficeRepository.removeMedicalOfficeFromDatabase(name);
    }
    
    public void removeMedicalOfficeFromInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter medical office name:");
        String name = scan.nextLine();
        removeMedicalOffice(name);
    }
    
    public ArrayList<MedicalOffice> createFirstMedicalOffices() {
    	MedicalOffice medicalOffice1= new MedicalOffice("Office01","clinic01");
    	MedicalOffice medicalOffice2= new MedicalOffice("Office02","clinic02");
        return new ArrayList<>(Arrays.asList(medicalOffice1,medicalOffice2));
    }
    
    public void addInitialMedicalOffices(){
        ArrayList<MedicalOffice> medicalOffices = createFirstMedicalOffices();
        for(MedicalOffice l: medicalOffices){
            addMedicalOffice(l);
        }
    }
    
    public void modifyMedicalOffice(MedicalOffice medicalOffice, String newname){
    	medicalOfficeRepository.updatename(newname,medicalOffice.getName());
    }

    public void modifyMedicalOfficeFromInput(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter medical office name:");
        String name = scan.nextLine();
        System.out.println("Enter the new name for the medical office:");
        String newname = scan.nextLine();
        MedicalOffice medicalOffice = medicalOfficeRepository.getMedicalOfficeFromDatabase(name);
        if(medicalOffice == null){
            System.out.println("The nedical office is not registered!");
        }
        else {
            modifyMedicalOffice(medicalOffice, newname);
        }
    }
}