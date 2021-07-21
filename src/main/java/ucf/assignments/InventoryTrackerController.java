/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Crystal Gagne
 */

package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.math.BigDecimal;

public class InventoryTrackerController {
    // First: configure the table.
    @FXML private TableView<Inventory> tableView;
    @FXML private TableColumn<Item, BigDecimal> valueColumn;
    @FXML private TableColumn<Item, String> serialNumberColumn;
    @FXML private TableColumn<Item, String> itemNameColumn;
}
