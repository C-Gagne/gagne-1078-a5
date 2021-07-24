/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Crystal Gagne
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SaveInventoryTest {

    @Test
    void saveToTSV_VerifyFileIsCreated_AssertTrue()
    {
        Inventory testInventory = new Inventory();
        testInventory.setItemInList(new Item(BigDecimal.valueOf(2.45), "AX12345678", "Item Name"));
        testInventory.setItemInList(new Item(BigDecimal.valueOf(2.59), "AX12345679", "Item Name"));

        File selectedFile = new File("src/test/java/ucf/assignments/test/tsvTestSave.tsv");

        SaveInventory saveFile = new SaveInventory();
        saveFile.saveToTSV(selectedFile, testInventory);
        boolean exists = selectedFile.exists();
        assertTrue(exists);
    }

    @Test
    void saveToHTML_VerifyFileIsCreated_AssertTrue()
    {
        Inventory testInventory = new Inventory();
        testInventory.setItemInList(new Item(BigDecimal.valueOf(2.45), "AX12345678", "Item Name"));
        testInventory.setItemInList(new Item(BigDecimal.valueOf(2.59), "AX12345679", "Item Name"));

        File selectedFile = new File("src/test/java/ucf/assignments/test/htmlTestSave.html");

        SaveInventory saveFile = new SaveInventory();
        saveFile.saveToHTML(selectedFile, testInventory);
        boolean exists = selectedFile.exists();
        assertTrue(exists);
    }

    @Test
    void saveToJSON_VerifyFileIsCreated_AssertTrue()
    {
        Inventory testInventory = new Inventory();
        testInventory.setItemInList(new Item(BigDecimal.valueOf(2.45), "AX12345678", "Item Name"));
        testInventory.setItemInList(new Item(BigDecimal.valueOf(2.59), "AX12345679", "Item Name"));

        File selectedFile = new File("src/test/java/ucf/assignments/test/jsonTestSave.json");

        SaveInventory saveFile = new SaveInventory();
        saveFile.saveToJSON(selectedFile, testInventory);
        boolean exists = selectedFile.exists();
        assertTrue(exists);
    }
}