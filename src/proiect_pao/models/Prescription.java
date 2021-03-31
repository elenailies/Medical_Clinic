package proiect_pao.models;

import java.util.List;


public class Prescription {
	
	private List<Medicine> Medicines;

    public List<Medicine> Medicines() {
        return Medicines;
    }

    public void setMedicaments(List<Medicine> Medicines) {
        this.Medicines = Medicines;
    }

}