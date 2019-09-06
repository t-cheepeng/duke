package duke.commands;

import duke.asserts.Asserter;
import duke.io.DukePrinter;

public abstract class AbstractCommand implements Command {

    protected DukePrinter dukePrinter;

    public AbstractCommand(DukePrinter dukePrinter) {
        Asserter.assertNonNullPrinter(dukePrinter);

        this.dukePrinter = dukePrinter;
    }

}
