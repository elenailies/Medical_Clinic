package proiect_pao.service;

import proiect_pao.models.*;
import java.util.*;

public class service {
    
	 private static List<Clinic> registeredClinics = new ArrayList<>();

	    public void registerClinic(String name, String address) {
	        Clinic clinic = new Clinic();
	        clinic.setName(name);
	        clinic.setAddress(address);
	        registeredClinics.add(clinic);
	    }
	
	    public void removeClinic(){
	    	
	    }
	    public void registerMedicalOffice(){}
	    public void removeMedicalOffice(){}
	    public void registerDoctor(){}
	    public void removeDoctor(){}
	    public void registerReceptionist(){}
	    public void removeReceptionist(){}
	    public void registerAppointment(){}
	    public void removeAppointment(){}
	    public void registerPrescription(){}
	    public void removePrescription(){}
}
