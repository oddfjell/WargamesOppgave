package WGames.Controller;

import WGames.WApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class BattleController {

    @FXML
    private Button back;

    @FXML
    void backButtonClicked() throws IOException {
        WApplication.changeScene("/Views/FrontPage.fxml");
    }
}
