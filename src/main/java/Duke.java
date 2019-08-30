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
import java.util.NoSuchElementException;

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

    public String getResponse(String input) {
        Command command = null;
        try {
            command = parser.parse(input);
            if (command instanceof ByeCommand) {
                command.execute();
            }
            command.execute();
            io.writeTasks(userHistory.getTaskList());
        } catch (MissingInformationException | UnknownCommandException
                | UnknownFormatException | ParseException | NoSuchElementException e) {
            dukePrinter.printError(e.getMessage());
        }
        return dukePrinter.getLatestCommandResponse();
    }

    public String welcomeUser() {
        dukePrinter.printWelcome();
        return dukePrinter.getLatestCommandResponse();
    }
}
