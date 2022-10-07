package com.techelevator.view;

import com.techelevator.InvalidNumberException;
import com.techelevator.items.CandyStoreItem;

import javax.print.DocFlavor;
import java.util.Map;
import java.util.Scanner;

/*
 * This is the only class that should have any usage of System.out or System.in
 *
 * Usage of System.in or System.out should not appear ANYWHERE else in your code outside of this class.
 *
 * Work to get input from the user or display output to the user should be done in this class, however, it
 * should include no "work" that is the job of the candy store.
 */
public class Menu {

	private static final Scanner in = new Scanner(System.in);

	public void showWelcomeMessage() {
		System.out.println("***************************");
		System.out.println("**     Silver Shamrock   **");
		System.out.println("**      Candy Company    **");
		System.out.println("***************************");
		System.out.println();
	}

	public void showMainMenu() {
		System.out.println("(1) Show Inventory");
		System.out.println("(2) Make Sale");
		System.out.println("(3) Quit");
	}

	public String getMenuSelection() {
		System.out.println("Select your option: ");
		String mainMenuSelectionByUser = in.nextLine();
		return  mainMenuSelectionByUser;
	}

	public void displayInvalidSelection(){
		System.out.println("Please enter a valid selection");
	}

	public void displayInventoryToUser(Map<String, CandyStoreItem> inventoryMap,
									   Map<String, Integer> inventoryWithQuantity){
		System.out.println("Id      Name                Wrapper  Qty      Price");
		for ( CandyStoreItem candy : inventoryMap.values()) {
			System.out.printf("%-8s%-20s%-9s%-9s$%-4.2f \n",
					candy.getSku() , candy.getName() , candy.isHasWrapper(),
					displayQuantity(inventoryWithQuantity.get(candy.getSku())) , candy.getPrice() );
		}

	}

	private String displayQuantity(Integer num){
		if(num>0){
			return Integer.toString(num);
		}else{
			return "SOLD OUT";
		}

	}

	public void displaySubMenu (double balance){
		System.out.println("(1) Take Money");
		System.out.println("(2) Select Products");
		System.out.println("(3) Complete Sale");
		System.out.println("Current Customer Balance: $"+ balance);
	}

	public void displayDesiredAmountToDeposit(){
		System.out.println("How much do you want to deposit?: ");
	}

	public double getAmountToDeposit(){
		double amountToDeposit = 0.00;
		String amountFromCustomer = in.nextLine();
		amountToDeposit = Double.parseDouble(amountFromCustomer);
		return amountToDeposit;
	}

	public void displaySkuSelection(){
		System.out.println("Please enter the SKU of desired candy you would like to purchase: ");
	}

	public String getPurchaseSkuSelection(){
		String selection = in.nextLine();

		return selection;
	}

	public void displayQuantitySelection(){
		System.out.println("Please enter the quantity of desired candy you would like to purchase: ");
	}

	public int getPurchaseQuantitySelection() {
		String selection = in.nextLine();
		int quantity = 0;
		try {
			quantity = Integer.parseInt(selection);
			if(quantity<=0){
				throw new InvalidNumberException();
			}
		} catch (NumberFormatException e) {
			System.out.println("Please enter a number");
		} catch (InvalidNumberException e){
			System.out.println("Please enter a quantity greater than 0");
		}
		return quantity;
	}
}