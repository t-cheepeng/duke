import com.chee.commands.ByeCommand;
import com.chee.commands.Command;
import com.chee.error.MissingInformationException;
import com.chee.error.UnknownCommandException;
import com.chee.error.UnknownFormatException;
import com.chee.model.TaskList;
import com.chee.parser.CommandParser;
import com.chee.io.DukePrinter;
import com.chee.io.IoUtils;
import com.chee.io.Input;

import java.text.ParseException;

public class Duke {

    private TaskList userHistory;
    private DukePrinter dukePrinter;
    private Input input;
    private CommandParser parser;
    private IoUtils io;

    /**
     * Creates the interactive chatbot Duke.
     */
    public Duke() {
        io = new IoUtils();
        userHistory = new TaskList(io.readTasks());
        dukePrinter = new DukePrinter();
        input = Input.getInstance();
        parser = new CommandParser(userHistory, dukePrinter);
    }

    /**
     * Initialises and starts up Duke to accept inputs from user.
     */
    public void init() {
        dukePrinter.printWelcome();
        Command command = null;
        while (true) {
            String userInput = input.readInput();
            try {
                command = parser.parse(userInput);
                if (command instanceof ByeCommand) {
                    command.execute();
                    break;
                }
                command.execute();
                io.writeTasks(userHistory.getTaskList());
            } catch (MissingInformationException | UnknownCommandException
                    | UnknownFormatException | ParseException e) {
                dukePrinter.printError(e.getMessage());
            }
        }
        input.close();
        io.close();
    }

    public static void main(String[] args) {
        Duke duke = new Duke();
        duke.init();
    }
}
