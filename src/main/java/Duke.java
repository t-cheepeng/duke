import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    private static final String SEPARATOR_LINE =
            "    ____________________________________________________________";
    private static final String WELCOME_MESSAGE =
            SEPARATOR_LINE +
                    "\n     Hello! I'm Duke\n" +
                    "     What can I do for you?\n" +
                    SEPARATOR_LINE + "\n";
    private static final String BYE_MESSAGE =
            SEPARATOR_LINE +
                    "\n     Bye. Hope to see you again soon!\n" +
                    SEPARATOR_LINE + "\n";

    private static List<String> userHistory = new ArrayList<>();

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println(WELCOME_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String userInput = scanner.nextLine();
            if(userInput.equals("bye")) {
                break;
            }
            if(userInput.equals("list")) {
                System.out.println(SEPARATOR_LINE);
                for(int i = 0; i < userHistory.size(); i++) {
                    System.out.print("     ");
                    System.out.println(i + 1 + "." + userHistory.get(i));
                }
                System.out.println(SEPARATOR_LINE);
            } else {
                System.out.println(SEPARATOR_LINE);
                System.out.println("     added: " + userInput);
                userHistory.add(userInput);
                System.out.println(SEPARATOR_LINE);
            }
        }
        System.out.println(BYE_MESSAGE);
    }
}
