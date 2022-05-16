package WGames.Controller;

import WGames.Model.Army;
import WGames.Model.Filewriter;
import WGames.WApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class SeeArmiesController implements Initializable {
    @FXML
    private Button back;

    @FXML
    void backButtonClicked() throws IOException {
        WApplication.changeScene("/Views/FrontPage.fxml");
    }



    @FXML
    private Text nameOfTheArmies;

    @FXML
    private Text textInBox;

    @FXML
    private Button fileUploadButton;

    @FXML
    public void fileUpload() {
        //unitAdded.setVisible(false);
        Filewriter filewriter = new Filewriter();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("src\\main\\resources\\Files"));
        List<String> chosenArmy = filewriter.copyCSVFile(fileChooser.showOpenDialog(WApplication.primaryStage));
        String troops = "";
        for(int i = 1; chosenArmy.size() > i; i++){
            troops += chosenArmy.get(i) + "\n";

        }
        System.out.println(troops);
        textInBox.setText(troops);
        nameOfTheArmies.setText(chosenArmy.get(0));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //unitAdded.setVisible(false);
        /*List<String> armies =
                br.lines().skip(1).collect(Collectors.toList());
        ObservableList<String> armyNames = FXCollections.observableArrayList("CavalryUnit", "CommanderUnit", "InfantryUnit", "RangedUnit");
        unitType.setItems(armyNames);*/
    }


}
