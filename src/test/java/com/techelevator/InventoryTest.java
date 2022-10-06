package com.techelevator;

import com.techelevator.items.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InventoryTest {

    public Inventory target;

    @Before
    public void setup(){
        target = new Inventory();
    }

    @Test
    public void build_inventory_chocolate(){
        String [] input = {"CH","C1", "Chocolate Bites", "1.10","T"};
        CandyStoreItem expected = new Chocolate("C1","Chocolate Bites", "Y", 1.10 );
        CandyStoreItem actual = target.buildInventoryFromParts(input);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void build_inventory_sours(){
        String [] input = {"SR","S1", "Gummy Ants", "0.10","F"};
        CandyStoreItem expected = new Sours("S1","Gummy Ants", "N", 0.10 );
        CandyStoreItem actual = target.buildInventoryFromParts(input);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void build_inventory_hard_candy(){
        String [] input = {"HC","H1", "Jolly Cowboy", "2.35","T"};
        CandyStoreItem expected = new HardCandy("H1","Jolly Cowboy", "Y", 2.35 );
        CandyStoreItem actual = target.buildInventoryFromParts(input);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void build_inventory_licorice(){
        String [] input = {"LI","L1", "Dracula Pillar", "1.15","F"};
        CandyStoreItem expected = new Licorice("L1","Dracula Pillar", "N", 1.15 );
        CandyStoreItem actual = target.buildInventoryFromParts(input);
        Assert.assertEquals(expected,actual);
    }

}
