package proiect_pao.models;

public class Employee {
	
	private String name;
		
		public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;
		}

		@Override
	    public String toString() {
	        return "Client{" +
	                "name='" + name + 
	                '}';
	    }
}
