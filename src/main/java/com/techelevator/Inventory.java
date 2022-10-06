package com.techelevator;

import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.items.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Inventory {

    InventoryFileReader inventoryFileReader = new InventoryFileReader();
    private String inventoryFileName = inventoryFileReader.getInventoryFileName();
    private Map<String,Integer> inventoryWithQuantity = new HashMap<String,Integer>();

    CandyStore candyStore = new CandyStore();


    public void populateInventory (Map<String, CandyStoreItem> inventory) throws FileNotFoundException {

        File inventoryFile = new File(inventoryFileName);

        try(Scanner fileReader = new Scanner(inventoryFile)){
            while(fileReader.hasNextLine()){
                String lineFromFile = fileReader.nextLine();
                String[] parts = lineFromFile.split("\\|");
                CandyStoreItem candyFromLine = buildInventoryFromParts(parts);
                inventory.put(parts[1], candyFromLine);

            }

        }

    }


    private CandyStoreItem buildInventoryFromParts(String[] parts) {
        CandyStoreItem candyFromLine = null;

        String category = parts[0];
        String sku = parts[1];
        String name = parts[2];
        double price = Double.parseDouble(parts[3]);
        String hasWrapperString = parts[4];
        boolean hasWrapper = false;

        if (hasWrapperString.equals("T")) {
            hasWrapper = true;
        }

        if (category == "CH") {
            candyFromLine = new Chocolate(sku, name, hasWrapper, price);
        } else if (category == "SR"){
            candyFromLine = new Sours(sku, name, hasWrapper, price);
        } else if(category == "HC") {
            candyFromLine = new HardCandy(sku, name, hasWrapper, price);
        } else if(category == "LI") {
            candyFromLine = new Licorice(sku, name, hasWrapper, price);
        }

        return candyFromLine;
    }

    public void populateQuantities (){
        for(String item: candyStore.getInventoryMap().keySet()){

            inventoryWithQuantity.put(item,100);

        }


    }

}
