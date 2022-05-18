package WGames.Controller;

import WGames.Dialog.Dialog;
import WGames.Model.Classes.Army;
import WGames.Model.Classes.Battle;
import WGames.Model.Classes.Filewriter;
import WGames.Model.Classes.Terrain;
import WGames.WApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BattleController implements Initializable {

    @FXML
    private Button back;

    @FXML
    void backButtonClicked() throws IOException {
        WApplication.changeScene("/Views/FrontPage.fxml");
    }




    private Army armyOne;
    private Army armyTwo;
    private Battle battle;
    private Terrain terrain;


    @FXML
    private Button fileUploadButton;
    @FXML
    private ComboBox terrainType;
    @FXML
    private Text terrainText;

    @FXML
    public void fileUpload() {
        try{
            Filewriter filewriter = new Filewriter();
            FileChooser fileChooser = new FileChooser();

            fileChooser.setInitialDirectory(new File("src\\main\\resources\\Files"));
            armyOne = filewriter.makeArmyFromFile(fileChooser.showOpenDialog(WApplication.primaryStage));
            Dialog.information("Now choose another army to battle " + armyOne.getName());
            armyTwo = filewriter.makeArmyFromFile(fileChooser.showOpenDialog(WApplication.primaryStage));

            if(terrainType.getValue()==null){
                terrain = Terrain.DESERT;
            } else{
                terrain = (Terrain) terrainType.getValue();
            }

            battle = new Battle(armyOne,armyTwo, terrain);
            terrainText.setText(String.valueOf(terrain));

        } catch (Exception exception){
            Dialog.error(exception);
        }

    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Terrain> u = FXCollections.observableArrayList(Terrain.values());
        terrainType.setItems(u);
    }
}
