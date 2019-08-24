package com.chee.commands;

import com.chee.io.DukePrinter;
import com.chee.model.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class AddCommand implements Command {

    private DateFormat dateFormat;
    private TaskList taskList;
    private Task taskToAdd;
    private DukePrinter dukePrinter;

    /**
     * Adds a task to the task list.
     * @param commandType Type of command
     * @param taskList The list to ask task to
     * @param dukePrinter User output
     * @param extras Extra information pertaining to the command
     * @throws ParseException If {@code extras} are not parceable.
     */
    public AddCommand(String commandType, TaskList taskList,
                      DukePrinter dukePrinter, String... extras)
            throws ParseException {
        this.taskList = taskList;
        this.dukePrinter = dukePrinter;
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");

        switch (commandType) {
            case "todo":
                taskToAdd = new ToDo(extras[0]);
                break;
            case "deadline":
                taskToAdd = new Deadline(extras[0], dateFormat.parse(extras[1]));
                break;
            case "event":
                taskToAdd = new Event(extras[0], dateFormat.parse(extras[1]));
                break;
            default:
                break;
        }
    }

    @Override
    public void execute() {
        taskList.add(taskToAdd);
        dukePrinter.printAdd(taskToAdd, taskList.size());
    }
}
