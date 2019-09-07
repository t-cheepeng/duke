import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.Collections;

public class DialogBox extends HBox {

    @FXML
    private Label dialog;
    @FXML
    private ImageView displayPicture;

    private DialogBox(String text, Image imageView) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.setText(text);
        displayPicture.setImage(imageView);
    }

    private void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        Collections.reverse(tmp);
        getChildren().setAll(tmp);
        setAlignment(Pos.TOP_LEFT);
    }

    /**
     * Gets a user dialog for a string and image.
     *
     * @param l Text to display
     * @param iv Image to display
     * @return A dialog box with text and image
     */
    public static DialogBox getUserDialog(String l, Image iv) {
        assert l != null;
        assert iv != null;

        return new DialogBox(l, iv);
    }

    /**
     * Gets a dialog box for Duke.
     * @param l The text duke replies user with
     * @param iv The image of duke
     * @return a dialog box representing duke's reply.
     */
    public static DialogBox getDukeDialog(String l, Image iv) {
        assert l != null;
        assert iv != null;

        var db = new DialogBox(l, iv);
        db.flip();
        return db;
    }
}
