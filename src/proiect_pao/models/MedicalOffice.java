public class MedicalOffice {
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
    
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
                "name='" + name + '\'' +
                ", clinicName=" + clinicName +
                '}';
    }

}
