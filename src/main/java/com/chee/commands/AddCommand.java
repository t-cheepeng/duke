package com.chee.commands;

import com.chee.io.DukePrinter;
import com.chee.model.Deadline;
import com.chee.model.Event;
import com.chee.model.Task;
import com.chee.model.ToDo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class AddCommand implements Command {

    private DateFormat dateFormat;
    private List<Task> taskList;
    private Task taskToAdd;
    private DukePrinter dukePrinter;

    public AddCommand(String commandType, List<Task> taskList,
                      DukePrinter dukePrinter, String... extras)
            throws ParseException {
        this.taskList = taskList;
        this.dukePrinter = dukePrinter;
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");

        switch(commandType) {
            case "todo":
                taskToAdd = new ToDo(extras[0]);
                break;
            case "deadline":
                taskToAdd = new Deadline(extras[0], dateFormat.parse(extras[1]));
                break;
            case "event":
                taskToAdd = new Event(extras[0], dateFormat.parse(extras[1]));
                break;
        }
    }

    @Override
    public void execute() {
        taskList.add(taskToAdd);
        dukePrinter.printAdd(taskToAdd, taskList.size());
    }
}
