package proiect_pao.models;

public class Receptionist extends Employee {
	
	private String clinicName;
	
	public String getclinicName() {
		return clinicName;
	}

	public void setclinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	@Override
    public String toString() {
        return "Client{" +
                "clinicName='" + clinicName + 
                
                '}';
    }
}
