package login;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Account {
	//Instance for sigleton account class
	private static Account instance = null;
	private List<String> salesData;
	private double totalSellingPrice;
	
	//Private constructor to prevent instantiation the class
	private Account() {
		this.salesData = new ArrayList<>();
		this.totalSellingPrice = 0.0;
	}
	
	//Check if class have instance use static method to get the singleton instance
	public static Account getInstance() {
		if (instance == null) {
			instance = new Account();
		}
		return instance;
	}
	
	 //Method to record sales data
	public void recordSale(String saleInfo, double price) {
		salesData.add(saleInfo);
		totalSellingPrice += price;
	}
	
	//Method to generate a receipt file with custom name
	public void generateReceipt(String fileName) {
		try(PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
			//Write sale information to arraylist
			for (String saleInfo : saleData) {
				writer.print(saleInfo);
			}
			
			//Format to correctly write on the file
			writer.print("\n----------------------------");
			writer.print("Total Selling Price: " + totalSellingPrice);
			
			//Local time on file with time localdatetime
			writer.print("Date and time: " + java.time.LocalDateTime.now());
			System.out.println("----------------------------------------------------------------------------------------------------------");
			System.out.println("           ************* Total selling price bell generated successfully. File name: " + fileName + "     ");
			System.out.println("----------------------------------------------------------------------------------------------------------");
			
			//Throw exception
		} catch (IOException e) {
			System.out.println("----------------------------------------------------------------------------------------------------------");
			System.out.println("           ************* Error generating receipt file: " + e.getMessage() + "                            ");
			System.out.println("----------------------------------------------------------------------------------------------------------");
		}
	}
	
	//Getter for get total selling price to refer main class
	public double getTotalSellingPrice() {
		return totalSellingPrice;
	}
	
}
