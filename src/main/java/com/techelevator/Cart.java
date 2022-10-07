package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<String,Integer> currentCart = new HashMap<>();

    public void addToCart(String sku, int quantity){
        currentCart.put(sku, quantity);
    }

    public Map<String, Integer> getCurrentCart() {
        return currentCart;
    }
}
