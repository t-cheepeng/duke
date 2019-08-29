import com.chee.commands.ByeCommand;
import com.chee.commands.Command;
import com.chee.error.MissingInformationException;
import com.chee.error.UnknownCommandException;
import com.chee.error.UnknownFormatException;
import com.chee.model.TaskList;
import com.chee.parser.CommandParser;
import com.chee.io.DukePrinter;
import com.chee.io.IoUtils;
import com.chee.io.Input;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.ParseException;
import java.util.NoSuchElementException;

public class Duke extends Application {

    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;
    private Image user = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image duke = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    private TaskList userHistory;
    private DukePrinter dukePrinter;
    private Input input;
    private CommandParser parser;
    private IoUtils io;

    /**
     * Creates the interactive chatbot Duke.
     */
    public Duke() {
        io = new IoUtils();
        userHistory = new TaskList(io.readTasks());
        dukePrinter = new DukePrinter();
        input = Input.getInstance();
        parser = new CommandParser(userHistory, dukePrinter);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        scrollPane = new ScrollPane();
        dialogContainer = new VBox();
        scrollPane.setContent(dialogContainer);

        userInput = new TextField();
        sendButton = new Button("Send");
        primaryStage.setTitle("Duke");
        primaryStage.setResizable(false);
        primaryStage.setMinHeight(600.0);
        primaryStage.setMinWidth(400.0);

        scrollPane.setPrefSize(385, 535);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        scrollPane.setVvalue(1.0);
        scrollPane.setFitToWidth(true);

        // You will need to import `javafx.scene.layout.Region` for this.
        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);

        userInput.setPrefWidth(325.0);

        sendButton.setPrefWidth(55.0);

        AnchorPane.setTopAnchor(scrollPane, 1.0);

        AnchorPane.setBottomAnchor(sendButton, 1.0);
        AnchorPane.setRightAnchor(sendButton, 1.0);

        AnchorPane.setLeftAnchor(userInput , 1.0);
        AnchorPane.setBottomAnchor(userInput, 1.0);
        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);

        mainLayout.setPrefSize(400.0, 600.0);

        sendButton.setOnMouseClicked((event -> {
            handleUserInput();
        }));

        userInput.setOnAction((event -> {
            handleUserInput();
        }));

        dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));

        scene = new Scene(mainLayout);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Label getDialogLabel(String text) {
        Label textToAdd = new Label(text);
        textToAdd.setWrapText(true);

        return textToAdd;
    }

    /**
     * Iteration 2:
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    private void handleUserInput() {
        Label userText = new Label(userInput.getText());
        Label dukeText = new Label(getResponse(userInput.getText()));
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(userText, new ImageView(user)),
                DialogBox.getDukeDialog(dukeText, new ImageView(duke))
        );
        userInput.clear();
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    private String getResponse(String input) {
        Command command = null;
        try {
            command = parser.parse(input);
            if (command instanceof ByeCommand) {
                command.execute();
            }
            command.execute();
            io.writeTasks(userHistory.getTaskList());
            return "Test string";
        } catch (MissingInformationException | UnknownCommandException
                | UnknownFormatException | ParseException | NoSuchElementException e) {
            return e.getMessage();
        }
    }
}
