/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Crystal Gagne
 */

package ucf.assignments;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.math.BigDecimal;

public class Item
{
    SimpleObjectProperty<BigDecimal> itemValue;
    SimpleStringProperty serialNumber;
    SimpleStringProperty itemName;

    public Item(BigDecimal itemValue, String serialNumber, String itemName)
    {
        this.itemValue = new SimpleObjectProperty<BigDecimal>(itemValue);
        this.serialNumber = new SimpleStringProperty(serialNumber);
        this.itemName = new SimpleStringProperty(itemName);
    }

    public BigDecimal getItemValue() {
        return itemValue.get();
    }

    public SimpleObjectProperty<BigDecimal> itemValueProperty() {
        return itemValue;
    }

    public void setItemValue(BigDecimal itemValue) {
        this.itemValue.set(itemValue);
    }

    public String getSerialNumber() {
        return serialNumber.get();
    }

    public SimpleStringProperty serialNumberProperty() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber.set(serialNumber);
    }

    public String getItemName() {
        return itemName.get();
    }

    public SimpleStringProperty itemNameProperty() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName.set(itemName);
    }

}
