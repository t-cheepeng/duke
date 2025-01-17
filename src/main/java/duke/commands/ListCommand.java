package duke.commands;

import duke.asserts.Asserter;
import duke.io.DukePrinter;
import duke.model.TaskList;

public class ListCommand extends AbstractCommand {

    private TaskList taskList;

    /**
     * Constructs a command representing a output of list.
     * @param taskList The list of task
     * @param dukePrinter The output of duke
     */
    public ListCommand(TaskList taskList, DukePrinter dukePrinter) {
        super(dukePrinter);
        Asserter.assertNonNullTaskList(taskList);

        this.taskList = taskList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        dukePrinter.printList(taskList.getTaskList());
    }
}
