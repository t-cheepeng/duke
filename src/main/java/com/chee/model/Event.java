package com.chee.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task {

    private Date eventTime;
    private DateFormat outputFormat = new SimpleDateFormat("dd 'of' MMMMMMMMM yyyy, hh:mm aaa");

    public Event(String description, Date eventTime) {
        super(description);
        this.eventTime = eventTime;
    }

    public String toString() {
        return "[E]" + "[" + getStatusIcon() + "] " + description
                + " (at: " + outputFormat.format(eventTime) + ")";
    }
}
