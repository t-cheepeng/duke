package com.chee.io;

import com.chee.commands.*;
import com.chee.error.MissingInformationException;
import com.chee.error.UnknownCommandException;
import com.chee.model.Task;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class CommandParser {

    private Verifier verifier;
    private List<Task> taskList;
    private DukePrinter dukePrinter;

    public CommandParser(List<Task> taskList, DukePrinter dukePrinter) {
        verifier = new Verifier();
        this.taskList = taskList;
        this.dukePrinter = dukePrinter;
    }

    public Command parse(String command)
            throws UnknownCommandException, MissingInformationException, ParseException {
        verifier.verify(command);
        String[] splitWhitesapce = command.split(" ");
        Command result = null;
        switch(splitWhitesapce[0]) {
            case "bye":
                result = new ByeCommand(dukePrinter);
                break;
            case "list":
                result = new ListCommand(taskList, dukePrinter);
                break;
            case "done":
                result = new DoneCommand(
                        taskList,
                        Integer.parseInt(splitWhitesapce[1]),
                        dukePrinter);
                break;
            case "deadline":
                String[] splitByFlag = command.split("/by");
                result = new AddCommand(
                        splitWhitesapce[0],
                        taskList,
                        dukePrinter,
                        splitByFlag[0].substring(9).trim(),
                        splitByFlag[1].trim());
                break;
            case "event":
                splitByFlag = command.split("/at");
                result = new AddCommand(
                        splitWhitesapce[0],
                        taskList,
                        dukePrinter,
                        splitByFlag[0].substring(6).trim(),
                        splitByFlag[1].trim());
                break;
            case "todo":
                result = new AddCommand(
                        splitWhitesapce[0],
                        taskList,
                        dukePrinter,
                        command.substring(4).trim());
                break;
            case "delete":
                result = new DeleteCommand(
                        taskList,
                        Integer.parseInt(splitWhitesapce[1]),
                        dukePrinter);
                break;
        }
        return result;
    }
}
