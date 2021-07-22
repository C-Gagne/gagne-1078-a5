/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Crystal Gagne
 */

package ucf.assignments;

import java.io.*;

public class SaveInventory {
    public void saveToTSV(File selectedFile, Inventory itemInventory)
    {
        /*
         * Create TSV file
         * Write data into file, separating with /t
         */

        Writer writer = null;
        try {
            File file = new File(selectedFile.getAbsolutePath());
            writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i< itemInventory.getListOfItems().size(); i++) {
                String text = itemInventory.getListOfItems().get(i).getItemValue().toString() + "\t" + itemInventory.getListOfItems().get(i).getSerialNumber() + "\t" + itemInventory.getListOfItems().get(i).getItemName();
                writer.write(text);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public void saveToHTML(File selectedFile, Inventory itemInventory)
    {
        /*
         * Create an HTML file
         *      Make sure proper tags are in the file
         * Write data into <TABLE></TABLE> of HTML file
         */
    }

    public void saveToJSON(File selectedFile, Inventory itemInventory)
    {
        /*
         * Create a JSON file
         * Use GSON to parse the list of inventory items into a JSON file.
         */
    }
}
