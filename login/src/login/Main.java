package login;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Add, remove and show *********************************************************************
    private static List<Customer> customers = new ArrayList<>();
    private static Scanner s = new Scanner(System.in);
    private static Menu mn = new Menu();

    //giving welcome *********************************************************************
       public static void main(String[] args) {
            showMenu();
            System.out.println("------------------------------------------------------------------------------\n");
            System.out.println("           *********** Welcome to Marmitex Management                         \n");
           System.out.println("------------------------------------------------------------------------------\n");
    }

    //User choose *********************************************************************
    private static void showMenu() {
        System.out.println("\n Please make your best choice below:\n");
        System.out.println("1. Menu");
        System.out.println("2. Account");
        System.out.println("3. Customer");
        System.out.println("4. Quit");

        int sectionChoice = s.nextInt();
        s.nextLine();

        switch (sectionChoice) {
            case 1:
                handleMenuSection();
                break;
            case 2:
                handleAccountSection();
                break;
            case 3:
                handleCustomerSection();
                break;
            case 4:
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("           *********** Leaving the program. May the force be with you         ");
                System.out.println("------------------------------------------------------------------------------");
                break;
            default:
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("           *********** There seems to be nothing here for you. Look better    ");
                System.out.println("------------------------------------------------------------------------------");
        }
    }


    //Menu section *********************************************************************
    private static void handleMenuSection() {
        System.out.println("\n Please make your best choice below:\n");
        System.out.println("1. List menu");
        System.out.println("2. Add food");
        System.out.println("3. Add drink");
        System.out.println("4. Remove food");
        System.out.println("5. Remove Drink");
        System.out.println("6. Take me back to the beginning");

        int mnChoice = s.nextInt();
        s.nextLine();

        switch (mnChoice) {
            case 1:
                listMenu();
                break;
            case 2:
                addFood();
                break;
            case 3:
                addDrink();
                break;
            case 4:
                removeFood();
                break;
            case 5:
                removeDrink();
                break;
            case 6:
                showMenu();
                break;
            default:
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("           *********** There seems to be nothing here for you. Look better    ");
                System.out.println("------------------------------------------------------------------------------");
                handleMenuSection();
        }
    }

    //list of all menu *********************************************************************
    private static void listMenu() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("List of all foods:\n");
        for (Food food : mn.getFoods()) {
            System.out.println("Type: " + food.getType()
                + ", Name: " + food.getName()
                    + ", Price: " + food.getPrice()
                    + ", Meal Time: " + food.getDinnerTime());
        }

        System.out.println("\nList of all Drinks:\n");
        for (Drink drink : mn.getDrinks()) {
            System.out.println("Type " + drink.getType()
                + ", Name: " + drink.getName()
                    + ", Price: " + drink.getPrice());
        }
        System.out.println("------------------------------------------------------------------------------");

        handleMenuSection();
    }

    // Select the food according to the time ***********************************************************
    private static void addFood() {
        System.out.println("#Select the food according to the time: ");
        String foodName = s.nextLine();

        System.out.println("\n Select the Marmita:");
        System.out.println("1. Café da manha");
        System.out.println("2. Almoço");
        System.out.println("3. Jantar");
        System.out.println("# Enter the number for Food Type: ");


        int foodTypeChoice = s.nextInt();
        s.nextLine();

        Food.Type foodType;
        switch (foodTypeChoice) {
            case 1:
                foodType = Food.Type.Cafe_da_manha;
                break;
            case 2:
                foodType = Food.Type.Almoco;
                break;
            case 3:
                foodType = Food.Type.Jantar;
                break;
            default:
                //Invalid
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("           *********** Invalid. Failure to Café da Manhã   ");
                System.out.println("------------------------------------------------------------------------------");

                foodType = Food.Type.Cafe_da_manha;
                break;
        }

        //Price of the food *********************************************************************
        System.out.println("# Enter the price of the food: ");
        double foodPrice = s.nextDouble();
        s.nextLine();

        System.out.println("# Enter the price of the food: ");
        System.out.println("1. Café da manha");
        System.out.println("2. Almoco");
        System.out.println("3. Jantar");
        System.out.println("# Enter the number for Meal Time: ");

        int dinnerTimeChoice = s.nextInt();
        s.nextLine();

        Food.DinnerTime dinnerTime;
        switch (dinnerTimeChoice) {
            case 1:
                dinnerTime = Food.DinnerTime.Cafe_da_manha;
                break;
            case 2:
                dinnerTime = Food.DinnerTime.Almoco;
                break;
            case 3:
                dinnerTime = Food.DinnerTime.Jantar;
                break;
            default:
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("           *********** Invalid. Failure to Almoço   ");
                System.out.println("------------------------------------------------------------------------------");

                dinnerTime = Food.DinnerTime.Cafe_da_manha;
                break;
        }

        //New food *********************************************************************
        Food newFood = new Food(foodType, foodName, foodPrice, dinnerTime);
        mn.addFood(newFood);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("           *********** Food successfully added. Be happy!  ");
        System.out.println("------------------------------------------------------------------------------");

        handleMenuSection();
    }

    //ADD DRINK *********************************************************************
    private static void addDrink() {
           Scanner s = new Scanner(System.in);

           //Select the drink
        System.out.println("# Enter the name of the drink: ");
        String drinkName = s.nextLine();

        System.out.println("# Enter the price of the drink: ");
        double drinkPrice = s.nextDouble();
        s.nextLine();

        System.out.println("\nSelect the Drink Type: ");
        System.out.println("1. Coca cola");
        System.out.println("2. Guarana");
        System.out.println("3. Fanta");
        System.out.println("# Enter the number for Drink Type: ");

        int drinkTypeChoice = s.nextInt();
        s.nextLine();

        Drink.Type drinkType;
        switch (drinkTypeChoice) {
            case 1:
                drinkType = Drink.Type.Coca_cola;
                break;
            case 2:
                drinkType = Drink.Type.Guarana;
                break;
            case 3:
                drinkType = Drink.Type.Fanta;
                break;
            default:
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("           *********** Invalid choice. Failed for Coca cola  ");
                System.out.println("------------------------------------------------------------------------------");

                drinkType = Drink.Type.Coca_cola;
                break;
        }

        Drink drink = new Drink(drinkType, drinkName, drinkPrice);
        mn.addDrink(drink);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("           *********** Food successfully added. Be happy!  ");
        System.out.println("------------------------------------------------------------------------------");

        handleMenuSection();
    }

    //First show list of available food or drinks ************************************************************
    private static void removeFood() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("List of Food:\n");
        for (Food food : mn.getFoods()) {
            System.out.println(food.getName());
        }
        System.out.println("------------------------------------------------------------------------------");

        //Given food or drink name from user ************************************************************
        Scanner s = new Scanner(System.in);
        System.out.println("\n# Enter the name of the food to remove: ");
        String foodName = s.nextLine();

        //Choose food or drink from the menu list with the help of for each and .equal() *******************
        boolean found = false;
        for (Food food : mn.getFoods()) {
            if (food.getName().equals(foodName)) {
                mn.removeFood(food);
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("                   ******* " + foodName + " removed from the menu             ");
                System.out.println("------------------------------------------------------------------------------");
                found = true;
                break;
            }
        }

        //NOT FOUND TRY AGAIN
        if (!found) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("                   ******* No food with the name of " + foodName + "          ");
            System.out.println("------------------------------------------------------------------------------");
        }
        handleMenuSection();
    }

    //remove drink *******************************************************************************************
    private static void removeDrink() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("List of Drinks: \n");
        for (Drink drink : mn.getDrinks()) {
            System.out.println(drink.getName());
        }
        System.out.println("------------------------------------------------------------------------------");

        Scanner s = new Scanner(System.in);
        System.out.println("# Enter the name of the drink to remove: ");
        String drinkName = s.nextLine();

        boolean found = false;
        for (Drink drink : mn.getDrinks()) {
            if (drink.getName().equals(drinkName)) {
                mn.removeDrink(drink);
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("                   ******* " + drinkName + "removed from the menu             ");
                System.out.println("------------------------------------------------------------------------------");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("                   ******* No Drink found with the name of " + drinkName + "  ");
            System.out.println("------------------------------------------------------------------------------");
        }

        handleMenuSection();
    }

    //Referring to section 2 called Account *******************************************************************
    private static void handleAccountSection() {
        System.out.println("\n Please choose your section:\n");
        System.out.println("1. Show total selling price");
        System.out.println("2. Generate total selling price bell with custom name");
        System.out.println("3. Back to main menu\n");

        int accountChoice = s.nextInt();
        s.nextLine();

        switch (accountChoice) {
            case 1:
                showTotalPrice();
                break;
            case 2:
                generateTotalPrice();
                break;
            case 3:
                showMenu();
                break;
            default:
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("           *********** invalid choice. Make the right choice next time  ");
                System.out.println("------------------------------------------------------------------------------");

                handleAccountSection();
        }
    }

    //TOTAL SELLING ***************************************************
    private static void showTotalPrice() {
           Account accountInstance = Account.getInstance();
           double totalSellingPrice = accountInstance.getTotalSellingPrice();
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("           *********** Total Selling Price: " + totalSellingPrice + "         ");
        System.out.println("------------------------------------------------------------------------------");

        //After displaying, go back to the account section
        handleAccountSection();
    }

    //Show total selling price but generate file with printWriter ********************************************
    private static void generateTotalPrice() {
        Scanner s = new Scanner(System.in);

        System.out.println("# Enter a custom name for the total selling price bell");
        String customName = s.nextLine();

        Account accountInstance = Account.getInstance();
        double totalSellingPrice = accountInstance.getTotalSellingPrice();

        String fileName = customName + "_TotalSellingPrice.txt";
        accountInstance.generateReceipt(fileName);

        handleAccountSection();
    }

    private static void handleCustomerSection() {
        System.out.println("\n Please choose your section:");
        System.out.println("1. List all customers");
        System.out.println("2. Add customer");
        System.out.println("3. Remove customer");
        System.out.println("4. Order product with customer id");
        System.out.println("5. Show customer info by id");
        System.out.println("6. Generate customer order bell by id");
        System.out.println("7. Back to menu\n");

        //CUSTOMER CHOICE *************************************************************************************
        int customerChoice = s.nextInt();
        s.nextLine();

        switch (customerChoice) {
            case 1:
                listAllCustomer();
                break;
            case 2:
                addCustomer();
                break;
            case 3:
                removeCustomer();
                break;
            case 4:
                orderProductCustomerID();
                break;
            case 5:
                showCustomerInfoID();
                break;
            case 6:
                generateCustomerPriceID();
                break;
            case 7:
                showMenu();
                break;
            default:
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("           *********** invalid choice. Choose a valid magic command ");
                System.out.println("------------------------------------------------------------------------------");
                handleCustomerSection();
        }
    }

    private static void listAllCustomer() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("List of all Customer:\n");

        if (customers.isEmpty()) {
            System.out.println("******NO FOUND, SORRY :( *****");
            System.out.println("----------------------------------------------------------------------------");
        } else {
            for (Customer customer : customers) {
                System.out.println("Customer ID: " + customer.getId());
                System.out.println("Name: " + customer.getFullName());
                System.out.println("Total Orders: " + customer.getTotalOrders());
                System.out.println("-------------------------------------------------------------------");
            }
            System.out.println("------------------------------------------------------------------------------");
        }

        handleCustomerSection();
    }

    //Add new customer just get first and last name after specify id ********************************************
    private static void addCustomer() {
        System.out.println("# Enter customer first name: ");
        String firstName = s.next();

        System.out.println("# Enter customer last name: ");
        String lastName = s.next();

        Customer newCustomer = new Customer(firstName, lastName);
        customers.add(newCustomer);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("           *********** Customer successfully added. It’s a pleasure  ");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("           *********** Customer ID: " + newCustomer.getId() + "               ");
        System.out.println("------------------------------------------------------------------------------");
    }

    private static void removeCustomer() {
        System.out.println("# Enter the customer ID to remove: ");

        int customerId = s.nextInt();
        s.nextLine();

        boolean removed = customers.removeIf(customer -> customer.getId() == customerId);

        if(removed) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("           *********** Customer removed successfully                          ");
            System.out.println("------------------------------------------------------------------------------");
        } else {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("           *********** Customer not found with ID: " + customerId + "         ");
            System.out.println("------------------------------------------------------------------------------");
        }

        handleCustomerSection();

    }

    //Get order from customer with customer id after
    private static void orderProductCustomerID() {
        System.out.println("# Enter customer ID: ");

        int customerId = s.nextInt();
        Customer customer = findCustomerId(customerId);

        if (customer != null) {
            System.out.println("# Enter food name: ");
            String foodName = s.next();

            System.out.println("# Enter drink name: ");
            String drinkName = s.next();

            Food food = getFoodName(foodName);
            Drink drink = getDrinkName(drinkName);

            customer.placeOrder(mn, food, drink);
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("           *********** Order placed successfully                              ");
            System.out.println("------------------------------------------------------------------------------");
        } else {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("           *********** Customer with ID " + customerId + " not found, sorry   ");
            System.out.println("------------------------------------------------------------------------------");
        }

        handleCustomerSection();
    }

    //Help to orderProductCustomerID() to find customer
    private static Customer findCustomerId(int customerId) {
           for (Customer customer : customers) {
               if (customer.getId() == customerId) {
                   return customer;
               }
           }
           return null;
    }

    //Help to orderProductCustomerID() to find given food
    private static Food getFoodName(String foodName) {
           for (Food food : mn.getFoods()) {
               if (food.getName().equalsIgnoreCase(foodName)) {
                   return food;
               }
           }
           return null;
    }


    // getFoodName but send drinks data :)
    private static Drink getDrinkName(String drinkName) {
           for (Drink drink : mn.getDrinks()) {
               if (drink.getName().equalsIgnoreCase(drinkName)) {
                   return drink;
               }
           }
           return null;
    }

    //Find customer with ID
    private static void showCustomerInfoID() {
        System.out.println("# Enter the customer ID: ");

        int customerId = s.nextInt();
        s.nextLine();

        Customer foundCustomer = findCustomerId(customerId);

        if (foundCustomer != null) {
            foundCustomer.viewInfo();
        } else {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("           *********** Customer with ID " + customerId + " not found, sorry   ");
            System.out.println("------------------------------------------------------------------------------");
        }

        handleCustomerSection();
    }

    // Generate a file name using customer name
    private static void generateCustomerPriceID() {
        System.out.println("# Enter Customer ID: ");

        int customerId = s.nextInt();

        Customer customer = findCustomerId(customerId);

        if(customer != null) {
        	
            String fileName = customer.getFullName() + "_" + customer.getId() + "_OrderPrice.txt";
            List<Order> orders = customer.getOrders();

             //Order details to the file with writePrinter
            try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
                for (Order order : orders) {
                    writer.println("Customer: " + customer.getFullName() + "\n");
                    writer.println("Order Details: ");
                    writer.println("--------------------------------------------");
                    writer.println(order.toString());
                    writer.println("--------------------------------------------");
                    writer.println("Total price: " + order.getPrice());
                    writer.println("Date and Time: " + java.time.LocalDateTime.now());
                    writer.println("\n");
                }

                System.out.println("-------------------------------------------------------------------------------------------");
                System.out.println("           *********** Order bell file generated successfully. Be happy: " + fileName + "  ");
                System.out.println("-------------------------------------------------------------------------------------------");

                //If file in correct destination throw exception failed message
            } catch (IOException e) {
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("           *********** Error generating order bell file: " + e.getMessage() + "   ");
                System.out.println("------------------------------------------------------------------------------");
            }
        } else {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("           *********** Customer with ID " + customerId + " not found          ");
            System.out.println("------------------------------------------------------------------------------");
        }

        handleCustomerSection();
    }


}
