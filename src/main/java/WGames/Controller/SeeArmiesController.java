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
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class SeeArmiesController implements Initializable {
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
        /*List<String> armies =
                br.lines().skip(1).collect(Collectors.toList());
        ObservableList<String> armyNames = FXCollections.observableArrayList("CavalryUnit", "CommanderUnit", "InfantryUnit", "RangedUnit");
        unitType.setItems(armyNames);*/
    }


}
