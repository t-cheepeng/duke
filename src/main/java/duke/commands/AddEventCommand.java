package duke.commands;

import duke.io.DukePrinter;
import duke.model.Event;
import duke.model.TaskList;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddEventCommand extends AddCommand {

    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");

    public AddEventCommand(TaskList taskList, DukePrinter dukePrinter,
                           String name, String date)
            throws ParseException {
        super(taskList, dukePrinter);
        taskToAdd = new Event(name, dateFormat.parse(date));
    }
}
