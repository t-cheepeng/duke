package duke.commands;

import duke.io.DukePrinter;
import duke.model.TaskList;

public class TagCommand extends AbstractCommand {

    private TaskList taskList;
    private int taskNum;
    private String tag;

    /**
     * Constructs a command representing a tag action.
     *
     * @param taskList The list of task
     * @param dukePrinter The output of duke
     * @param taskNum The task to tag
     * @param tag The tag to add
     */
    public TagCommand(TaskList taskList, DukePrinter dukePrinter, int taskNum, String tag) {
        super(dukePrinter);
        this.taskList = taskList;
        this.taskNum = taskNum;
        this.tag = tag;
    }

    /**
     * {@inheritDoc}
     */
    public void execute() {
        taskList.get(taskNum - 1).setTag(tag);
        dukePrinter.printTag(taskNum, taskList.get(taskNum - 1));
    }
}
