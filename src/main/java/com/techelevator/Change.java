package com.techelevator;

public class Change {

    private int twenties = 0;
    private int tens = 0;
    private int fives = 0;
    private int ones = 0;
    private int quarters =0;
    private int dimes = 0;
    private int nickels = 0;

    public void determineChange(double totalChange){
        while(totalChange>=20){
            totalChange -= 20;
            twenties+=1;
        }
        while(totalChange>=10){
            totalChange -= 10;
            tens+=1;
        }
        while(totalChange>=5){
            totalChange -= 5;
            fives+=1;
        }
        while(totalChange>=1){
            totalChange -= 1;
            ones+=1;
        }
        while(totalChange>=0.25){
            totalChange -= 0.25;
            quarters+=1;
        }
        while(totalChange>=0.10){
            totalChange -= 0.10;
            dimes+=1;
        }
        while(totalChange>=0.05){
            totalChange -= 0.05;
            nickels+=1;
        }
    }

    public int getTwenties() {
        return twenties;
    }

    public int getTens() {
        return tens;
    }

    public int getFives() {
        return fives;
    }

    public int getOnes() {
        return ones;
    }

    public int getQuarters() {
        return quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public int getNickels() {
        return nickels;
    }
}
