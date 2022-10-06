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

    InventoryFileReader inventoryFileReader = new InventoryFileReader();

    private  Map<String, CandyStoreItem> inventory = new TreeMap<String, CandyStoreItem>();

    public void initialPopulateInventory() throws FileNotFoundException {
        inventoryFileReader.populateInventory(inventory);
    }

    public Map<String, CandyStoreItem> getInventory() {
        return inventory;
    }
}
