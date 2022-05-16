package WGames.Dialog;

import WGames.WApplication;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;


public class Dialog {

    public static void error(Exception exception){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("");
        alert.setContentText(exception.getMessage());
        alert.initOwner(WApplication.primaryStage);

        alert.showAndWait();
    }
}
