/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Crystal Gagne
 */

package ucf.assignments;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class SaveInventory {
    public void saveToTSV(File selectedFile, Inventory itemInventory) {
        /*
         * Create TSV file
         * Write data into file, separating with /t
         */

        Writer writer = null;
        try {
            File file = new File(selectedFile.getCanonicalPath());
            writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < itemInventory.getListOfItems().size(); i++) {
                String text = itemInventory.getListOfItems().get(i).getItemValue().toString() + "\t" + itemInventory.getListOfItems().get(i).getSerialNumber() + "\t" + itemInventory.getListOfItems().get(i).getItemName();
                writer.write(text);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.flush();
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public void saveToHTML(File selectedFile, Inventory itemInventory) {
        /*
         * Create an HTML file
         *      Make sure proper tags are in the file
         * Write data into <TABLE></TABLE> of HTML file
         */


        Writer writer = null;
        try {
            File file = new File(selectedFile.getCanonicalPath());
            writer = new BufferedWriter(new FileWriter(file));

            writer.write("<!DOCTYPE html>\n");
            writer.write("<html>\n" + "<head>\n");

            writer.write("<style>\n");
            writer.write("\n");



            writer.write("\n");
            writer.write("</style>\n");
            writer.write("</head>\n");

            writer.write("<body>\n \n");

            writer.write("<center><h3> Inventory </h3></center>\n \n");
            writer.write("<table style=\"width=100%\">\n \n");

            writer.write("  <tr>\n");
            writer.write("     <th>Value (USD)</th>\n" + "     <th>Serial Number</th>\n" + "     <th>Item Name</th>\n");
            writer.write("  </tr>\n");

            for (int i = 0; i < itemInventory.getListOfItems().size(); i++)
            {
                BigDecimal numberValue = itemInventory.getListOfItems().get(i).getItemValue();
                String serialNumber = itemInventory.getListOfItems().get(i).getSerialNumber();
                String itemName = itemInventory.getListOfItems().get(i).getItemName();

                writer.write("  <tr>\n");
                writer.write("\t <td> " + numberValue.toString() +" </td> \n");
                writer.write("\t <td> " + serialNumber +" </td> \n");
                writer.write("\t <td> " + itemName +" </td> \n");
                writer.write("  </tr>\n \n");
            }


            writer.write("</table>\n \n");


            writer.write("</body>\n");
            writer.write("</html>\n");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.flush();
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void saveToJSON(File selectedFile, Inventory itemInventory) {
        /*
         * Create a JSON file
         * Use GSON to parse the list of inventory items into a JSON file.
         */

        List<Item> itemsJSON = itemInventory.getListOfItems().stream().toList();

        try {
            JsonWriter writer = new JsonWriter(new FileWriter(selectedFile));
            writer.beginObject();
            writer.name("Inventory");
            writer.beginArray();
            for (Item items : itemsJSON) {
                writer.beginObject();
                writer.name("Value").value(items.getItemValue());
                writer.name("SN").value(items.getSerialNumber());
                writer.name("Name").value(items.getItemName());
                writer.endObject();
            }
            writer.endArray();
            writer.endObject();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
