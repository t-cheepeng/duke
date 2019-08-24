package com.chee.io;

import com.chee.model.Deadline;
import com.chee.model.Event;
import com.chee.model.Task;
import com.chee.model.ToDo;

public class DataParser {

    public Task parseTask(String line) {
        String[] splitByCommas = line.split(",");
        Task parsed = null;
        switch(splitByCommas[0]) {
            case "E":
                parsed = new Event(splitByCommas[2], splitByCommas[3]);
                parsed.setDone(Boolean.parseBoolean(splitByCommas[1]));
                break;
            case "D":
                parsed = new Deadline(splitByCommas[2], splitByCommas[3]);
                parsed.setDone(Boolean.parseBoolean(splitByCommas[1]));
                break;
            case "T":
                parsed = new ToDo(splitByCommas[2]);
                parsed.setDone(Boolean.parseBoolean(splitByCommas[1]));
                break;
        }
        return parsed;
    }
}
