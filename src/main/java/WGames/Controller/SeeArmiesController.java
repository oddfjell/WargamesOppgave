package WGames.Controller;

import WGames.Model.Classes.Filewriter;
import WGames.WApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

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
    public void initialize(URL url, ResourceBundle resourceBundle) {}


}
