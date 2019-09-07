package duke.model;

import java.text.DateFormat;
import java.util.Date;

public class Deadline extends Task {

    private Date deadline;
    private DateFormat inputFormat = Dates.inputFormat;
    private DateFormat outputFormat = Dates.outputFormat;

    public Deadline(String description, Date deadline) {
        super(description);
        this.deadline = deadline;
    }

    public String toString() {
        return "[D]" + "[" + getStatusIcon() + "] " + getTagStringForOutput() + description
                + " (by: " + outputFormat.format(deadline) + ")";
    }

    @Override
    public String getSaveString() {
        return "D," + isDone + "," + description + "," + inputFormat.format(deadline) + "," + tag;
    }
}
