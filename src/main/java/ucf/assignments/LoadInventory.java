/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Crystal Gagne
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class LoadInventory {
    public ObservableList<Item> loadTSV(File selectedFile, ObservableList<Item> itemInventory)
    {
        /*
         * Read data into an array, line by line, splitting using \t character.
         * Write array into observable list
         */

        ObservableList<Item> loadedList = FXCollections.observableArrayList();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(selectedFile.getAbsolutePath()));
            String newLine;
            while ((newLine = bufferedReader.readLine())!= null)
            {
                String[] fromTSV = newLine.split("\t", -1);
                BigDecimal convertedValue = new BigDecimal(fromTSV[0]);
                Item loadedInventory = new Item(convertedValue, fromTSV[1], fromTSV[2]);
                loadedList.add(loadedInventory);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return loadedList;
    }

    public void loadHTML(File selectedFile, Inventory itemInventory)
    {
        /*
         * Read data, line by line, from <Table> </Table> tags (into an array?)
         * Write into observable list
         */
    }

    public void loadJSON(File selectedFile, Inventory itemInventory)
    {
        /*
         * Parse using GSON
         * Write into observable list
         */
    }
}
