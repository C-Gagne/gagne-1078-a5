/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Crystal Gagne
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class LoadInventoryTest {

    @Test
    void loadTSV_ReadTSV_VerifyValueIsLoaded()
    {
        ObservableList<Item> listForTesting = FXCollections.observableArrayList();
        File loadedFile = new File("src/test/java/ucf/assignments/test/tsvTestLoad.txt");
        LoadInventory loadFile = new LoadInventory();

        listForTesting.setAll(loadFile.loadTSV(loadedFile));
        String expected = "2.45";
        String actual = listForTesting.get(0).getItemValue().toString();
        assertEquals(expected,actual);
    }

    @Test
    void loadHTML_ReadHTML_VerifyValueIsLoaded()
    {
        ObservableList<Item> listForTesting = FXCollections.observableArrayList();
        File loadedFile = new File("src/test/java/ucf/assignments/test/htmlTestLoad.html");

        LoadInventory loadFile = new LoadInventory();
        listForTesting.setAll(loadFile.loadHTML(loadedFile));
        String expected = "2.45";
        String actual = listForTesting.get(0).getItemValue().toString();
        assertEquals(expected,actual);
    }

    @Test
    void loadJSON_ReadJSON_VerifyValueIsLoaded()
    {
        ObservableList<Item> listForTesting = FXCollections.observableArrayList();
        File loadedFile = new File("src/test/java/ucf/assignments/test/jsonTestLoad.json");

        LoadInventory loadFile = new LoadInventory();
        listForTesting.setAll(loadFile.loadJSON(loadedFile));
        String expected = "2.45";
        String actual = listForTesting.get(0).getItemValue().toString();
        assertEquals(expected,actual);
    }


    @Test
    void loadTSV_ReadTSV_VerifySNIsLoaded()
    {
        ObservableList<Item> listForTesting = FXCollections.observableArrayList();
        File loadedFile = new File("src/test/java/ucf/assignments/test/tsvTestLoad.txt");
        LoadInventory loadFile = new LoadInventory();

        listForTesting.setAll(loadFile.loadTSV(loadedFile));
        String expected = "AX12345678";
        String actual = listForTesting.get(0).getSerialNumber();
        assertEquals(expected,actual);
    }

    @Test
    void loadHTML_ReadHTML_VerifySNIsLoaded()
    {
        ObservableList<Item> listForTesting = FXCollections.observableArrayList();
        File loadedFile = new File("src/test/java/ucf/assignments/test/htmlTestLoad.html");

        LoadInventory loadFile = new LoadInventory();
        listForTesting.setAll(loadFile.loadHTML(loadedFile));
        String expected = "AX12345678";
        String actual = listForTesting.get(0).getSerialNumber();
        assertEquals(expected,actual);
    }

    @Test
    void loadJSON_ReadJSON_VerifySNIsLoaded()
    {
        ObservableList<Item> listForTesting = FXCollections.observableArrayList();
        File loadedFile = new File("src/test/java/ucf/assignments/test/jsonTestLoad.json");

        LoadInventory loadFile = new LoadInventory();
        listForTesting.setAll(loadFile.loadJSON(loadedFile));
        String expected = "AX12345678";
        String actual = listForTesting.get(0).getSerialNumber();
        assertEquals(expected,actual);
    }

    @Test
    void loadTSV_ReadTSV_VerifyNameIsLoaded()
    {
        ObservableList<Item> listForTesting = FXCollections.observableArrayList();
        File loadedFile = new File("src/test/java/ucf/assignments/test/tsvTestLoad.txt");
        LoadInventory loadFile = new LoadInventory();

        listForTesting.setAll(loadFile.loadTSV(loadedFile));
        String expected = "Item Name";
        String actual = listForTesting.get(0).getItemName();
        assertEquals(expected,actual);
    }

    @Test
    void loadHTML_ReadHTML_VerifyNameIsLoaded()
    {
        ObservableList<Item> listForTesting = FXCollections.observableArrayList();
        File loadedFile = new File("src/test/java/ucf/assignments/test/htmlTestLoad.html");

        LoadInventory loadFile = new LoadInventory();
        listForTesting.setAll(loadFile.loadHTML(loadedFile));
        String expected = "Item Name";
        String actual = listForTesting.get(0).getItemName();
        assertEquals(expected,actual);
    }

    @Test
    void loadJSON_ReadJSON_VerifyNameIsLoaded()
    {
        ObservableList<Item> listForTesting = FXCollections.observableArrayList();
        File loadedFile = new File("src/test/java/ucf/assignments/test/jsonTestLoad.json");

        LoadInventory loadFile = new LoadInventory();
        listForTesting.setAll(loadFile.loadJSON(loadedFile));
        String expected = "Item Name";
        String actual = listForTesting.get(0).getItemName();
        assertEquals(expected,actual);
    }
}