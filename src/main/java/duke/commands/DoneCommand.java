package duke.commands;

import duke.io.DukePrinter;
import duke.model.TaskList;

public class DoneCommand implements Command {

    private TaskList taskList;
    private int taskNum;
    private DukePrinter dukePrinter;

    /**
     * Makes a command representing a done action.
     *
     * @param taskList    The user's list of task
     * @param taskNum     The index of the task to set to done
     * @param dukePrinter The response duke gives
     */

    public DoneCommand(TaskList taskList, int taskNum, DukePrinter dukePrinter) {
        assert taskList != null;
        assert dukePrinter != null;

        this.taskList = taskList;
        this.taskNum = taskNum;
        this.dukePrinter = dukePrinter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        taskList.get(taskNum - 1).setDone(true);
        dukePrinter.printDone(taskList.get(taskNum - 1));
    }
}
