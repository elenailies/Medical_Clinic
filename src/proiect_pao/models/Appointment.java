package proiect_pao.models;

public class Appointment {
	private Customer c;
	
	public Customer getCustomer() {
		return c;
	}

	public void setCustomer(Customer c) {
		this.c = c;
	}

	private Doctor m;
	
	public Doctor getDoctor() {
		return m;
	}

	public void setDoctor(Doctor m) {
		this.m = m;
	}
	
	private String date;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	private String hour;
	
	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}
	
	private Receptionist r;
	
	public Receptionist getReceptionist() {
		return r;
	}

	public void setReceptionist(Receptionist r) {
		this.r = r;
	}
	
	@Override
    public String toString() {
        return "Client{" +
                "doctor='" + m + '\'' +
                "customer='" + c + '\'' +
                "receptionist='" + r + '\'' +
                "date='" + date + '\'' +
                "hour='" + hour + 
               
                '}';
    }
}
