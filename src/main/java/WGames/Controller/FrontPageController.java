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

public class FrontPageController implements Initializable {

    @FXML
    private Button seeArmiesButton;
    @FXML
    private Button commenceBattleButton;
    @FXML
    private Button newArmyButton;

    @FXML
    private Button exit;


    @FXML
    void seeArmiesButtonClicked() throws IOException {
        WApplication.changeScene("/Views/SeeArmies.fxml");
    }

    @FXML
    void commenceBattleButtonClicked() throws IOException {
        WApplication.changeScene("/Views/Battle.fxml");
    }

    @FXML
    void newArmyButtonClicked() throws IOException{
        System.out.println("hekko");
        WApplication.changeScene("/Views/NewArmy.fxml");
    }


    @FXML
    void exitTheGame(){
        System.exit(0);
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
        System.out.println(army.getAllUnits());
        unitAdded.setVisible(true);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        unitAdded.setVisible(false);
    }

}
