package proiect_pao.models;

public class Doctor extends Employee {
	
	private String medicalOfficeName;
	
	public String getmedicalOfficeName() {
		return medicalOfficeName;
	}

	public void setName(String medicalOfficeName) {
		this.medicalOfficeName = medicalOfficeName;
	}
	
	@Override
    public String toString() {
        return "Client{" +
                "medicalOfficeName='" + medicalOfficeName + 
               
                '}';
    }
}
