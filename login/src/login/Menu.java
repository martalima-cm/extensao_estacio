package login;

import java.util.ArrayList;
import java.util.List;

//Determine list to store any food or drink
public class Menu {
	private List<Food> foods;
	private List<Drink> drinks;
	
	
	//Constructor Menu() class
	public Menu() {
		this.foods = new ArrayList<>();
		this.drinks = new ArrayList<>();
	}

	//Method to add food to list food
	public void addFood(Food food) {
		foods.add(food);
	}
	
	//Method to remove food to list food
	public void removeFood(Food food) {
		foods.remove(food);
	}
	
	//Mehtod to add food to list Drink
	public void addDrink(Drink drink) {
		drinks.add(drink);
	}
	
	//Method to remove drink
	public void removeDrink(Drink drink) {
		drinks.remove(drink);
	}
	
	//Getter for any ArrayList on list food
	public List<Food> getFoods() {
		return foods;
	}
	
	//Getter for any ArrayList on List Drink
	public List<Drink> getDrinks() {
		return drinks;
	}

}

