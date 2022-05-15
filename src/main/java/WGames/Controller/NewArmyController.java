package WGames.Controller;

import WGames.WApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class NewArmyController implements Initializable {


    @FXML
    private Button back;

    //@FXML
    //private Button fileUploadButton;


    @FXML
    private ComboBox unitType;

    //@FXML
    //private Text unitAdded;

    @FXML
    void backButtonClicked() throws IOException {
        WApplication.changeScene("/Views/FrontPage.fxml");
    }



    /*@FXML
    public void fileUpload() {
        unitAdded.setVisible(false);
        FileChooser fileChooser = new FileChooser();
        Filewriter filewriter = new Filewriter();
        Army army = filewriter.makeArmyFromFile(fileChooser.showOpenDialog(WApplication.primaryStage));
        System.out.println(army.getAllUnits());
        unitAdded.setVisible(true);
    }*/


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //unitAdded.setVisible(false);
    }

}
