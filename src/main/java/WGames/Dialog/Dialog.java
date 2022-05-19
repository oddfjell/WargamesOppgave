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

    public static void information(String string){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFORMATION");
        alert.setHeaderText("");
        alert.setContentText(string);
        alert.initOwner(WApplication.primaryStage);

        alert.showAndWait();
    }

    public static void tableInformation(Object object){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("TABLE INFORMATION");
        alert.setHeaderText("Information about the unit");
        alert.setContentText(String.valueOf(object));
        alert.initOwner(WApplication.primaryStage);

        alert.showAndWait();
    }

}
