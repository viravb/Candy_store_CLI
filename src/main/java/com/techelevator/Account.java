package com.techelevator;

import com.techelevator.exceptions.InvalidNumberException;

public class Account {

    private double balance = 0.00;

    public Account(){

    }

    // for unit testing
//    public Account(double balance){
//        this.balance = balance;
//    }

    public void deposit(double amount) throws InvalidNumberException {
        if(amount<=100 && (balance+amount)<=1000 && amount > 0){
            this.balance += amount;
        } else{
            throw new InvalidNumberException("Amount entered is greater than the max balance or over 100");
        }

    }

    public void withdraw(double amount) throws InvalidNumberException {


        if(balance - amount>0) {
            balance -= amount;
        } else{
           throw new InvalidNumberException ("Amount to withdraw is more then what is in the account");
        }
    }


    public double getBalance() {
        return balance;
    }



}
