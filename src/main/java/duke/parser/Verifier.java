package duke.parser;

import duke.exceptions.MissingInformationException;
import duke.exceptions.UnknownCommandException;
import duke.exceptions.UnknownFormatException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Verifier {

    private static final String MISSING_INFO_ERROR_MESSAGE =
            "☹ OOPS!!! The %s of a %s cannot be empty.";
    private static final String UNKNOWN_COMMAND_ERROR_MESSAGE =
            "☹ OOPS!!! I'm sorry, but I don't know what that means :-(";
    private static final String UNKNOWN_FORMAT_MESSAGE =
            "☹ OOPS!!! It seems you have entered an invalid format for %s";

    private String[] split;
    private String command;
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");

    /**
     * Verifies user's input is a valid command.
     *
     * @param command The input of user
     * @throws UnknownCommandException     when command is not known
     * @throws MissingInformationException when information for command is insufficient
     */
    public void verify(String command)
            throws UnknownCommandException, MissingInformationException {
        assert command != null;

        this.command = command;
        split = command.split(" ");
        if (!isKnownCommand(split[0])) {
            throw new UnknownCommandException(UNKNOWN_COMMAND_ERROR_MESSAGE);
        }
        switch (split[0]) {
        case "todo":
            checkForTodo();
            break;
        case "deadline":
            checkForDeadline();
            break;
        case "event":
            checkForEvent();
            break;
        case "done":
            checkForDone();
            break;
        case "delete":
            checkForDelete();
            break;
        case "find":
            checkForFind();
            break;
        default:
            break;
        }
    }

    private boolean isKnownCommand(String firstWord) {
        return firstWord.equals("todo")
                || firstWord.equals("list")
                || firstWord.equals("deadline")
                || firstWord.equals("event")
                || firstWord.equals("done")
                || firstWord.equals("bye")
                || firstWord.equals("delete")
                || firstWord.equals("find");
    }

    private void checkForTodo() {
        if (split.length < 2) {
            throw new MissingInformationException(
                    String.format(MISSING_INFO_ERROR_MESSAGE, "description", split[0]));
        }
    }

    private void checkForDelete() {
        checkForSingleNumberCommand();
    }

    private void checkForDone() {
        checkForSingleNumberCommand();
    }

    private void checkForDeadline() {
        checkForFlagExistence("by", "/by");
        String[] splitByFlag = command.split("/by");
        if (splitByFlag.length < 2 || splitByFlag[1].trim().equals("")) {
            throw new MissingInformationException(
                    String.format(MISSING_INFO_ERROR_MESSAGE, "by", split[0]));
        }
        //deadline is 8 characters long. If no string exists after deleting deadline,
        //the description is missing
        if (splitByFlag[0].substring(8).trim().equals("")) {
            throw new MissingInformationException(
                    String.format(MISSING_INFO_ERROR_MESSAGE, "description", split[0]));
        }
        try {
            dateFormat.parse(splitByFlag[1].trim());
        } catch (ParseException e) {
            throw new UnknownFormatException(
                    String.format(UNKNOWN_FORMAT_MESSAGE, "date"));
        }
    }

    private void checkForEvent() {
        checkForFlagExistence("at", "/at");
        String[] splitByFlag = command.split("/at");
        if (splitByFlag.length < 2 || splitByFlag[1].trim().equals("")) {
            throw new MissingInformationException(
                    String.format(MISSING_INFO_ERROR_MESSAGE, "at", split[0]));
        }
        if (splitByFlag[0].substring(5).trim().equals("")) {
            throw new MissingInformationException(
                    String.format(MISSING_INFO_ERROR_MESSAGE, "description", split[0]));
        }
        try {
            dateFormat.parse(splitByFlag[1].trim());
        } catch (ParseException e) {
            throw new UnknownFormatException(
                    String.format(UNKNOWN_FORMAT_MESSAGE, "date"));
        }
    }

    private void checkForFind() {
        if (split.length < 2) {
            throw new MissingInformationException(
                    String.format(MISSING_INFO_ERROR_MESSAGE, "search space", split[0]));
        }
    }

    private void checkForFlagExistence(String infoMissing, String flag) {
        if (!command.contains(flag)) {
            throw new MissingInformationException(
                    String.format(MISSING_INFO_ERROR_MESSAGE, infoMissing, split[0]));
        }
    }

    private void checkForSingleNumberCommand() {
        if (split.length < 2) {
            throw new MissingInformationException(
                    String.format(MISSING_INFO_ERROR_MESSAGE, "number", split[0]));
        }
        try {
            Integer.parseInt(split[1]);
        } catch (NumberFormatException e) {
            throw new UnknownFormatException(
                    String.format(UNKNOWN_FORMAT_MESSAGE, split[0]));
        }
    }

}
