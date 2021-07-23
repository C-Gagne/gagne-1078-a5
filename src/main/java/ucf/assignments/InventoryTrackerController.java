/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Crystal Gagne
 */

package ucf.assignments;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.converter.BigDecimalStringConverter;

import java.io.File;
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

    // Third: configure MenuBar
    @FXML private MenuBar menuBar;
    @FXML private Menu file;
    @FXML private MenuItem newInventory;
    @FXML private MenuItem saveAs;
    @FXML private MenuItem load;
    @FXML private MenuItem quit;

    Inventory itemInventory = new Inventory();
    InventoryEditor editInventoryItems = new InventoryEditor();
    CheckInput checkInputs = new CheckInput();

    @FXML private void initialize()
    {
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("itemValue"));
        valueColumn.setCellFactory(TextFieldTableCell.forTableColumn(new BigDecimalStringConverter()));

        serialNumberColumn.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        serialNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        itemNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());


        itemInventory.setItemInList(new Item(BigDecimal.valueOf(2.45), "AX12345678", "Item Name"));


        tableView.setEditable(true);
        tableView.setItems(itemInventory.getListOfItems());
    }

    public void addItemClicked()
    {
        // We need to get the values from the text fields.
        String userTextItemValueString = itemValueTextField.getText();
        String userTextSerialnumber = itemSerialNumberTextField.getText();
        String userTextItemName = itemNameTextField.getText();

        boolean valueValid;
        boolean serialNumberValid;
        boolean nameValid;

        boolean serialNumberUnique = false;

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

    public void removeItemClicked()
    {
        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
    }

    public void newInventoryClicked()
    {
        itemInventory.getListOfItems().remove(0, itemInventory.getListOfItems().size());
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
        else {
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


    public void saveItemClicked()
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save New To Do List");

        Stage stage = (Stage) tableView.getScene().getWindow();

        fileChooser.getExtensionFilters().add(new ExtensionFilter("HTML File", "*.html"));
        fileChooser.getExtensionFilters().add(new ExtensionFilter("TSV File", "*.tsv"));
        fileChooser.getExtensionFilters().add(new ExtensionFilter("JSON File", "*.json"));
        File selectedFile = fileChooser.showSaveDialog(stage);

        if (selectedFile != null) {
            int lastPeriod = selectedFile.toString().lastIndexOf('.');
            String extension = new String();

            for (int i = lastPeriod; i < selectedFile.toString().length(); i++) {
                extension += (selectedFile.toString().charAt(i));
            }


            if (extension.equalsIgnoreCase(".tsv")) {
                SaveInventory saveNewFile = new SaveInventory();
                saveNewFile.saveToTSV(selectedFile, itemInventory);
            }

            if (extension.equalsIgnoreCase(".html")) {
                SaveInventory saveNewFile = new SaveInventory();
                saveNewFile.saveToHTML(selectedFile, itemInventory);
            }

            if (extension.equalsIgnoreCase(".json")) {
                SaveInventory saveNewFile = new SaveInventory();
                saveNewFile.saveToJSON(selectedFile, itemInventory);
            }
        }
    }

    public void loadItemClicked() {
        ObservableList<Item> loadedList;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load To Do List");

        Stage stage = (Stage) tableView.getScene().getWindow();

        fileChooser.getExtensionFilters().add(new ExtensionFilter("All Supported File Types", "*.tsv", "*.html", "*.json"));
        fileChooser.getExtensionFilters().add(new ExtensionFilter("HTML Files", "*.html"));
        fileChooser.getExtensionFilters().add(new ExtensionFilter("TSV Files", "*.tsv"));
        fileChooser.getExtensionFilters().add(new ExtensionFilter("JSON Files", "*.json"));
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            int lastPeriod = selectedFile.toString().lastIndexOf('.');
            String extension = new String();


            for (int i = lastPeriod; i < selectedFile.toString().length(); i++) {
                extension += (selectedFile.toString().charAt(i));
            }

            if (extension.equalsIgnoreCase(".tsv")) {
                LoadInventory loadExistingFile = new LoadInventory();
                loadedList = loadExistingFile.loadTSV(selectedFile);
                tableView.setItems(loadedList);

                for (int i = 0; i < tableView.getItems().size(); i++) {
                    itemInventory.setItemInList(tableView.getItems().get(i));
                }
            }

            if (extension.equalsIgnoreCase(".html")) {
                LoadInventory loadExistingFile = new LoadInventory();
                loadedList = loadExistingFile.loadHTML(selectedFile);
                tableView.setItems(loadedList);

                for (int i = 0; i < tableView.getItems().size(); i++) {
                    itemInventory.setItemInList(tableView.getItems().get(i));
                }
            }

            if (extension.equalsIgnoreCase(".json")) {
                LoadInventory loadExistingFile = new LoadInventory();
                tableView.setItems(loadExistingFile.loadJSON(selectedFile));
                // * tableView.setItems(itemInventory.getListOfItems());

                for (int i = 0; i < tableView.getItems().size(); i++) {
                    itemInventory.setItemInList(tableView.getItems().get(i));
                }
            }
        }
    }
}
