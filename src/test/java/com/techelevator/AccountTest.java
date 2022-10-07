package com.techelevator;

import com.techelevator.exceptions.InvalidNumberException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {

    private Account target;

    @Before
    public void setup(){
        target = new Account();
    }

    @Test
    public void deposit_100_test() throws InvalidNumberException {
        double expected = 100;
        target.deposit(100);
        Assert.assertEquals(expected, target.getBalance(),.009);
    }

    @Test
    public void deposit_101_test() throws InvalidNumberException {
        double expected = 0;
        target.deposit(101);
        Assert.assertEquals(expected, target.getBalance(),.009);
    }

    @Test
    public void deposit_zero_test() throws InvalidNumberException {
        double expected = 0;
        target.deposit(0);
        Assert.assertEquals(expected, target.getBalance(),.009);
    }

//    New Constructor Needed which is commented out
//    @Test
//    public void deposit_over_1000_test(){
//        target = new Account(1000);
//        double expected = 1000;
//        target.deposit(100);
//        Assert.assertEquals(expected, target.getBalance(),.009);
//    }

    //    New Constructor Needed which is commented out
//    @Test
//    public void withdraw_100_from_500(){
//        double expected = 400;
//        target = new Account(500);
//        target.withdraw(100);
//        Assert.assertEquals(expected, target.getBalance(), .009);
//    }
//
    //    New Constructor Needed which is commented out
//    @Test
//    public void withdraw_600_from_500(){
//        double expected = 500;
//        target = new Account(500);
//        target.withdraw(600);
//        Assert.assertEquals(expected, target.getBalance(), .009);
//    }


}
