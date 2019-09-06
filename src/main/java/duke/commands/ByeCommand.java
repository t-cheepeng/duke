package duke.commands;

import duke.io.DukePrinter;

public class ByeCommand implements Command {

    private DukePrinter dukePrinter;

    public ByeCommand(DukePrinter dukePrinter) {
        assert dukePrinter != null;

        this.dukePrinter = dukePrinter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        dukePrinter.printBye();
    }
}
