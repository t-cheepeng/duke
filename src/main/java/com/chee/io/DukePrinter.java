package com.chee.io;

import com.chee.model.Task;

import java.util.List;

public class DukePrinter {
    private static final String INDENTATION = "     ";
    private static final String SEPARATOR_LINE =
            "    ____________________________________________________________";
    private static final String WELCOME_MESSAGE =
            SEPARATOR_LINE
                    + "\n     Hello! I'm Duke\n"
                    + "     What can I do for you?\n"
                    + SEPARATOR_LINE
                    + "\n";
    private static final String LIST_MESSAGE =
            "Here are the tasks in your list:\n";
    private static final String DONE_MESSAGE =
            "Nice! I've marked this task as done:\n";
    private static final String ADD_MESSAGE =
            "Got it. I've added this task:\n";
    private static final String NUMBER_OF_TASK_MESSAGE =
            "Now you have %d tasks in the list.\n";
    private static final String DELETE_MESSAGE =
            "Noted. I've removed this task:\n";
    private static final String FIND_MESSAGE =
            "Here are the matching tasks in your list:\n";
    private static final String BYE_MESSAGE =
            SEPARATOR_LINE
                    + "\n     Bye. Hope to see you again soon!\n"
                    + SEPARATOR_LINE
                    + "\n";
    private static final String DUKE_MESSAGE =
            " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    public void printWelcome() {
        System.out.println("Hello from\n" + DUKE_MESSAGE);
        System.out.println(WELCOME_MESSAGE);
    }

    public void printBye() {
        System.out.println(BYE_MESSAGE);
    }

    public void printWithSeparator(String message) {
        System.out.println(SEPARATOR_LINE);
        System.out.print(message);
        System.out.println(SEPARATOR_LINE);
    }

    public void printList(List<Task> items) {
        StringBuilder message = new StringBuilder(LIST_MESSAGE);
        buildTaskListMessage(items, message);
        printWithSeparator(beautify(message.toString()));
    }

    public void printDone(Task doneItem) {
        StringBuilder builder = new StringBuilder(DONE_MESSAGE);
        builder.append("  ");
        builder.append(doneItem);
        printWithSeparator(beautify(builder.toString()));
    }

    public void printAdd(Task addedTask, int numOfTasks) {
        StringBuilder builder = new StringBuilder(ADD_MESSAGE);
        builder.append("  ");
        builder.append(addedTask);
        builder.append("\n");
        builder.append(String.format(NUMBER_OF_TASK_MESSAGE, numOfTasks));
        printWithSeparator(beautify(builder.toString()));
    }

    public void printDelete(Task deletedTask, int numOfTask) {
        StringBuilder builder = new StringBuilder(DELETE_MESSAGE);
        builder.append("  ");
        builder.append(deletedTask);
        builder.append("\n");
        builder.append(String.format(NUMBER_OF_TASK_MESSAGE, numOfTask));
        printWithSeparator(beautify(builder.toString()));
    }

    public void printError(String errorMessage) {
        printWithSeparator(beautify(errorMessage));
    }

    public void printFind(List<Task> found) {
        StringBuilder builder = new StringBuilder(FIND_MESSAGE);
        buildTaskListMessage(found, builder);
        printWithSeparator(beautify(builder.toString()));
    }

    public static String beautify(String ugly) {
        String[] splitByLine = ugly.split("\n");
        StringBuilder beauty = new StringBuilder();
        for (String s : splitByLine) {
            beauty.append(INDENTATION);
            beauty.append(s);
            beauty.append("\n");
        }
        return beauty.toString();
    }

    private void buildTaskListMessage(List<Task> items, StringBuilder message) {
        for(int i = 0; i < items.size(); i++) {
            Task task = items.get(i);
            message.append(i + 1);
            message.append(".");
            message.append(task);
            message.append("\n");
        }
    }
}
