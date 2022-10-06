package com.techelevator.items;

public class Licorice extends CandyStoreItem {

    public Licorice(String sku, String name, String hasWrapper, double price){
        super(sku, name,hasWrapper, price);
    }

    @Override
    public String getProductType(){
        return ("Licorice and Jellies");
    }
}
