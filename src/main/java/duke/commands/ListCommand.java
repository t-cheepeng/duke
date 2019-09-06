package duke.commands;

import duke.io.DukePrinter;
import duke.model.TaskList;

public class ListCommand implements Command {

    private TaskList taskList;
    private DukePrinter dukePrinter;

    public ListCommand(TaskList taskList, DukePrinter dukePrinter) {
        assert taskList != null;
        assert dukePrinter != null;

        this.taskList = taskList;
        this.dukePrinter = dukePrinter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        dukePrinter.printList(taskList.getTaskList());
    }
}
