package login;

public class Food {
	//For type and mealtime to choose easily
	public enum Type{
		Cafe_da_manha,
		Almoco,
		Jantar
	}
	
	public enum DinnerTime {
		Cafe_da_manha,
		Almoco,
		Jantar
	}
	
	//Determin field of food class
	private Type type;
	private String name;
	private double price;
	private DinnerTime dinnerTime;
	private static int totalPrice;
	
	public Food(Type type, String name, double price, DinnerTime dinnerTime) {
		this.type = type;
		this.name = name;
		this.price = price;
		this.dinnerTime = dinnerTime;
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
	
	public DinnerTime getDinnerTime() {
		return dinnerTime;
	}
	
	public static int getTotalPrice() {
		return totalPrice;
	}
	
	public static void incrementTotalPrice() {
		totalPrice++;
	}
}
	


