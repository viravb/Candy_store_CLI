package com.techelevator;

import com.techelevator.exceptions.InvalidNumberException;
import com.techelevator.exceptions.InvalidSkuSelectedException;
import com.techelevator.items.CandyStoreItem;

import java.io.FileNotFoundException;
import java.util.Map;

/*
    This class should encapsulate all the functionality of the Candy Store application, meaning it should
    contain all the "work"
 */
public class CandyStore {

    Account account = new Account();
    Inventory inventory = new Inventory();
    private Map<String,Integer> inventoryWithQuantity;
    private Map<String, CandyStoreItem> inventoryWithProperties;

    public void initialPopulateInventory() throws FileNotFoundException {
        this.inventoryWithProperties = inventory.populateInventory();
        this.inventoryWithQuantity = inventory.populateQuantities();
    }

    public double accountBalance(){
        return account.getBalance();
    }

    public Map<String, Integer> getInventoryWithQuantity() {
        return inventoryWithQuantity;
    }
    public Map<String, CandyStoreItem> getInventoryWithProperties() {
        return inventoryWithProperties;
    }

    public void takeMoney(double amount) throws InvalidNumberException {
        account.deposit(amount);
    }

    public void selectProductsProcess(String sku, int quantityToBePurchased) throws InvalidNumberException, InvalidSkuSelectedException {
        if(inventoryWithProperties.containsKey(sku)) {
            int currentlyInStock = inventoryWithQuantity.get(sku);
            double purchaseAmount = inventoryWithProperties.get(sku).getPrice() * quantityToBePurchased;

            if (currentlyInStock >= quantityToBePurchased) {
                if(purchaseAmount <= account.getBalance()){
                    removeFromInventory(sku, quantityToBePurchased);
                    account.withdraw(purchaseAmount);
                } else {
                    throw new InvalidNumberException("Not enough funds to complete purchase");
                }
            } else{
                throw new InvalidNumberException("Not enough quantity in stock for your selection");
            }
        } else{
            throw new InvalidSkuSelectedException("Please Enter In a Valid Sku");
        }

    }

    private void removeFromInventory(String sku, int amountToRemove){
        int currentlyInStock = inventoryWithQuantity.get(sku);
        int newQuantity = currentlyInStock - amountToRemove;

        inventoryWithQuantity.put(sku,newQuantity);

    }
}
