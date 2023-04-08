package util;

import data.Human;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class ParseData {

    public static Human parseLine(String data) throws ParseException {
        String[] arrayData = data.split(" ");
        String name = new String();
        Date birthday = null;
        Long phoneNumber = 0L;
        Character gender = null;
        if (arrayData.length != 6) {
            throw new RuntimeException("The number of data fields is incorrect! 6 fields must be entered, but " +
                    "you entered " + arrayData.length + "!");
        } else {
            for (int i = 0; i < arrayData.length; i++) {
                if (arrayData[i].length() == 1) {
                    if(arrayData[i].equals("m") || arrayData[i].equals("f")) {
                        gender = arrayData[i].charAt(0);
                    }
                }
                else if (isNumber(arrayData[i])) {
                    if (arrayData[i].length() == 11) {
                        phoneNumber = Long.parseLong(arrayData[i]);
                    } else { throw new RuntimeException("Wrong input data!"); }
                }
                else if (isDate(arrayData[i])) {
                    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                    birthday = format.parse(arrayData[i]);
                } else {
                    name += arrayData[i] + " ";
                }
            }
        }
        Human person = new Human(name, birthday, phoneNumber, gender);

        if (person.getName().equals("")) {
            throw new RuntimeException("Incorrect input name!");
        }
        else if (person.getBirthday() == null) {
            throw new RuntimeException("Incorrect input birthday!");
        }
        else if (person.getPhoneNumber() == 0L) {
            throw new RuntimeException("Incorrect input phoneNumber!");
        }
        else if (person.getGender() == null) {
            throw new RuntimeException("Incorrect input gender!");
        } else { return person; }
    }

    public static boolean isNumber(String line) {
        try {
            Long numbers = Long.parseLong(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDate(String line) {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        try {
            Date date = format.parse(line);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
