package com.techelevator.items;

public class HardCandy extends CandyStoreItem{

    public HardCandy(String sku, String name, boolean hasWrapper, double price){
        super(sku, name,hasWrapper, price);
    }

    @Override
    public String getProductType(){
        return ("Hard Tack Confectionery");
    }
}
