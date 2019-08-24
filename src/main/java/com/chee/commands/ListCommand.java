package com.chee.commands;

import com.chee.io.DukePrinter;
import com.chee.model.Task;
import com.chee.model.TaskList;

import java.util.List;

public class ListCommand implements Command {

    private TaskList taskList;
    private DukePrinter dukePrinter;

    public ListCommand(TaskList taskList, DukePrinter dukePrinter) {
        this.taskList = taskList;
        this.dukePrinter = dukePrinter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        dukePrinter.printList(taskList.getTaskList());
    }
}
