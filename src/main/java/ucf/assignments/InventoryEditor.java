/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Crystal Gagne
 */

package ucf.assignments;

import java.math.BigDecimal;

public class InventoryEditor {
    public Item addItem(BigDecimal itemValue, String serialNumber, String itemName)
    {
        Item addedItem = new Item(itemValue, serialNumber, itemName);
        return addedItem;
    }
}
