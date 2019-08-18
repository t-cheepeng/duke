package com.chee.io;

import com.chee.model.Task;

import java.util.List;

public class DukePrinter {
    private static final String INDENTATION = "     ";
    private static final String SEPARATOR_LINE =
            "    ____________________________________________________________";
    private static final String WELCOME_MESSAGE =
            SEPARATOR_LINE +
                    "\n     Hello! I'm Duke\n" +
                    "     What can I do for you?\n" +
                    SEPARATOR_LINE + "\n";
    private static final String LIST_MESSAGE =
            "Here are the tasks in your list:\n";
    private static final String DONE_MESSAGE =
            "Nice! I've marked this task as done:\n";
    private static final String BYE_MESSAGE =
            SEPARATOR_LINE +
                    "\n     Bye. Hope to see you again soon!\n" +
                    SEPARATOR_LINE + "\n";
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
        for(int i = 0; i < items.size(); i++) {
            Task task = items.get(i);
            message.append(i + 1);
            message.append(".");
            message.append(task);
            message.append("\n");
        }
        printWithSeparator(beautify(message.toString()));
    }

    public void printDone(Task doneItem) {
        StringBuilder builder = new StringBuilder(DONE_MESSAGE);
        builder.append("  ");
        builder.append(doneItem);
        printWithSeparator(beautify(builder.toString()));
    }

    public static String beautify(String ugly) {
        String[] splitByLine = ugly.split("\n");
        String beauty = "";
        for(String s : splitByLine) {
            beauty += INDENTATION;
            beauty += s;
            beauty += "\n";
        }
        return beauty;
    }
}
