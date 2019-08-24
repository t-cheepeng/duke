package com.chee.parser;

import com.chee.model.Deadline;
import com.chee.model.Event;
import com.chee.model.Task;
import com.chee.model.ToDo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataParser {

    private DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");

    public Task parseTask(String line) throws ParseException {
        String[] splitByCommas = line.split(",");
        Task parsed = null;
        switch (splitByCommas[0]) {
            case "E":
                parsed = new Event(splitByCommas[2], inputFormat.parse(splitByCommas[3]));
                parsed.setDone(Boolean.parseBoolean(splitByCommas[1]));
                break;
            case "D":
                parsed = new Deadline(splitByCommas[2], inputFormat.parse(splitByCommas[3]));
                parsed.setDone(Boolean.parseBoolean(splitByCommas[1]));
                break;
            case "T":
                parsed = new ToDo(splitByCommas[2]);
                parsed.setDone(Boolean.parseBoolean(splitByCommas[1]));
                break;
            default:
                break;
        }
        return parsed;
    }
}
