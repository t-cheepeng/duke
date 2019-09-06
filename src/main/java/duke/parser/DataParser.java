package duke.parser;

import duke.model.Deadline;
import duke.model.Event;
import duke.model.Task;
import duke.model.ToDo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataParser {

    private DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");

    /**
     * Parse a string into a Task.
     *
     * @param line The string to parse
     * @return The parsed task
     * @throws ParseException when parsing of tasks failed
     * @see Task
     */
    public Task parseTask(String line) throws ParseException {
        assert line != null;

        String[] splitByCommas = line.split(",");
        Task parsed = null;
        switch (splitByCommas[0]) {
        case "E":
            parsed = new Event(splitByCommas[2], inputFormat.parse(splitByCommas[3]));
            parsed.setDone(Boolean.parseBoolean(splitByCommas[1]));
            break;
        case "D":
            parsed = new Deadline(splitByCommas[2], inputFormat.parse(splitByCommas[3]));
            parsed.setDone(Boolean.parseBoolean(splitByCommas[1]));
            break;
        case "T":
            parsed = new ToDo(splitByCommas[2]);
            parsed.setDone(Boolean.parseBoolean(splitByCommas[1]));
            break;
        default:
            break;
        }
        return parsed;
    }
}
