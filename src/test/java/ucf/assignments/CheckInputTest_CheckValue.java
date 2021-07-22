/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Crystal Gagne
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckInputTest_CheckValue {

    @Test
    void checkItemValue_ValidValue_AssertTrue()
    {
        CheckInput checkInputTest = new CheckInput();
        String testNumber = "3.45";

        boolean actual = checkInputTest.checkItemValue(testNumber);
        boolean expected = true;

        assertEquals(expected,actual);
    }
}