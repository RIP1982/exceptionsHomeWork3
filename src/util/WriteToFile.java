package util;

import data.Human;
import com.opencsv.CSVWriter;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class WriteToFile {
    public static void writeToFile(Human person) {
        String[] fullName = (person.getName()).split(" ");
        String lastName = fullName[0];
        SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy");
        String[] personToString = {person.getName(), formater.format(person.getBirthday()),
                String.valueOf(person.getPhoneNumber()), String.valueOf(person.getGender())};
        List<String[]> personsToList = new ArrayList<>();
        personsToList.add(personToString);
        try {
            File f = new File("src/" + lastName + ".csv");
            if (f.createNewFile()) {
                CSVWriter writer = new CSVWriter(new FileWriter("src/" + lastName + ".csv"));
                writer.writeAll(personsToList);
                writer.close();
            } else {
                String row = null;
                BufferedReader csvReader = new BufferedReader(new FileReader("src/" + lastName + ".csv"));
                while ((row = csvReader.readLine()) != null) {
                    String[] personTemp = row.split(",");
                    for (int i = 0; i < personTemp.length; i++) {
                        String temp = personTemp[i].replace("\"", "");
                        personTemp[i] = temp;
                    }
                    personsToList.add(personTemp);
                }
                CSVWriter writer = new CSVWriter(new FileWriter("src/" + lastName + ".csv"));
                writer.writeAll(personsToList);
                writer.close();
            }
        } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

