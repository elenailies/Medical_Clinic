package proiect_pao.models;

public class Doctor extends Employee {
	
	private String medicalOfficeName;
	private String clinicName;

	
	
	public String getmedicalOfficeName() {
		return medicalOfficeName;
	}

	public void setmedicalOfficeName(String medicalOfficeName) {
		this.medicalOfficeName = medicalOfficeName;
	}
	
	public String getclinicName() {
		return clinicName;
	}

	public void setclinicName(String clinicName) {
		this.clinicName = clinicName;
	}
	
	@Override
    public String toString() {
        return "Doctor{" +
                "medicalOfficeName='" + medicalOfficeName + 
                "clinicName='" + clinicName + 
              
                '}';
    }
	
	public Doctor(String firstName,String lastName, String medicalOfficeName, String clinicName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.medicalOfficeName = medicalOfficeName;
        this.clinicName = clinicName;
    }
}