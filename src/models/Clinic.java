package proiect_pao.models;

public class Clinic {
	
private String name;
private String address;
private String openingHour;
private String closingHour;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getopeningHour() {
		return openingHour;
	}

	public void setopeningHour(String openingHour) {
		this.openingHour = openingHour;
	}
	
	public String getclosingHour() {
		return closingHour;
	}

	public void setclosingHour(String closingHour) {
		this.closingHour = closingHour;
	}
	@Override
    public String toString() {
        return "Clinic{" +
                "name='" + name + '\'' +
                ", address=" + address +
                "openingHour='" + openingHour + 
                  "closingHour='" + closingHour + 
                '}';
    }
	
	public Clinic(String name,String address, String openingHour, String closingHour) {
        this.name = name;
        this.address = address;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }
	

}
