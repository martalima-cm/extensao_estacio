package login;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Customer {
	 //Define totalcustomer to refer id for new customers
	private static int totalCustomer = 0;
	private int id;
	private String firstName;
	private String lastName;
	private List<Order> orders;
	
	
	//Constructor for new customer 
	public Customer(String firstName, String lastName) {
		this.id = ++totalCustomer;
		this.firstName = firstName;
		this.lastName = lastName;
		this.orders = new ArrayList<>();
		
	}
	
	//Methos to place an order for any new customer
	public void placeOrder(Menu mn, Food food, Drink drink) {
		Order order = new Order(food, drink);
		orders.add(order);
		double totalPrice = 0;
		totalPrice += order.getPrice();
		Account.getInstance().recordSale(getFullName() + " placed an order: \n" + order.toString(), totalPrice);
		createReceipt(order);
	}
	
	//Methos to create a recipt for the customer
	private void createReceipt(Order order) {
		double totalPrice = order.getPrice();
		String receiptContent = "Customer: " + getFullName() + "\n"
			+ "Order details: \n" + "----------------------------------\n" + order.toString() + "\n---------------------" + "\n"
					+ "Total Price: " + totalPrice + "\n"
					+ "Date and Time: " + java.time.LocalDateTime.now();
		
		System.out.println("Receipt created for " + getFullName() + ":\n" + receiptContent);
		
		 //Save receipt
		String fileName = getFullName() + "_Receipt.txt";
		saveToFile(fileName, receiptContent);
	}
	
	//Give message to user create receipt
	private void saveToFile(String fileName, String content) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
			writer.println(content);
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("                *************** Receipt file saved successfuly: " + fileName +"    ");
			System.out.println("-----------------------------------------------------------------------------------");
		} catch (IOException e) {
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.println("                *************** Error to saving recipt, sorry: " + e.getMessage() +"   ");
			System.out.println("---------------------------------------------------------------------------------------");
	}
}

	//Method to view customer information
	public void viewInfo() {
		System.out.println("Customer information: ");
		System.out.println("ID: " + id);
		System.out.println("Name: " + getFullName());
		System.out.println("Total Orders: " + orders.size());
	}
	
	//Mehtod to get full name to use any moment
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	//Get id when use id for print
	public int getId() {
		return id;
	}
	
	//For total order when view information
	public int getTotalOrders() {
		return orders.size();
	}
	
	//For display order list
	public List<Order> getOrders() {
		return orders;
	}
	
	//Method to get total number of customers
	public static int getTotalCustomers() {
		return totalCustomer;
	}
}
