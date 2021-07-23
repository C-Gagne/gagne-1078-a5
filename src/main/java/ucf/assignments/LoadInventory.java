/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Crystal Gagne
 */

package ucf.assignments;

import com.google.gson.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LoadInventory {
    public ObservableList<Item> loadTSV(File selectedFile)
    {
        /*
         * Read data into an array, line by line, splitting using \t character.
         * Write array into observable list
         */


        ObservableList<Item> loadedList = FXCollections.observableArrayList();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(selectedFile.getAbsolutePath()));
            String newLine;
            while ((newLine = bufferedReader.readLine())!= null)
            {
                String[] fromTSV = newLine.split("\t", -1);
                BigDecimal convertedValue = new BigDecimal(fromTSV[0]);
                Item loadedInventory = new Item(convertedValue, fromTSV[1], fromTSV[2]);
                loadedList.add(loadedInventory);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return loadedList;
    }

    public ObservableList<Item>  loadHTML(File selectedFile)
    {
        /*
         * Read data, line by line, from <Table> </Table> tags (into an array?)
         * Write into observable list
         */
        ObservableList<Item> loadedList = FXCollections.observableArrayList();
        Path file = Path.of(String.valueOf(selectedFile));

        String value = "";
        String serialNumber = "";
        String name;

        try {
            Document htmlFile = Jsoup.parse(Files.readString(file));
            Element table = htmlFile.selectFirst("table");
            Elements rows = table.select("tr");

            for (int i = 1; i< rows.size(); i++)
            {
                Element row = rows.get(i);
                Elements columns = row.select("td");

                for (int j = 0; j < columns.size(); j++)
                {
                    if ( j == 0)
                    {
                        value = columns.get(0).text();
                    }
                    if ( j == 1)
                    {
                        serialNumber = columns.get(1).text();
                    }
                    if ( j == 2)
                    {
                        name = columns.get(2).text();
                        BigDecimal convertedValue = new BigDecimal(value);
                        loadedList.add(new Item(convertedValue, serialNumber, name));
                    }
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return loadedList;
    }

    public ObservableList<Item> loadJSON(File selectedFile)
    {
        /*
         * Parse using GSON
         * Write into observable list
         */

        List<Item> itemList = new ArrayList<>();

        try {
            Gson gson = new Gson();
            JsonElement json = gson.fromJson(new FileReader(selectedFile), JsonElement.class);
            String stringJson = gson.toJson(json);

            JsonElement jElement = JsonParser.parseString(stringJson);
            JsonObject jObject = jElement.getAsJsonObject();
            JsonArray jArray = jObject.getAsJsonArray("Inventory");

            for (int i = 0; i < jArray.size(); i++)
            {
                JsonObject nextJsonObject = jArray.get(i).getAsJsonObject();
                BigDecimal value = nextJsonObject.get("Value").getAsBigDecimal();
                String serialNumber = nextJsonObject.get("SN").getAsString();
                String name = nextJsonObject.get("Name").getAsString();
                itemList.add(new Item(value, serialNumber, name));
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObservableList<Item> loadedList = FXCollections.observableArrayList(itemList);
        return loadedList;
    }
}
