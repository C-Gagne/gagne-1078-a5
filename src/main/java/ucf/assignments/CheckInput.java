/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Crystal Gagne
 */

package ucf.assignments;

import javafx.collections.ObservableList;

public class CheckInput
{
    public boolean checkItemValue(String itemValue)
    {
        // Get item value, then make sure it is a valid input
        int decimalCount = 0;

        for (int i = 0; i < itemValue.length(); i++)
        {
            char charToCheck = itemValue.charAt(i);

            if (decimalCount > 1) { return false; }
            else if (charToCheck == '.') { decimalCount++; }
            else if (!Character.isDigit(charToCheck)) { return false; }
        }

        return true;
    }

    public boolean checkSerialNumberValidity(String serialNumber)
    {
        // Get serial number and existing list of items
            // Make sure length is 10.
                // Check that serial number is valid (only numbers and letters)
        if (serialNumber.length() != 10)
        {
            return false;
        }
        else {
            for (int i = 0; i < serialNumber.length(); i++)
            {
                if (!Character.isDigit(serialNumber.charAt(i)) && !Character.isLetter(serialNumber.charAt(i)))
                {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkSerialNumberUniqueness(String serialNumber, ObservableList<Item> listOfItems)
    {
        // Check list of Inventory Items for the serial number.
            // If it exists, return false.
                // Else return true.
        if (listOfItems == null)
        {
            return true;
        }

        for (int i = 0; i < listOfItems.size(); i++) {
            if (serialNumber.equals(listOfItems.get(i).getSerialNumber()))
            {
                return false;
            }
        }
        return true;
    }

    public boolean checkItemName(String itemName)
    {
        // Get item name
            // Make sure it is longer than 1 character and less than 257 characters.

        return itemName.length() >= 2 && itemName.length() <= 256;
    }
}
