import com.chee.commands.ByeCommand;
import com.chee.commands.Command;
import com.chee.error.MissingInformationException;
import com.chee.error.UnknownCommandException;
import com.chee.error.UnknownFormatException;
import com.chee.io.CommandParser;
import com.chee.io.DukePrinter;
import com.chee.io.Input;
import com.chee.model.Task;

import java.util.ArrayList;
import java.util.List;

public class Duke {

    private List<Task> userHistory;
    private DukePrinter dukePrinter;
    private Input input;
    private CommandParser parser;

    public Duke() {
        userHistory = new ArrayList<>();
        dukePrinter = new DukePrinter();
        input = Input.getInstance();
        parser = new CommandParser(userHistory, dukePrinter);
    }

    public void init() {
        dukePrinter.printWelcome();
        Command command = null;
        while(true) {
            String userInput = input.readInput();
            try {
                command = parser.parse(userInput);
                if(command instanceof ByeCommand) {
                    command.execute();
                    break;
                }
                command.execute();
            } catch (MissingInformationException | UnknownCommandException |UnknownFormatException e) {
                dukePrinter.printError(e.getMessage());
            }
        }
        input.close();
    }

    public static void main(String[] args) {
        Duke duke = new Duke();
        duke.init();
    }
}
