package duke.parser;

import duke.asserts.Asserter;
import duke.commands.AddToDoCommand;
import duke.commands.AddDeadlineCommand;
import duke.commands.AddEventCommand;
import duke.commands.TagCommand;
import duke.commands.DeleteCommand;
import duke.commands.DoneCommand;
import duke.commands.ByeCommand;
import duke.commands.FindCommand;
import duke.commands.Command;
import duke.commands.ListCommand;
import duke.exceptions.MissingInformationException;
import duke.exceptions.UnknownCommandException;
import duke.io.DukePrinter;
import duke.model.TaskList;

import java.text.ParseException;

/**
 * Parses String commands into actual {@code Command} objects.
 * <p>
 * This class is a utility class that will parse
 * strings into {@code Command} objects that can
 * then be called on to be executed at a later
 * time/as required. The parser will require
 * the list of tasks currently held by Duke
 * and the user output object.
 * </p>
 * <p>
 * Additionally, the class will do validation
 * on the string commands and sanitize the
 * commands to prevent unknown commands from being
 * entered into Duke. Appropriate feedback will be
 * given to the user when their commands are not
 * what is expected.
 * </p>
 *
 * @see Verifier
 */
public class CommandParser {

    private Verifier verifier;
    private TaskList taskList;
    private DukePrinter dukePrinter;

    /**
     * Represents a parser that will parse strings into commands.
     * @param taskList The list of tasks user has
     * @param dukePrinter Output of Duke
     */
    public CommandParser(TaskList taskList, DukePrinter dukePrinter) {
        assert taskList != null;
        assert dukePrinter != null;

        verifier = new Verifier();
        this.taskList = taskList;
        this.dukePrinter = dukePrinter;
    }

    /**
     * Verifies and parses strings into respective {@code Command} objects.
     *
     * @param command The user inputted command
     * @return {@code Command} objects representing a valid command
     * @throws UnknownCommandException     when command is not known by Duke
     * @throws MissingInformationException when command lacks information required
     * @throws ParseException              when dates are unable to be parsed by parser
     */
    public Command parse(String command)
            throws UnknownCommandException, MissingInformationException, ParseException {
        Asserter.assertNonNullString(command);
        verifier.verify(command);
        return parseValidCommandString(command);
    }

    private Command parseValidCommandString(String command) throws ParseException {
        Command result = null;
        String[] splitWhitespace = command.split(" ");
        switch (splitWhitespace[0]) {
        case "bye":
            result = new ByeCommand(dukePrinter);
            break;
        case "list":
            result = new ListCommand(taskList, dukePrinter);
            break;
        case "done":
            result = new DoneCommand(
                    taskList,
                    Integer.parseInt(splitWhitespace[1]),
                    dukePrinter);
            break;
        case "deadline":
            String[] splitByFlag = command.split("/by");
            result = new AddDeadlineCommand(
                    taskList,
                    dukePrinter,
                    splitByFlag[0].substring(9).trim(),
                    splitByFlag[1].trim());
            break;
        case "event":
            splitByFlag = command.split("/at");
            result = new AddEventCommand(
                    taskList,
                    dukePrinter,
                    splitByFlag[0].substring(6).trim(),
                    splitByFlag[1].trim());
            break;
        case "todo":
            result = new AddToDoCommand(
                    taskList,
                    dukePrinter,
                    command.substring(4).trim());
            break;
        case "delete":
            result = new DeleteCommand(
                    taskList,
                    Integer.parseInt(splitWhitespace[1]),
                    dukePrinter);
            break;
        case "find":
            result = new FindCommand(
                    command.substring(5),
                    taskList,
                    dukePrinter);
            break;
        case "tag":
            splitByFlag = command.split("/as");
            result = new TagCommand(
                    taskList,
                    dukePrinter,
                    Integer.parseInt(splitWhitespace[1]),
                    splitByFlag[1].trim());
            break;
        default:
            break;
        }
        return result;
    }
}
