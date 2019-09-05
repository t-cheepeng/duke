package duke.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {

    private Date deadline;
    private DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
    private DateFormat outputFormat = new SimpleDateFormat("dd 'of' MMMMMMMMM yyyy, hh:mm aaa");

    public Deadline(String description, Date deadline) {
        super(description);
        this.deadline = deadline;
    }

    public String toString() {
        return "[D]" + "[" + getStatusIcon() + "] " + description
                + " (by: " + outputFormat.format(deadline) + ")";
    }

    @Override
    public String getSaveString() {
        return "D," + isDone + "," + description + "," + inputFormat.format(deadline);
    }
}
