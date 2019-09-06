package duke.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Represents date formats user is able to enter.
 */
public class Dates {

    public static final DateFormat outputFormat = new SimpleDateFormat("dd 'of' MMMMMMMMM yyyy, hh:mm aaa");
    public static final DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");

}
