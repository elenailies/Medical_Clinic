package proiect_pao.models;

public class Customer {
	
	private String firstName;
	private String lastName;
	private Number age;
	private String gender;
	private Number weight;
	private Number height;
	
	
	public String getfirstName() {
		return firstName;
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getlastName() {
		return lastName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getgender() {
		return gender;
	}
	public void setgender(String gender) {
		this.gender = gender;
	}
	
	public Number getage() {
		return age;
	}
	public void setage(Number age) {
		this.age = age;
	}
	
	public Number getweight() {
		return weight;
	}
	public void setweight(Number weight) {
		this.weight = weight;
	}
	
	public Number getheight() {
		return height;
	}
	public void setheight(Number height) {
		this.height = height;
	}
	
	    
	 @Override
	public String toString() {
		 return "Customer{" + 
				 	"firstName='" + firstName + 
				 	"lastName='" + lastName + 
				 	"gender='" + gender + 
				 	"age='" + age + 
				 	"height='" + height + 
				 	"weight='" + weight + 
				 '}';
	 }
}
