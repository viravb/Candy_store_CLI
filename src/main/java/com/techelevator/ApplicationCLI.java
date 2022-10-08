package com.techelevator;

import com.techelevator.exceptions.InvalidNumberException;
import com.techelevator.exceptions.InvalidSkuSelectedException;
import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * This class should control the workflow of the application, but not do any other work
 * 
 * The menu class should communicate with the user, but do no other work
 * 
 * This class should control the logical workflow of the application, but it should do no other
 * work.  It should communicate with the user (System.in and System.out) using the Menu class and ask
 * the CandyStore class to do any work and pass the results between those 2 classes.
 */
public class ApplicationCLI {

	/*
	 * The menu class is instantiated in the main() method at the bottom of this file.  
	 * It is the only class instantiated in the starter code.  
	 * You will need to instantiate all other classes using the new keyword before you can use them.
	 * 
	 * Remember every class and data structure is a data types and can be passed as arguments to methods or constructors.
	 */

	private Menu menu;
	CandyStore candyStore = new CandyStore();

	public ApplicationCLI(Menu menu) throws IOException {
		this.menu = menu;
	}

	/*
	 * Your application starts here
	 */
	public void run() throws IOException {

		candyStore.initialPopulateInventory();
		menu.showWelcomeMessage();
		menuSelectionProcess();

			/*


			Display the Starting Menu and get the users choice.
			Remember all uses of System.out and System.in should be in the menu
			
			IF the User Choice is Show Inventory,
				THEN show the candy store items for sale
			ELSE IF the User's Choice is Make Sale,
				THEN go to the make sale menu
			ELSE IF the User's Choice is Quit
				THEN break the loop so the application stops
			*/

	}

	private void menuSelectionProcess() throws IOException {
		while(true){
			menu.showMainMenu();
			String selection = menu.getMenuSelection();
			if(selection.equals("1")){
				menu.displayInventoryToUser(candyStore.getInventoryWithProperties(), candyStore.getInventoryWithQuantity());
			}else if(selection.equals("2")){
					subMenuSelectionProcess();
			} else if (selection.equals("3")){
				break;
			} else{
				menu.displayInvalidSelection();
			}
		}

	}

	/*
	 * This starts the application, but you shouldn't need to change it.  
	 */
	public static void main(String[] args) throws IOException {
		Menu menu = new Menu();
		ApplicationCLI cli = new ApplicationCLI(menu);
		cli.run();
	}

	private void subMenuSelectionProcess() throws IOException {
		while (true) {
			menu.displaySubMenu(candyStore.accountBalance());
			String menuSelection = menu.getMenuSelection();

			if (menuSelection.equals("1")) {
				try {
					menu.displayDesiredAmountToDeposit();
					double depositAmount = menu.getAmountToDeposit();
					candyStore.takeMoney(depositAmount);
				} catch (InvalidNumberException e){
					menu.showExceptionMessage(e);
				} catch (IOException e){
					menu.showExceptionMessage(e);
				}
			} else if (menuSelection.equals("2")) {
				subMenuSelectionProcessSelection2();
			} else if (menuSelection.equals("3")) {
				candyStore.makeChange();
				menu.displayReceipt(candyStore.getCart(), candyStore.getInventoryWithProperties(),
						candyStore.getTotalCost(), candyStore.getBalance(), candyStore.getChangeObject());
				candyStore.totalSystemReport();
				candyStore.reset();
				break;
			} else {
				menu.displayInvalidSelection();
			}
		}
	}

	private void subMenuSelectionProcessSelection2 () throws IOException{
		String skuSelection = "";
		int quantitySelection = 0;

		menu.displayInventoryToUser(candyStore.getInventoryWithProperties(),candyStore.getInventoryWithQuantity());
		menu.displaySkuSelection();
		skuSelection = menu.getPurchaseSkuSelection();
		menu.displayQuantitySelection();


		quantitySelection = getPurchaseQuantitySelection(menu.getPurchaseSkuSelection());

		try {
			candyStore.selectProductsProcess(skuSelection, quantitySelection);
		} catch ( InvalidNumberException e){
			menu.showExceptionMessage(e);
		} catch ( InvalidSkuSelectedException e){
			menu.showExceptionMessage(e);
		}
	}


	private int getPurchaseQuantitySelection(String selection) {
		int quantity = 0;
		try {
			quantity = Integer.parseInt(selection);
			if(quantity<=0){
				throw new InvalidNumberException("Please enter a quantity greater than 0");
			}
		} catch (NumberFormatException e) {
			menu.showNumberFormatException();
		} catch (InvalidNumberException e){
			menu.showExceptionMessage(e);
		}
		return quantity;
	}

}
