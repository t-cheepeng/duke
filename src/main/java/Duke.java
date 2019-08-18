import com.chee.io.DukePrinter;
import com.chee.io.Input;
import com.chee.model.Task;

import java.util.ArrayList;
import java.util.List;

public class Duke {

    private List<Task> userHistory;
    private DukePrinter dukePrinter;
    private Input input;

    public Duke() {
        userHistory = new ArrayList<>();
        dukePrinter = new DukePrinter();
        input = Input.getInstance();
    }

    public void init() {
        dukePrinter.printWelcome();
        while(true) {
            String userInput = input.readInput();
            if(userInput.equals("bye")) {
                break;
            } else if(userInput.equals("list")) {
                dukePrinter.printList(userHistory);
            } else if(userInput.startsWith("done")) {
                int index = Integer.parseInt(userInput.split(" ")[1]) - 1;
                userHistory.get(index).setDone(true);
                dukePrinter.printDone(userHistory.get(index));
            } else {
                userHistory.add(new Task(userInput));
                dukePrinter.printWithSeparator(DukePrinter.beautify(userInput));
            }
        }
        dukePrinter.printBye();
        input.close();
    }

    public static void main(String[] args) {
        Duke duke = new Duke();
        duke.init();
    }
}
