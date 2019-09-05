import duke.commands.ByeCommand;
import duke.commands.Command;
import duke.exceptions.*;
import duke.model.TaskList;
import duke.parser.CommandParser;
import duke.io.DukePrinter;
import duke.io.IoUtils;

import java.text.ParseException;

public class Duke {

    private TaskList userHistory;
    private DukePrinter dukePrinter;
    private CommandParser parser;
    private IoUtils io;

    /**
     * Creates the interactive chatbot Duke.
     */
    public Duke() {
        io = new IoUtils();
        dukePrinter = new DukePrinter();
        try {
            userHistory = new TaskList(io.readTasks());
        } catch (CorruptDataException e) {
            dukePrinter.printError(e.getMessage());
            throw new UnableToStartDukeException(e.getMessage());
        }

        parser = new CommandParser(userHistory, dukePrinter);
    }

    /**
     * Gets duke's response to a user's input.
     * @param input The user's input
     * @return Duke's response as a string
     */
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
                | UnknownFormatException | ParseException e) {
            dukePrinter.printError(e.getMessage());
        }
        return dukePrinter.getLatestCommandResponse();
    }

    public String welcomeUser() {
        dukePrinter.printWelcome();
        return dukePrinter.getLatestCommandResponse();
    }
}
