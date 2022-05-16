package WGames.Controller;

import WGames.Model.Army;
import WGames.Model.Filewriter;
import WGames.WApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AddArmyFromFileController implements Initializable {

    @FXML
    private Button back;

    @FXML
    void backButtonClicked() throws IOException {
        WApplication.changeScene("/Views/FrontPage.fxml");
    }

    @FXML
    private Button fileUploadButton;

    @FXML
    private Text unitAdded;

    @FXML
    public void fileUpload() {
        unitAdded.setVisible(false);
        FileChooser fileChooser = new FileChooser();
        Filewriter filewriter = new Filewriter();
        Army army = filewriter.makeArmyFromFile(fileChooser.showOpenDialog(WApplication.primaryStage));
        filewriter.writeArmyInFile(army);
        System.out.println(army.getAllUnits());
        unitAdded.setVisible(true);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        unitAdded.setVisible(false);
    }

}
