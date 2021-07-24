/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Crystal Gagne
 */


package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTrackerController_EditTableTest {

    @Test
    void editItemValue_ChangeValue_AssertChanged_EqualsWhatItShould()
    {

        Inventory testInventory = new Inventory();
        testInventory.setItemInList(new Item(BigDecimal.valueOf(2.45), "AX12345678", "Item Name"));
        testInventory.setItemInList(new Item(BigDecimal.valueOf(2.59), "AX12345679", "Item Name"));

        Item actual = testInventory.getListOfItems().get(0);
        actual.setItemValue(new BigDecimal("32"));
        BigDecimal expected = new BigDecimal("32");

        assertEquals(expected,actual.getItemValue());
    }

    @Test
    void editItemValue_DoNotChangeValue_AssertChanged_DoesNotEqualNew()
    {

        Inventory testInventory = new Inventory();
        testInventory.setItemInList(new Item(BigDecimal.valueOf(2.45), "AX12345678", "Item Name"));
        testInventory.setItemInList(new Item(BigDecimal.valueOf(2.59), "AX12345679", "Item Name"));

        Item actual = testInventory.getListOfItems().get(0);
        BigDecimal expected = new BigDecimal("32");

        assertNotEquals(expected,actual.getItemValue());
    }

    @Test
    void editSerialNumber_ChangeValue_AssertChanged_EqualsWhatItShould() {

        Inventory testInventory = new Inventory();
        testInventory.setItemInList(new Item(BigDecimal.valueOf(2.45), "AX12345678", "Item Name"));
        testInventory.setItemInList(new Item(BigDecimal.valueOf(2.59), "AX12345679", "Item Name"));

        Item actual = testInventory.getListOfItems().get(0);
        actual.setSerialNumber("0000000000");
        String expected = "0000000000";

        assertEquals(expected,actual.getSerialNumber());
    }

    @Test
    void editSerialNumber_DoNotChangeValue_AssertChanged_DoesNotEqualNew() {

        Inventory testInventory = new Inventory();
        testInventory.setItemInList(new Item(BigDecimal.valueOf(2.45), "AX12345678", "Item Name"));
        testInventory.setItemInList(new Item(BigDecimal.valueOf(2.59), "AX12345679", "Item Name"));

        Item actual = testInventory.getListOfItems().get(0);
        String expected = "0000000000";

        assertNotEquals(expected,actual.getSerialNumber());
    }

    @Test
    void editName_ChangeValue_AssertChanged_EqualsWhatItShould() {

        Inventory testInventory = new Inventory();
        testInventory.setItemInList(new Item(BigDecimal.valueOf(2.45), "AX12345678", "Item Name"));
        testInventory.setItemInList(new Item(BigDecimal.valueOf(2.59), "AX12345679", "Item Name"));

        Item actual = testInventory.getListOfItems().get(0);
        actual.setItemName("New Name");
        String expected = "New Name";

        assertEquals(expected,actual.getItemName());
    }

    @Test
    void editName_DoNotChangeValue_AssertChanged_DoesNotEqualNew() {

        Inventory testInventory = new Inventory();
        testInventory.setItemInList(new Item(BigDecimal.valueOf(2.45), "AX12345678", "Item Name"));
        testInventory.setItemInList(new Item(BigDecimal.valueOf(2.59), "AX12345679", "Item Name"));

        Item actual = testInventory.getListOfItems().get(0);
        String expected = "New Name";

        assertNotEquals(expected,actual.getItemName());
    }
}