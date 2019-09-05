package duke.commands;

import duke.io.DukePrinter;
import duke.model.TaskList;
import duke.model.ToDo;

public class AddToDoCommand extends AddCommand {

    public AddToDoCommand(TaskList taskList, DukePrinter dukePrinter,
                            String name) {
        super(taskList, dukePrinter);
        taskToAdd = new ToDo(name);
    }
}
