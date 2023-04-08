package service;

import data.Human;
import util.ParseData;
import util.ReadFromConsole;
import util.WriteToFile;

import java.text.ParseException;

public class HumanService implements IHuman {

    @Override
    public void writeToFile() throws ParseException {
        WriteToFile.writeToFile(ParseData.parseLine(ReadFromConsole.readFromConsole()));
    }
}
