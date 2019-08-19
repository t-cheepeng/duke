package com.chee.commands;

import com.chee.io.DukePrinter;
import com.chee.model.Task;

import java.util.List;

public class DeleteCommand implements Command {

    private List<Task> taskList;
    private DukePrinter dukePrinter;
    private int toDelete;

    public DeleteCommand(List<Task> taskList, int toDelete, DukePrinter dukePrinter) {
        this.taskList = taskList;
        this.toDelete = toDelete;
        this.dukePrinter = dukePrinter;
    }

    @Override
    public void execute() {
        Task removedTask = taskList.remove(toDelete - 1);
        dukePrinter.printDelete(removedTask, taskList.size());
    }
}
