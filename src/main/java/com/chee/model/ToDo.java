package com.chee.model;

public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    public String toString() {
        return "[T]" + "[" + getStatusIcon() + "] " + description;
    }
}
