package com.techelevator.items;

public class Sours extends CandyStoreItem{

    public Sours(String sku, String name, boolean hasWrapper, double price){
        super(sku, name,hasWrapper, price);
    }

    @Override
    public String getProductType(){
        return ("Sour Flavored Candies");
    }
}
