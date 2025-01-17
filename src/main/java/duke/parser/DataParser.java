package duke.parser;

import duke.asserts.Asserter;
import duke.model.Dates;
import duke.model.Deadline;
import duke.model.Event;
import duke.model.Task;
import duke.model.ToDo;

import java.text.DateFormat;
import java.text.ParseException;

public class DataParser {

    private DateFormat inputFormat = Dates.inputFormat;

    /**
     * Parse a string into a Task.
     *
     * @param line The string to parse
     * @return The parsed task
     * @throws ParseException when parsing of tasks failed
     * @see Task
     */
    public Task parseTask(String line) throws ParseException {
        Asserter.assertNonNullString(line);
        return parseValidDataLine(line);

    }

    private Task parseValidDataLine(String line) throws ParseException {
        String[] splitByCommas = line.split(",");
        Task parsed = null;
        switch (splitByCommas[0]) {
        case "E":
            parsed = new Event(splitByCommas[2], inputFormat.parse(splitByCommas[3]));
            parsed.setDone(Boolean.parseBoolean(splitByCommas[1]));
            parsed.setTag(splitByCommas.length >= 5 ? splitByCommas[4] : "");
            break;
        case "D":
            parsed = new Deadline(splitByCommas[2], inputFormat.parse(splitByCommas[3]));
            parsed.setDone(Boolean.parseBoolean(splitByCommas[1]));
            parsed.setTag(splitByCommas.length >= 5 ? splitByCommas[4] : "");
            break;
        case "T":
            parsed = new ToDo(splitByCommas[2]);
            parsed.setDone(Boolean.parseBoolean(splitByCommas[1]));
            parsed.setTag(splitByCommas.length >= 4 ? splitByCommas[3] : "");
            break;
        default:
            break;
        }
        return parsed;
    }
}
