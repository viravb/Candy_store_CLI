package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<String,Integer> currentCart = new HashMap<>();

    public void addToCart(String sku, int quantity) {
        if (currentCart.get(sku) != null) {
            quantity+=currentCart.get(sku);
        }
            currentCart.put(sku,quantity);
    }

    public Map<String, Integer> getCurrentCart() {
        return currentCart;
    }
}
