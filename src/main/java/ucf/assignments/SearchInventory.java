/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Crystal Gagne
 */

package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class SearchInventory
{
    public FilteredList<Item> searchName(String nameToSearchFor, ObservableList<Item> listInventoryItems)
    {
        // Search the entire listInventoryItems for all names that contain "stringToSearchFor"
            // Return that filtered list.

        FilteredList<Item> nameSearchedList = listInventoryItems.filtered(item -> item.getItemName().contains(nameToSearchFor));
        return nameSearchedList;
    }

    public FilteredList<Item> searchSerialNumber(String serialNumberToSearchFor, ObservableList<Item> listInventoryItems)
    {
        // Search the entire listInventoryItems for all names that contain "serialNumberToSearchFor"
            // Return that filtered list.

        FilteredList<Item> serialNumberSearchedList = listInventoryItems.filtered(item -> item.getSerialNumber().contains(serialNumberToSearchFor));
        return serialNumberSearchedList;
    }
}
