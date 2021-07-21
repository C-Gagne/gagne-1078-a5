/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Crystal Gagne
 */

package ucf.assignments;


import javafx.collections.ObservableList;

public class Inventory
{
    private ObservableList<Item> listInventoryItems;

    public ObservableList<Item> getListOfItems()
    {
        return listInventoryItems;
    }

    public void setItemInList(ObservableList<Item> listInventoryItems)
    {
        this.listInventoryItems = listInventoryItems;
    }
}
