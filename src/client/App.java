package client;

import service.HumanService;
import service.IHuman;
import util.ParseData;
import util.ReadFromConsole;
import view.View;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Logger;

public class App {
    View ui;
    Logger logger = Logger.getAnonymousLogger();
    IHuman human = new HumanService();
    public App() {
        ui = new ConsoleView();
    }

    public void start()  throws IOException, ParseException {
        StringBuilder sb = new StringBuilder()
                .append("\n ==== \n")
                .append("1 - Enter the data\n")
                .append("0 - exit\n");
        while (true) {
            ui.set(sb.toString());
            switch (ui.get()) {
                case "1":
                    human.writeToFile();
                    break;
                case "0":
                    return;
            }
        }
    }
}
