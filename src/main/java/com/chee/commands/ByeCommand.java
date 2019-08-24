package com.chee.commands;

import com.chee.io.DukePrinter;

public class ByeCommand implements Command {

    private DukePrinter dukePrinter;

    public ByeCommand(DukePrinter dukePrinter) {
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
