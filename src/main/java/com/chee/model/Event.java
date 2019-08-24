package com.chee.model;

public class Event extends Task {

    private String eventTime;

    public Event(String description, String eventTime) {
        super(description);
        this.eventTime = eventTime;
    }

    public String toString() {
        return "[E]" + "[" + getStatusIcon() + "] " + description
                + " (at: " + eventTime + ")";
    }

    @Override
    public String getSaveString() {
        return "E," + isDone + "," + description + "," + eventTime;
    }
}
