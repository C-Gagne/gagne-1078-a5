/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Crystal Gagne
 */

package ucf.assignments;

import java.math.BigDecimal;

public class InventoryEditor {
    public Item addItem(BigDecimal itemValue, String serialNumber, String itemName)
    {
        Item addedItem = new Item();
        return addedItem;
    }
    public void editMonetaryValue(BigDecimal selectedItemValue)
    {
        // Get selected item's value
            // Get new item value
                // Verify new item value is a valid value
                    // Use check input function
                        // If it is, change to new item value
    }
    public void editSerialNumber(String selectedSerialNumber)
    {
        // Get selected item's SN
            // Get new SN
                // Verify new item SN is a valid SN
                    // Use check input function
                        // If it is, change to new item SN
    }
    public void editItemName(String selectedItemName)
    {
        // Get selected item's name
            // Get new name
                // Verify length is valid (use Check input function)
                    // If it is, change selected name to new name
    }
}
