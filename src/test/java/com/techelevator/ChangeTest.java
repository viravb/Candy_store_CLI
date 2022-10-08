package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChangeTest {

    private Change target;
    private Change excepted;

    @Before
    public void setup(){
        target = new Change();
        excepted = new Change();
    }

    @Test
    public void change_test_for_999_95(){
        double input = 999.95;
        excepted = new Change(49,1,1,4,3,2,0);
        target.determineChange(input);
        Assert.assertEquals(excepted, target);
    }

    @Test
    public void change_test_for_19_95(){
        double input = 19.95;
        excepted = new Change(0,1,1,4,3,2,0);
        target.determineChange(input);
        Assert.assertEquals(excepted, target);
    }



}
