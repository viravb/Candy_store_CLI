package com.techelevator.items;

import com.techelevator.CandyStore;

/*
    This represents a single catering item in the system

    This is an abstract class that should be used as a superclass for the items.
 */
public abstract class CandyStoreItem {

    private String sku ;
    private String name;
    private boolean hasWrapper;
    private int quantity = 100;
    private double price;

    public CandyStoreItem(String sku, String name, boolean hasWrapper, double price){
        this.sku = sku;
        this.name = name;
        this.hasWrapper = hasWrapper;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public boolean isHasWrapper() {
        return hasWrapper;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getProductType();

}
