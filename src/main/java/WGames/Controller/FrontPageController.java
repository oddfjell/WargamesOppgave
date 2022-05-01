package WGames.Controller;

import WGames.WApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class FrontPageController {

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

}
