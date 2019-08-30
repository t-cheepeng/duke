package com.chee.model;

/**
 * Encapsulates a task inside Duke's system.
 * <p>
 * This class represents a task that Duke understands
 * and is mainly for extension purposes to make more
 * specific types of tasks that have their own
 * unique attributes and methods.
 *
 * </p>
 *
 * @see ToDo Event Deadline
 */
public abstract class Task {
    String description;
    boolean isDone;

    public Task(String description) {
        this.description = description;
        isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    String getStatusIcon() {
        return (isDone ? "✓" : "✗");
    }

    /**
     * Returns a string in format that is to be saved locally.
     *
     * <p>
     * Classes overriding this method are expected
     * to partition their data using , as in a
     * CSV file for storage into local hard
     * disk purposes.
     * </p>
     *
     * @return Comma separated values of attributes in the class
     */
    public abstract String getSaveString();
}
