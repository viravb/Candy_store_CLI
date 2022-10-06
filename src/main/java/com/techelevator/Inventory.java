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

    private  Map<String, CandyStoreItem> inventoryProperties = new TreeMap<>();
    private Map<String,Integer> inventoryWithQuantity = new HashMap<>();



    public Map<String, CandyStoreItem> populateInventory () throws FileNotFoundException {

        File inventoryFile = new File(inventoryFileName);

        try(Scanner fileReader = new Scanner(inventoryFile)){
            while(fileReader.hasNextLine()){
                String lineFromFile = fileReader.nextLine();
                String[] parts = lineFromFile.split("\\|");
                CandyStoreItem candyFromLine = buildInventoryFromParts(parts);
                inventoryProperties.put(parts[1], candyFromLine);
            }
        }
        return inventoryProperties;
    }


    public CandyStoreItem buildInventoryFromParts(String[] parts) {
        CandyStoreItem candyFromLine = null;

        String category = parts[0];
        String sku = parts[1];
        String name = parts[2];
        double price = Double.parseDouble(parts[3]);
        String hasWrapperString = parts[4];
        String hasWrapper ="N";


        if (hasWrapperString.equals("T")) {
            hasWrapper = "Y";
        }

        if (category.equals("CH")) {
            candyFromLine = new Chocolate(sku, name, hasWrapper, price);
        } else if (category.equals("SR")){
            candyFromLine = new Sours(sku, name, hasWrapper, price);
        } else if(category.equals("HC")){
            candyFromLine = new HardCandy(sku, name, hasWrapper, price);
        } else if(category.equals("LI")) {
            candyFromLine = new Licorice(sku, name, hasWrapper, price);
        }

        return candyFromLine;
    }

    public Map<String,Integer> populateQuantities (){
        for(String item: inventoryProperties.keySet()){
            inventoryWithQuantity.put(item,100);
        }
        return inventoryWithQuantity;
    }

}
