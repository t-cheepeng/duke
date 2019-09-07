package duke.commands;

import duke.asserts.Asserter;
import duke.io.DukePrinter;

public abstract class AbstractCommand implements Command {

    protected DukePrinter dukePrinter;

    /**
     * Constructs an {@code AbstractCommand} with {@code DukePrinter}.
     *
     * @param dukePrinter The output of Duke
     */
    public AbstractCommand(DukePrinter dukePrinter) {
        Asserter.assertNonNullPrinter(dukePrinter);

        this.dukePrinter = dukePrinter;
    }

}
