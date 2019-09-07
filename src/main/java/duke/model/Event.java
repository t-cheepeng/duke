package duke.model;

import java.text.DateFormat;
import java.util.Date;

public class Event extends Task {

    private Date eventTime;
    private DateFormat inputFormat = Dates.inputFormat;
    private DateFormat outputFormat = Dates.outputFormat;

    public Event(String description, Date eventTime) {
        super(description);
        this.eventTime = eventTime;
    }

    public String toString() {
        return "[E]" + "[" + getStatusIcon() + "] " + getTagStringForOutput() + description
                + " (at: " + outputFormat.format(eventTime) + ")";
    }

    @Override
    public String getSaveString() {
        return "E," + isDone + "," + description + "," + inputFormat.format(eventTime) + "," + tag;
    }
}
