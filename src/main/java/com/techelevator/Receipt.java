package com.techelevator;

import com.techelevator.items.CandyStoreItem;

import java.util.HashMap;
import java.util.Map;

public class Receipt {
    Map<String,Integer> finalCart = new HashMap<>();
    private double totalCost = 0.0;

    public Receipt(Map<String,Integer> finalCart) {
        this.finalCart = finalCart;
    }

    public Map<String, Integer> getFinalCart() {
        return finalCart;
    }

    public double getTotalCost(Map<String, CandyStoreItem> inventoryWProperties) {
        for(String sku : finalCart.keySet()){
            totalCost+= ((inventoryWProperties.get(sku).getPrice())*finalCart.get(sku));
        }
        return totalCost;
    }

}
