package duke.commands;

import duke.io.DukePrinter;
import duke.model.Event;
import duke.model.TaskList;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddEventCommand extends AbstractAddCommand {

    /**
     * Constructs a command representing an event.
     *
     * @param taskList The list of task
     * @param dukePrinter The outptut of Duke
     * @param name The name of the event
     * @param date When the event is happening
     * @throws ParseException when date is unable to be formatted
     */
    public AddEventCommand(TaskList taskList, DukePrinter dukePrinter,
                           String name, String date)
            throws ParseException {
        super(taskList, dukePrinter);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
        taskToAdd = new Event(name, dateFormat.parse(date));
    }
}
