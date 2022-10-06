package com.techelevator.filereader;

import com.techelevator.items.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

/*
    This class should contain any and all details of access to the inventory file
 */
public class InventoryFileReader {

    private String inventoryFileName = "inventory.csv";

    public String getInventoryFileName() {
        return inventoryFileName;
    }
}
