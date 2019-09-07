package duke.commands;

import duke.io.DukePrinter;
import duke.model.Deadline;
import duke.model.TaskList;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddDeadlineCommand extends AbstractAddCommand {

    /**
     * Constructs a command representing a deadline.
     *
     * @param taskList The list of tasks
     * @param dukePrinter The output of Duke
     * @param name Name of the task
     * @param date Deadline of the task
     * @throws ParseException when date is unable to be formatted
     */
    public AddDeadlineCommand(TaskList taskList, DukePrinter dukePrinter,
                              String name, String date)
            throws ParseException {
        super(taskList, dukePrinter);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
        taskToAdd = new Deadline(name, dateFormat.parse(date));
    }
}
