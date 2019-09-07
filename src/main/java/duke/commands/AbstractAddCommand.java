package duke.commands;

import duke.asserts.Asserter;
import duke.io.DukePrinter;
import duke.model.Task;
import duke.model.TaskList;

public abstract class AbstractAddCommand extends AbstractCommand {

    TaskList taskList;
    Task taskToAdd;

    /**
     * Adds a task to the task list.
     *
     * @param taskList    The list to ask task to
     * @param dukePrinter User output
     */
    public AbstractAddCommand(TaskList taskList,
                              DukePrinter dukePrinter) {
        super(dukePrinter);
        Asserter.assertNonNullTaskList(taskList);

        this.taskList = taskList;
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
