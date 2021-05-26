package proiect_pao.models;

public class Employee {
	
	protected String firstName;
	protected String lastName;
		
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

		@Override
	    public String toString() {
	        return "Employee{" +
	                "firstName='" + firstName + 
	                "lastName='" + lastName + 
	                '}';
	    }
}
