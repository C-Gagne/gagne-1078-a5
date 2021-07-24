/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Crystal Gagne
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CheckInputTest {

    @Test
    void checkItemValue_ValidValue_AssertTrue()
    {
        CheckInput checkInputTest = new CheckInput();
        String testNumber = "3.45";

        boolean actual = checkInputTest.checkItemValue(testNumber);
        boolean expected = true;

        assertEquals(expected,actual);
    }

    @Test
    void checkItemValue_InvalidValue_AssertFalse()
    {
        CheckInput checkInputTest = new CheckInput();
        String testNumber = "A3.45";

        boolean actual = checkInputTest.checkItemValue(testNumber);
        boolean expected = false;

        assertEquals(expected,actual);
    }

    @Test
    void checkItemName_ValidName_AssertTrue()
    {
        CheckInput checkInputTest = new CheckInput();
        String testName = "A3.45";

        boolean actual = checkInputTest.checkItemName(testName);
        boolean expected = true;

        assertEquals(expected,actual);
    }

    @Test
    void checkItemName_InvalidName_TooShort_AssertFalse()
    {
        CheckInput checkInputTest = new CheckInput();
        String testName = "5";

        boolean actual = checkInputTest.checkItemName(testName);
        boolean expected = false;

        assertEquals(expected,actual);
    }

    @Test
    void checkItemName_InvalidName_TooLong_AssertFalse()
    {
        CheckInput checkInputTest = new CheckInput();
        String testName = "";
        for (int i = 0; i == 300; i++)
        {
            testName += "a";
        }

        boolean actual = checkInputTest.checkItemName(testName);
        boolean expected = false;

        assertEquals(expected,actual);
    }

    @Test
    void checkItemSN_ValidSerial_Digits_AssertTrue()
    {
        CheckInput checkInputTest = new CheckInput();
        String testSerial = "0987654321";

        boolean actual = checkInputTest.checkSerialNumberValidity(testSerial);
        boolean expected = true;

        assertEquals(expected,actual);
    }

    @Test
    void checkItemSN_ValidSerial_Mixed_AssertTrue()
    {
        CheckInput checkInputTest = new CheckInput();
        String testSerial = "ACBD654321";

        boolean actual = checkInputTest.checkSerialNumberValidity(testSerial);
        boolean expected = true;

        assertEquals(expected,actual);
    }

    @Test
    void checkItemSN_ValidSerial_Letters_AssertTrue()
    {
        CheckInput checkInputTest = new CheckInput();
        String testSerial = "faBcDedsdf";

        boolean actual = checkInputTest.checkSerialNumberValidity(testSerial);
        boolean expected = true;

        assertEquals(expected,actual);
    }

    @Test
    void checkItemSN_InvalidSerial_TooShort_AssertFalse()
    {
        CheckInput checkInputTest = new CheckInput();
        String testSerial = "faBcdsdf";

        boolean actual = checkInputTest.checkSerialNumberValidity(testSerial);
        boolean expected = false;

        assertEquals(expected,actual);
    }

    @Test
    void checkItemSN_InvalidSerial_TooLong_AssertFalse()
    {
        CheckInput checkInputTest = new CheckInput();
        String testSerial = "faaaaaaaaaaaBcdsdf";

        boolean actual = checkInputTest.checkSerialNumberValidity(testSerial);
        boolean expected = false;

        assertEquals(expected,actual);
    }

    @Test
    void checkItemSN_InvalidSerial_InvalidChar_AssertFalse()
    {
        CheckInput checkInputTest = new CheckInput();
        String testSerial = "098765432!";

        boolean actual = checkInputTest.checkSerialNumberValidity(testSerial);
        boolean expected = false;

        assertEquals(expected,actual);
    }

    @Test
    void checkItemSN_UniqueSerial_AssertTrue()
    {
        CheckInput checkInputTest = new CheckInput();
        Inventory testInventory = new Inventory();
        testInventory.setItemInList(new Item(BigDecimal.valueOf(2.45), "AX12345678", "Item Name"));

        String testSerial = "0987654321";

        boolean actual = checkInputTest.checkSerialNumberUniqueness(testSerial, testInventory.getListOfItems());
        boolean expected = true;

        assertEquals(expected,actual);
    }

    @Test
    void checkItemSN_Not_UniqueSerial_AssertFalse()
    {
        CheckInput checkInputTest = new CheckInput();
        Inventory testInventory = new Inventory();
        testInventory.setItemInList(new Item(BigDecimal.valueOf(2.45), "AX12345678", "Item Name"));

        String testSerial = "AX12345678";

        boolean actual = checkInputTest.checkSerialNumberUniqueness(testSerial, testInventory.getListOfItems());
        boolean expected = false;

        assertEquals(expected,actual);
    }
}