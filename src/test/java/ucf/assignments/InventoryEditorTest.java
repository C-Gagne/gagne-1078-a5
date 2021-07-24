package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InventoryEditorTest {

    @Test
    void addItem_verifyItemIsAdded()
    {
        InventoryEditor edit = new InventoryEditor();
        Inventory testingInventory = new Inventory();
        testingInventory.setItemInList(edit.addItem(new BigDecimal("0.0"), "1234567890", "TestItem"));

        int actual = testingInventory.getListOfItems().size();
        int expected = 1;

        assertEquals(expected,actual);
    }

    @Test
    void addItem_verify_HoldHundredItems()
    {
        InventoryEditor edit = new InventoryEditor();
        Inventory testingInv = new Inventory();

        for (int i = 0; i < 100; i++)
        {
            testingInv.setItemInList(edit.addItem(new BigDecimal("0.0"), "1234567890", "AB"));
        }

        int actual = testingInv.getListOfItems().size();
        int expected = 100;

        assertEquals(expected,actual);
    }
}