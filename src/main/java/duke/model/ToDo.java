package duke.model;

public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String getSaveString() {
        return "T," + isDone + "," + description + "," + tag;
    }

    public String toString() {
        return "[T]" + "[" + getStatusIcon() + "] " + getTagStringForOutput() + description;
    }
}
