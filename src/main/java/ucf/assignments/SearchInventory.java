/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Crystal Gagne
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class SearchInventory
{
    public void searchName(String nameToSearchFor, ObservableList<Inventory> listInventoryItems)
    {
        // Search the entire listInventoryItems for all names that contain "stringToSearchFor"
            // Return that filtered list.
    }

    public void searchSerialNumber(String serialNumberToSearchFor, ObservableList<Inventory> listInventoryItems)
    {
        // Search the entire listInventoryItems for all names that contain "serialNumberToSearchFor"
            // Return that filtered list.
    }

    public ObservableList<Inventory> clearSearch()
    {
        ObservableList<Inventory> clearedFilters = FXCollections.observableArrayList();
        // clearedFilter will just be populated with the original Inventory
        return  clearedFilters;
    }
}
