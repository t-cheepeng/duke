import duke.model.ToDo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {

    private ToDo emptyTodo = new ToDo("");

    @Test
    public void getSaveString_emptyDescription_correctSaveString() {
        assertEquals("T,false,", emptyTodo.getSaveString());
    }

    @Test
    public void toString_emptyDescription_correctString() {
        assertEquals("[T][\u2718] ", emptyTodo.toString());
    }
}
