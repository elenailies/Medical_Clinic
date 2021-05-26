package proiect_pao.models;

import java.util.List;


public class Prescription {
	
	private List<Medicine> Medicines;
	private String checkUpDate;

    public List<Medicine> getMedicines() {
        return Medicines;
    }
    public void setMedicaments(List<Medicine> Medicines) {
        this.Medicines = Medicines;
    }
    
    public String getcheckUpDate() {
        return checkUpDate;
    }
    public void setcheckUpDate(String checkUpDate) {
        this.checkUpDate = checkUpDate;
    }

}