package WGames.Controller;

import WGames.WApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

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
    private Button addArmyFromFileButton;

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
    void addArmyFromFileButtonClicked() throws IOException {
        WApplication.changeScene("/Views/AddArmiesFromFile.fxml");
    }




    @FXML
    void exitTheGame(){
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }





/*
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
    }*/

}
