package login;

public class Drink {
	//Define enum for type to choose easuily
	public enum Type {
		Coca_cola,
		Guarana,
		Fanta
	}
	
	//Private fields
	private Type type;
	private String name;
	private double price;
	private static int totalPrice;
	
	public Drink(Type type, String name, double price) {
		this.type = type;
		this.name = name;
		this.price = price;
	}
	
	//Getters and setters for private fields
	public Type getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public static int getTotalSales() {
		return totalPrice;
	}
	
	public static void incrementTotalPrice() {
		totalPrice++;
	}
	
	
}	
