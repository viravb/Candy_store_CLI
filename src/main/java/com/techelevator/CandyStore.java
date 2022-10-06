package com.techelevator;

import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.items.CandyStoreItem;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.TreeMap;

/*
    This class should encapsulate all the functionality of the Candy Store application, meaning it should
    contain all the "work"
 */
public class CandyStore {

    Inventory inventory = new Inventory();

    private  Map<String, CandyStoreItem> inventoryMap = new TreeMap<String, CandyStoreItem>();

    public void initialPopulateInventory() throws FileNotFoundException {
        inventory.populateInventory(inventoryMap);
        inventory.populateQuantities();
    }

    public Map<String, CandyStoreItem> getInventory() {
        return inventoryMap;
    }

    public Map<String, CandyStoreItem> getInventoryMap() {
        return inventoryMap;
    }
}
