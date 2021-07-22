/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Crystal Gagne
 */

package ucf.assignments;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.BigDecimalStringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.NumberStringConverter;

import java.math.BigDecimal;

public class InventoryTrackerController {
    // First: configure the table.
    @FXML private TableView<Item> tableView;
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
        valueColumn.setCellValueFactory(new PropertyValueFactory<Item, BigDecimal>("itemValue"));
        valueColumn.setCellFactory(TextFieldTableCell.forTableColumn(new BigDecimalStringConverter()));

        serialNumberColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("serialNumber"));
        serialNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        itemNameColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("itemName"));
        itemNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());


        itemInventory.setItemInList(new Item(BigDecimal.valueOf(2.45), "AX12345678", "Item Name"));


        tableView.setEditable(true);
        tableView.setItems(itemInventory.getListOfItems());
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
        if (serialNumberValid)
        {
            serialNumberUnique = checkInputs.checkSerialNumberUniqueness(userTextSerialnumber, itemInventory.getListOfItems());
            if (!serialNumberUnique)
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
            itemInventory.setItemInList(editInventoryItems.addItem(userItemValue, userTextSerialnumber, userTextItemName));
            tableView.setItems(itemInventory.getListOfItems());
        }
    }

    public void removeItemClicked(ActionEvent clickedDeleteItem)
    {
        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
    }


    public void editItemValue(CellEditEvent cellToEdit)
    {
        boolean validValue;
        Item selectedItem = tableView.getSelectionModel().getSelectedItem();
        BigDecimal selectedValue = selectedItem.itemValue.getValue();
        double selectedValueAsDouble = selectedValue.doubleValue();
        validValue = checkInputs.checkItemValue(Double.toString(selectedValueAsDouble));

        if (validValue) {
            selectedItem.setItemValue((BigDecimal) cellToEdit.getNewValue());
        }
        else {
            Alert incorrectInputAlert = new Alert(Alert.AlertType.NONE);
            incorrectInputAlert.setTitle("Incorrect Input");
            incorrectInputAlert.setContentText("The number you have entered is not a recognized input.");
            incorrectInputAlert.getButtonTypes().add(ButtonType.OK);
            incorrectInputAlert.showAndWait();
            selectedItem.setItemValue((BigDecimal) cellToEdit.getOldValue());
            tableView.refresh();
        }
    }
    public void editSerialNumber(CellEditEvent cellToEdit)
    {
        boolean validSerialNumber;
        boolean uniqueSerialNumber;
        Item selectedItem = tableView.getSelectionModel().getSelectedItem();
        validSerialNumber = checkInputs.checkSerialNumberValidity(cellToEdit.getNewValue().toString());

        if (!validSerialNumber) {
            Alert serialNumberNotUniqueAlert = new Alert(Alert.AlertType.NONE);
            serialNumberNotUniqueAlert.setTitle("Invalid Serial Number");
            serialNumberNotUniqueAlert.setContentText("The serial number you entered is not valid.");
            serialNumberNotUniqueAlert.getButtonTypes().add(ButtonType.OK);
            serialNumberNotUniqueAlert.showAndWait();

            selectedItem.setSerialNumber(cellToEdit.getOldValue().toString());
            tableView.refresh();
        }
        else if (validSerialNumber) {
            uniqueSerialNumber = checkInputs.checkSerialNumberUniqueness(cellToEdit.getNewValue().toString(), itemInventory.getListOfItems());
            if (!uniqueSerialNumber) {
                Alert serialNumberNotUniqueAlert = new Alert(Alert.AlertType.NONE);
                serialNumberNotUniqueAlert.setTitle("Serial Number Already Exists");
                serialNumberNotUniqueAlert.setContentText("The serial number you entered already exists.");
                serialNumberNotUniqueAlert.getButtonTypes().add(ButtonType.OK);
                serialNumberNotUniqueAlert.showAndWait();

                selectedItem.setSerialNumber(cellToEdit.getOldValue().toString());
                tableView.refresh();
            }
            else {
                selectedItem.setSerialNumber(cellToEdit.getNewValue().toString());
            }
        }

    }
    public void editName(CellEditEvent cellToEdit)
    {
        boolean validName;
        Item selectedItem = tableView.getSelectionModel().getSelectedItem();
        validName = checkInputs.checkItemName(cellToEdit.getNewValue().toString());

        if (validName)
        {
            selectedItem.setItemName(cellToEdit.getNewValue().toString());
        }
        else
        {
            Alert serialNumberNotUniqueAlert = new Alert(Alert.AlertType.NONE);
            serialNumberNotUniqueAlert.setTitle("Invalid Item Name");
            serialNumberNotUniqueAlert.setContentText("Item names must be between 2 and 256 characters long.");
            serialNumberNotUniqueAlert.getButtonTypes().add(ButtonType.OK);
            serialNumberNotUniqueAlert.showAndWait();
            tableView.refresh();
        }

    }


    public void saveItemClicked(EventHandler clickedSaveItem)
    {

    }
    public void loadItemClicked(EventHandler clickedLoadItem)
    {

    }
}
