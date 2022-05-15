package WGames.Controller;

import WGames.WApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    @FXML
    private ComboBox unitType;


    @FXML
    void backButtonClicked() throws IOException {
        WApplication.changeScene("/Views/FrontPage.fxml");
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> u = FXCollections.observableArrayList("CavalryUnit", "CommanderUnit", "InfantryUnit", "RangedUnit");
        unitType.setItems(u);
        /*ObservableList<Terrain> terrains = FXCollections.observableArrayList(Terrain.values());
        unitType.setItems(terrains);*///TODO add to battle
        //unitAdded.setVisible(false);
    }

}
