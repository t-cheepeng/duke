package com.chee.commands;

import com.chee.io.DukePrinter;
import com.chee.model.Task;
import com.chee.model.TaskList;

import java.util.List;

public class DoneCommand implements Command {

    private TaskList taskList;
    private int taskNum;
    private DukePrinter dukePrinter;

    public DoneCommand(TaskList taskList, int taskNum, DukePrinter dukePrinter) {
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
