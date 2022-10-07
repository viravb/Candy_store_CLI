package com.techelevator;

public class Account {

    private double balance = 0.0;

    public void deposit(double amount){
        if(amount<=100 && (balance+amount)<=1000){
            this.balance += amount;
        } else{
            System.out.println("FixMEE");
        }

    }


    public double getBalance() {
        return balance;
    }



}
