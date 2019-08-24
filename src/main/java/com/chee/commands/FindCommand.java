package com.chee.commands;

import com.chee.io.DukePrinter;
import com.chee.model.Task;
import com.chee.model.TaskList;

import java.util.ArrayList;
import java.util.List;

public class FindCommand implements Command {

    private String searchTerm;
    private TaskList taskList;
    private DukePrinter dukePrinter;

    public FindCommand(String searchTerm, TaskList taskList,
        DukePrinter dukePrinter) {
        this.searchTerm = searchTerm;
        this.taskList = taskList;
        this.dukePrinter = dukePrinter;
    }

    @Override
    public void execute() {
        List<Task> found = findTasks();
        dukePrinter.printFind(found);
    }

    private List<Task> findTasks() {
        List<Task> found = new ArrayList<>();
        for (Task task : taskList.getTaskList()) {
            if (task.getDescription().contains(searchTerm)) {
                found.add(task);
            }
        }
        return found;
    }
}