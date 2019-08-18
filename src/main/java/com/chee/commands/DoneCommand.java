package com.chee.commands;

import com.chee.io.DukePrinter;
import com.chee.model.Task;

import java.util.List;

public class DoneCommand implements Command {

    private List<Task> taskList;
    private int taskNum;
    private DukePrinter dukePrinter;

    public DoneCommand(List<Task> taskList, int taskNum, DukePrinter dukePrinter) {
        this.taskList = taskList;
        this.taskNum = taskNum;
        this.dukePrinter = dukePrinter;
    }

    @Override
    public void execute() {
        taskList.get(taskNum - 1).setDone(true);
        dukePrinter.printDone(taskList.get(taskNum - 1));
    }
}
