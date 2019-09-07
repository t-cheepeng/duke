package duke.io;

import duke.asserts.Asserter;
import duke.model.Task;

import java.util.List;

public class DukePrinter {
    private static final String INDENTATION = "     ";
    private static final String SEPARATOR_LINE =
            "    ______________________________________________________";
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
    private static final String TAG_MESSAGE =
            "Noted. I've tagged task %d as %s\n";
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

    private String latestPrintedMessage = "";

    public void printWelcome() {
        latestPrintedMessage += WELCOME_MESSAGE + "\n";
    }

    public void printBye() {
        latestPrintedMessage = BYE_MESSAGE;
        latestPrintedMessage += "\n";
    }

    /**
     * Prints a general message with separator lines encasing message.
     * @param message The message to print
     */
    public void printWithSeparator(String message) {
        latestPrintedMessage = SEPARATOR_LINE + "\n";
        latestPrintedMessage += message;
        latestPrintedMessage += SEPARATOR_LINE + "\n";

    }

    /**
     * Prints a list of tasks with separator lines.
     * @param items The list of tasks to print
     */
    public void printList(List<Task> items) {
        Asserter.assertNonNullList(items);

        StringBuilder message = new StringBuilder(LIST_MESSAGE);
        buildTaskListMessage(items, message);
        printWithSeparator(beautify(message.toString()));
    }

    /**
     * Prints duke's response to a valid done action.
     * @param doneItem The item that was marked as done
     */
    public void printDone(Task doneItem) {
        Asserter.assertNonNullTask(doneItem);

        String builder = DONE_MESSAGE;
        builder += "  ";
        builder += doneItem;
        printWithSeparator(beautify(builder));
    }

    /**
     * Prints duke's response to a valid add action.
     * @param addedTask The task added to the list
     * @param numOfTasks The number of tasks in the list
     */
    public void printAdd(Task addedTask, int numOfTasks) {
        printTaskResponse(addedTask, numOfTasks, ADD_MESSAGE);
    }

    /**
     * Prints duke's response to a a valid delete action.
     * @param deletedTask The task deleted from the list
     * @param numOfTask The number of tasks remaining in the list
     */
    public void printDelete(Task deletedTask, int numOfTask) {
        printTaskResponse(deletedTask, numOfTask, DELETE_MESSAGE);
    }

    /**
     * Prints an error message to the user.
     * @param errorMessage The error message
     */
    public void printError(String errorMessage) {
        printWithSeparator(beautify(errorMessage));
    }

    /**
     * Prints duke's response to a valid find action.
     * @param found The list of tasks matching user's search term
     */
    public void printFind(List<Task> found) {
        Asserter.assertNonNullList(found);

        StringBuilder builder = new StringBuilder(FIND_MESSAGE);
        buildTaskListMessage(found, builder);
        printWithSeparator(beautify(builder.toString()));
    }

    /**
     * Prints duke's response to a valid tag action.
     * @param task The task that was tagged
     */
    public void printTag(int taskNum, Task task) {
        Asserter.assertNonNullTask(task);
        Asserter.assertPositiveInteger(taskNum);

        String builder = String.format(TAG_MESSAGE, taskNum, task.getTag());
        builder += "  ";
        builder += task;
        printWithSeparator(beautify(builder));
    }

    /**
     * Retrieves the latest response duke had to the user.
     * @return Latest response duke had to the user.
     */
    public String getLatestCommandResponse() {
        Asserter.assertNonNullString(latestPrintedMessage);

        return latestPrintedMessage;
    }

    private static String beautify(String ugly) {
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
        Asserter.assertNonNullList(items);

        for (int i = 0; i < items.size(); i++) {
            Task task = items.get(i);
            message.append(i + 1);
            message.append(".");
            message.append(task);
            message.append("\n");
        }
    }

    private void printTaskResponse(Task deletedTask, int numOfTask, String deleteMessage) {
        Asserter.assertNonNullTask(deletedTask);
        Asserter.assertPositiveInteger(numOfTask);

        String message = deleteMessage;
        message += "  ";
        message += deletedTask;
        message += "\n";
        message += String.format(NUMBER_OF_TASK_MESSAGE, numOfTask);
        printWithSeparator(beautify(message));
    }
}
