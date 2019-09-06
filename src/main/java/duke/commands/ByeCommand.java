package duke.commands;

import duke.io.DukePrinter;

public class ByeCommand extends AbstractCommand {

    public ByeCommand(DukePrinter dukePrinter) {
        super(dukePrinter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        dukePrinter.printBye();
    }
}
