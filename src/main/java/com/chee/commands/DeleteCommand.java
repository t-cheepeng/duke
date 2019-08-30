package com.chee.commands;

import com.chee.io.DukePrinter;
import com.chee.model.Task;
import com.chee.model.TaskList;

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
