package duke.model;

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
    String tag;
    boolean isDone;

    /**
     * Constructs a task with the given description.
     * @param description The description of the task
     */
    public Task(String description) {
        this.description = description;
        isDone = false;
        tag = "";
    }

    public String getDescription() {
        return description;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    String getStatusIcon() {
        return (isDone ? "🗸" : "✗");
    }

    String getTagStringForOutput() {
        return tag.equals("") ? "" : "[#" + tag + "] ";
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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
