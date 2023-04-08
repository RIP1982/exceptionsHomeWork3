package util;

import java.util.Scanner;

public class ReadFromConsole {
    public static String readFromConsole() {
        String data = (new Scanner(System.in).nextLine());
        return data;
    }
}
