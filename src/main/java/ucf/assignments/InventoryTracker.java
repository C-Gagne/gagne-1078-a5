/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Crystal Gagne
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/*

The program should allow you to enter an item, a serial number, and estimated value.
The program should then be able to display a tabular report of the data that looks like this:

Value     Serial Number   Name
$399.00   AXB124AXY3      Xbox One
$599.99   S40AZBDE47      Samsung TV

----------------------------------------------------------------------------------------

    [x] The user shall interact with the application through a Graphical User Interface
                --- TableView
                --- MenuBar should work and look best
    [x] The user shall be able to store at least 100 inventory items
                --- ObservableList
        [x] Each inventory item shall have a value representing its monetary value in US dollars
                --- Make sure entered value is a double (not ideal? Try BigDecimal)
        [x] Each inventory item shall have a unique serial number in the format of XXXXXXXXXX where X can be either a letter or digit
                --- Optional: Use a Set?
                --- Make sure that length is == 10
                    --- Make sure each character is a number or letter
                        --- Make sure item does not already exist (Not needed if using a Set)
                                --- Display error if Serial Number already exists.
                            --- Then add item
                                --- If any of these requirements are not met: Do not add or update any item.
        [x] Each inventory item shall have a name between 2 and 256 characters in length (inclusive)
                --- Check length before adding/updating item
    [x] The user shall be able to add a new inventory item
        [x] The application shall display an error message if the user enters an existing serial number for the new item
    [x] The user shall be able to remove an existing inventory item
    [0] The user shall be able to edit the value of an existing inventory item
            [ ] --- Double Check for Bugs...
    [x] The user shall be able to edit the serial number of an existing inventory item
        [x] The application shall prevent the user from duplicating the serial number
                --- For each item in a list, make sure item does not match this serial number before adding/updating item
    [x] The user shall be able to edit the name of an existing inventory item
                --- Relatively easy. Requires checks to meet requirements.
    [x] The user shall be able to sort the inventory items by value
                --- Built into TableView
    [x] The user shall be able to sort inventory items by serial number
                --- Built into TableView
    [x] The user shall be able to sort inventory items by name
                --- Built into TableView
    [x] The user shall be able to search for an inventory item by serial number
    [x] The user shall be able to search for an inventory item by name
    [x] The user shall be able to save their inventory items to a file
        [x] The user shall be able to select the file format from among the following set of options: TSV (tab-separated value), HTML, JSON
             [x] TSV files shall shall list one inventory item per line, separate each field within an inventory item using a tab character, and end with the extension .txt
             [x] HTML files shall contain valid HTML and end with the extension .html
             [x] JSON files shall contain valid JSON and end with the extension .json
        [x] The user shall provide the file name and file location of the file to save
                --- FileChooser
                    [x] --- .tsv
                    [x] --- .html
                    [x] --- .json
    The user shall be able to load inventory items from a file that was previously created by the application.
        [x] The user shall provide the file name and file location of the file to load
                --- FileChooser
                    [x] --- .tsv
                    [x] --- .html (uses Jsoup to parse .html)
                    [x] --- .json (uses Gson to parse .json)

        The requirement to save/load an inventory list in JSON format is optional.
         Implementation of this requirement will yield an extra 2 points on this assignment.
                    [x] --- Use GSON & FileChooser
 */


public class InventoryTracker extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("InventoryTrackerWindow.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Inventory Tracker");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
