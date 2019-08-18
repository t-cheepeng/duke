package com.chee.commands;

import com.chee.io.DukePrinter;
import com.chee.model.Task;

import java.util.List;

public class ListCommand implements Command {

    private List<Task> taskList;
    private DukePrinter dukePrinter;

    public ListCommand(List<Task> taskList, DukePrinter dukePrinter) {
        this.taskList = taskList;
        this.dukePrinter = dukePrinter;
    }

    @Override
    public void execute() {
        dukePrinter.printList(taskList);
    }
}
