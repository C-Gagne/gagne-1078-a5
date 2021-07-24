package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SearchInventoryTest {

    @Test
    void searchName_VerifyNameIsSame_AfterSearch()
    {
        SearchInventory newSearch = new SearchInventory();
        Inventory testingInv = new Inventory();
        testingInv.setItemInList(new Item(new BigDecimal("67.80"), "0000000000", "Help"));
        testingInv.setItemInList(new Item(new BigDecimal("67.80"), "1000000000", "Rabbit"));

        String searchFor = "H";

        ObservableList<Item> searchedList = FXCollections.observableArrayList();

        searchedList = newSearch.searchName(searchFor, testingInv.getListOfItems());

        ObservableList<Item> expectedSearchedList = FXCollections.observableArrayList();
        expectedSearchedList.add(new Item(new BigDecimal("67.80"), "0000000000", "Help"));

        assertSame(searchedList.get(0).getItemName(), expectedSearchedList.get(0).getItemName());

    }

    @Test
    void searchSerialNumber_VerifySerialNumberIsSame_AfterSearch()
    {
        SearchInventory newSearch = new SearchInventory();
        Inventory testingInv = new Inventory();
        testingInv.setItemInList(new Item(new BigDecimal("67.80"), "0000000000", "Help"));
        testingInv.setItemInList(new Item(new BigDecimal("67.80"), "1000000000", "Rabbit"));

        String searchFor = "1";

        ObservableList<Item> searchedList = FXCollections.observableArrayList();

        searchedList = newSearch.searchSerialNumber(searchFor, testingInv.getListOfItems());

        ObservableList<Item> expectedSearchedList = FXCollections.observableArrayList();
        expectedSearchedList.add(new Item(new BigDecimal("67.80"), "1000000000", "Rabbit"));

        assertSame(searchedList.get(0).getSerialNumber(), expectedSearchedList.get(0).getSerialNumber());

    }
}