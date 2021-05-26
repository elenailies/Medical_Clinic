package proiect_pao.service;
import proiect_pao.models.*;
import java.util.ArrayList;
import java.util.Arrays;
import repository.DoctorRepository;
import java.util.Scanner;
import repository.*;


public class DoctorService {

    private static DoctorService INSTANCE = null;
    private final DoctorRepository doctorRepository = new DoctorRepository();


    public static synchronized DoctorService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DoctorService();
        }
        return INSTANCE;
    }
    
    public void addDoctorFromInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the doctor's first name:");
        String firstName = scan.nextLine();
        System.out.println("Enter the doctor's last name:");
        String lastName = scan.nextLine();
        System.out.println("Enter the doctor's medical office:");
        String medicalOfficeName = scan.nextLine();
        System.out.println("Enter the doctors clinic:");
        String clinicName = scan.nextLine();
        Doctor doctor = new Doctor(firstName, lastName, medicalOfficeName, clinicName);
        addDoctor(doctor);
    }
    
    public void addDoctor(Doctor doctor) {
        doctorRepository.insertDoctorInDatabase(doctor);
    }
    
    private void removeClinic(String name) {
        doctorRepository.removeDoctorFromDatabase(name);
    }
    
    public void removeDoctorFromInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the doctor's last name:");
        String lastName = scan.nextLine();
        removeClinic(lastName);
    }
    
    public ArrayList<Doctor> createFirstDoctors() {
        Doctor doctor1= new Doctor("a","aa","office a","clinic01");
        Doctor doctor2= new Doctor("b","bb","office b","clinic01");
        return new ArrayList<>(Arrays.asList(doctor1,doctor2));
    }
    
    public void addInitialDoctors(){
        ArrayList<Doctor> doctors = createFirstDoctors();
        for(Doctor l: doctors){
            addDoctor(l);
        }
    }
    
    public void modifyDoctor(Doctor doctor, String newclinicName){
        doctorRepository.updatename(newclinicName,doctor.getlastName());
    }

    public void modifyDoctorFromInput(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the doctors's last name:");
        String lastName = scan.nextLine();
        System.out.println("Enter the name of the new clinic:");
        String newclinicName = scan.nextLine();
        Doctor doctor = doctorRepository.getDoctorFromDatabase(lastName);
        if(doctor == null){
            System.out.println("The doctor is not registered!");
        }
        else {
            modifyDoctor(doctor, newclinicName);
        }
    }
}