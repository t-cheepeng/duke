package duke.commands;

import duke.io.DukePrinter;
import duke.model.*;

import java.text.ParseException;

public abstract class AddCommand implements Command {

    private TaskList taskList;
    private DukePrinter dukePrinter;
    Task taskToAdd;

    /**
     * Adds a task to the task list.
     *
     * @param taskList    The list to ask task to
     * @param dukePrinter User output
     * @throws ParseException If {@code extras} are not parceable.
     */
    public AddCommand(TaskList taskList,
                      DukePrinter dukePrinter) {
        this.taskList = taskList;
        this.dukePrinter = dukePrinter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        taskList.add(taskToAdd);
        dukePrinter.printAdd(taskToAdd, taskList.size());
    }
}
