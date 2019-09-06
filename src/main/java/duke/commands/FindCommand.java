package duke.commands;

import duke.asserts.Asserter;
import duke.io.DukePrinter;
import duke.model.Task;
import duke.model.TaskList;

import java.util.ArrayList;
import java.util.List;

public class FindCommand extends AbstractCommand {

    private String searchTerm;
    private TaskList taskList;

    /**
     * Makes a command representing a find action.
     *
     * @param searchTerm  The user's search term
     * @param taskList    The user's list of task
     * @param dukePrinter The response duke gives
     */
    public FindCommand(String searchTerm, TaskList taskList,
        DukePrinter dukePrinter) {
        super(dukePrinter);
        Asserter.assertNonNullTaskList(taskList);

        this.searchTerm = searchTerm;
        this.taskList = taskList;
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
