package duke.commands;

import duke.io.DukePrinter;
import duke.model.Task;
import duke.model.TaskList;

public class DeleteCommand implements Command {

    private TaskList taskList;
    private DukePrinter dukePrinter;
    private int toDelete;

    /**
     * Makes a command representing a Delete action.
     *
     * @param taskList    The user's list of task
     * @param toDelete    The index of the task to delete
     * @param dukePrinter The response duke gives
     */
    public DeleteCommand(TaskList taskList, int toDelete, DukePrinter dukePrinter) {
        assert taskList != null;
        assert dukePrinter != null;

        this.taskList = taskList;
        this.toDelete = toDelete;
        this.dukePrinter = dukePrinter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        Task removedTask = taskList.remove(toDelete - 1);
        dukePrinter.printDelete(removedTask, taskList.size());
    }
}
