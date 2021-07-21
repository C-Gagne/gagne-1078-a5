/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Crystal Gagne
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;

import java.math.BigDecimal;

public class InventoryTrackerController {
    // First: configure the table.
    @FXML private TableView<Inventory> tableView;
    @FXML private TableColumn<Item, BigDecimal> valueColumn;
    @FXML private TableColumn<Item, String> serialNumberColumn;
    @FXML private TableColumn<Item, String> itemNameColumn;

    // Second: configure TextFields
    @FXML private TextField itemValueTextField;
    @FXML private TextField itemSerialNumberTextField;
    @FXML private TextField itemNameTextField;

    Inventory itemInventory = new Inventory();
    InventoryEditor editInventoryItems = new InventoryEditor();
    CheckInput checkInputs = new CheckInput();

    @FXML private void initialize()
    {
        tableView.setEditable(true);

    }

    public void addItemClicked(ActionEvent clickedAddItem)
    {
        // We need to get the values from the text fields.
        String userTextItemValueString = itemValueTextField.getText();
        String userTextSerialnumber = itemSerialNumberTextField.getText();
        String userTextItemName = itemNameTextField.getText();

        boolean valueValid = false;
        boolean serialNumberValid = false;
        boolean serialNumberUnique = false;
        boolean nameValid = false;

        // We need to check that each of these is valid.
        valueValid = checkInputs.checkItemValue(userTextItemValueString);
        serialNumberValid = checkInputs.checkSerialNumberValidity(userTextSerialnumber);
        nameValid = checkInputs.checkItemName(userTextItemName);

        // Verify that the serial number is unique
            // If it is not, create a dialog box telling the user it is not unique.
        if (serialNumberValid == true)
        {
            serialNumberUnique = checkInputs.checkSerialNumberUniqueness(userTextSerialnumber, itemInventory.getListOfItems());
            if (serialNumberUnique == false)
            {
                Alert serialNumberNotUniqueAlert = new Alert(Alert.AlertType.NONE);
                serialNumberNotUniqueAlert.setTitle("Serial Number Already Exists");
                serialNumberNotUniqueAlert.setContentText("The serial number you entered already exists.");
                serialNumberNotUniqueAlert.getButtonTypes().add(ButtonType.OK);
                serialNumberNotUniqueAlert.showAndWait();
            }
        }
        if (valueValid && serialNumberUnique && nameValid) {
            BigDecimal userItemValue = new BigDecimal(userTextItemValueString);
            editInventoryItems.addItem(userItemValue, userTextSerialnumber, userTextItemName);
        }
    }

    public void removeItemClicked(ActionEvent clickedDeleteItem)
    {

    }


    public void editItemValue(CellEditEvent cellToEdit)
    {

    }
    public void editSerialNumber(CellEditEvent cellToEdit)
    {

    }
    public void editName(CellEditEvent cellToEdit)
    {

    }


    public void saveItemClicked(EventHandler clickedSaveItem)
    {

    }
    public void loadItemClicked(EventHandler clickedLoadItem)
    {

    }
}
