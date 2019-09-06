package duke.asserts;

import duke.io.DukePrinter;
import duke.model.Task;
import duke.model.TaskList;

import java.util.List;

@SuppressWarnings("ALL")
public class Asserter {

    public static void assertNonNullPrinter(DukePrinter printer) {
        assert printer != null;
    }

    public static void assertNonNullTaskList(TaskList taskList) {
        assert taskList != null;
    }

    public static void assertPositiveInteger(int num) {
        assert num >= 0;
    }

    public static <T> void assertNonNullList(List<T> list) {
        assert list != null;
    }

    public static void assertNonNullTask(Task doneItem) {
        assert doneItem != null;
    }

    public static void assertNonNullString(String s) {
        assert s != null;
    }
}
