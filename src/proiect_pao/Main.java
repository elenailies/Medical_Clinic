package proiect_pao;
import proiect_pao.service.service;
import proiect_pao.models.*;


public class Main {
	
	private static Clinic CreateInitClinics()
	{
		Clinic clinic = new Clinic();
		csvSingleton singl = csvSingleton.getInstance();
		
		return clinic;
	
	}
	 public static void main (String[] args) {
		 
		 service s = new service();

	     s.registerClinic("Clinica 1", "Judetul a, Localitatea b, Str. x, nr 26");
	     service.printClinics();
	 }
}
