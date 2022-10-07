package com.techelevator;

public class Account {

    private double balance = 0.00;

    public Account(){

    }

    // for unit testing
//    public Account(double balance){
//        this.balance = balance;
//    }

    public void deposit(double amount){
        if(amount<=100 && (balance+amount)<=1000 && amount > 0){
            this.balance += amount;
        } else{
            System.out.println("FixMEE - Amount entered is greater than the max balance or over 100");
        }

    }

    public void withdraw(double amount){
        if(balance - amount>0) {
            balance -= amount;
        } else{
            System.out.println("FIXXX ME - Amount to withdraw is more then what is in the account");
        }

    }


    public double getBalance() {
        return balance;
    }



}
