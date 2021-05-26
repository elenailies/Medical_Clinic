package proiect_pao.service;
import proiect_pao.models.*;
import java.util.ArrayList;
import java.util.Arrays;
import repository.MedicineRepository;
import java.util.Scanner;
import repository.*;


public class MedicineService {

    private static MedicineService INSTANCE = null;
    private final MedicineRepository medicineRepository = new MedicineRepository();


    public static synchronized MedicineService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MedicineService();
        }
        return INSTANCE;
    }
    
    public void addMedicineFromInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the medicine's name:");
        String name = scan.nextLine();
        System.out.println("Enter the medicine's description:");
        String description = scan.nextLine();
        System.out.println("Enter the medicine's price:");
        double price = scan.nextDouble();
        
        Medicine medicine = new Medicine(name, description, price);
        addMedicine(medicine);
    }
    
    public void addMedicine(Medicine medicine) {
    	medicineRepository.insertMedicineInDatabase(medicine);
    }
    
    private void removeMedicine(String name) {
    	medicineRepository.removeMedicineFromDatabase(name);
    }
    
    public void removeMedicineFromInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the medicine's name:");
        String name = scan.nextLine();
        removeMedicine(name);
    }
    
    public ArrayList<Medicine> createFirstMedicines() {
    	Medicine medicine1= new Medicine("medicine01","descriere 1",54.4);
    	Medicine medicine2= new Medicine("medicine02","descriere 2",35.6);
        return new ArrayList<>(Arrays.asList(medicine1,medicine2));
    }
    
    public void addInitialMedicines(){
        ArrayList<Medicine> medicines = createFirstMedicines();
        for(Medicine l: medicines){
            addMedicine(l);
        }
    }
    
    public void modifyMedicine(Medicine medicine, double newprice){
    	medicineRepository.updatename(newprice,medicine.getName());
    }

    public void modifyMedicineFromInput(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the medicine's name:");
        String name = scan.nextLine();
        System.out.println("Enter the new price for medicine:");
        double newprice = scan.nextDouble();
        Medicine medicine = medicineRepository.getMedicineFromDatabase(name);
        if(medicine == null){
            System.out.println("The medicine is not registered!");
        }
        else {
            modifyMedicine(medicine, newprice);
        }
    }
}