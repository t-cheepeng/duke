package duke.commands;

import duke.io.DukePrinter;
import duke.model.Deadline;
import duke.model.TaskList;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddDeadlineCommand extends AddCommand {

    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");

    public AddDeadlineCommand(TaskList taskList, DukePrinter dukePrinter,
                              String name, String date)
            throws ParseException {
        super(taskList, dukePrinter);
        taskToAdd = new Deadline(name, dateFormat.parse(date));
    }
}
