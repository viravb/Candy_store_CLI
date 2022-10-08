package com.techelevator.filereader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
    This class should contain any and all details of access to the log file
 */
public class LogFileWriter {

    LocalDateTime localDateTime= LocalDateTime.now();
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("MM/dd/uuuu hh:mm:ssa");

    File file = new File("Log.txt");

    public LogFileWriter() throws IOException {
    }

    public void logEntryMoneyAdded(double balanceAdded, double totalBalance ) throws IOException {
        try( FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            bufferedWriter.write( timeFormatter.format(localDateTime) + " MONEY RECEIVED: $" + balanceAdded + " $" + totalBalance + "\n");
        }
    }

    public void logEntryMakeChange(double change) throws IOException{
        try( FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            bufferedWriter.write( timeFormatter.format(localDateTime) + " CHANGE GIVEN: $ " + change + "$0.00\n");
        }

    }

    public void logEntryItemAdded(int quantity, String name, String sku, double purchaseAmount, double accountBalance) throws IOException{
        try( FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            bufferedWriter.write( timeFormatter.format(localDateTime) + " " + quantity + " " + name + " " + sku + " $" +
                    purchaseAmount + " $" + accountBalance + "\n");
        }

    }

}
