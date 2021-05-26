package proiect_pao.models;

public class Medicine {

private String name;
private String description;
private double price;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	@Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", description=" + description +'\'' +
                 ", price=" + price +
                '}';
    }
	
	public Medicine(String name,String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}

