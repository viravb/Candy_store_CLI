package com.techelevator.items;

import com.techelevator.CandyStore;

import java.util.Objects;

/*
    This represents a single catering item in the system

    This is an abstract class that should be used as a superclass for the items.
 */
public abstract class CandyStoreItem {

    private String sku ;
    private String name;
    private String hasWrapper;
    private double price;

    public CandyStoreItem(String sku, String name, String hasWrapper, double price){
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

    public String isHasWrapper() {
        return hasWrapper;
    }


    public double getPrice() {
        return price;
    }

    public abstract String getProductType();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandyStoreItem that = (CandyStoreItem) o;
        return Double.compare(that.price, price) == 0 && Objects.equals(sku, that.sku) && Objects.equals(name, that.name) && Objects.equals(hasWrapper, that.hasWrapper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, name, hasWrapper, price);
    }
}
