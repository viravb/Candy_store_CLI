package com.techelevator.view;

import com.techelevator.items.CandyStoreItem;

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
			System.out.println( candy.getSku() + candy.getName() + candy.isHasWrapper() + inventoryWithQuantity.get(candy.getSku()) + "$" + candy.getPrice() );
		}

		}
}