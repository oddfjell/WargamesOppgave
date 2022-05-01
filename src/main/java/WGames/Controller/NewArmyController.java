package WGames.Controller;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


import WGames.Model.Filewriter;
import WGames.WApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class NewArmyController implements Initializable {

    //String name;

    @FXML
    private Button back;

    @FXML
    private Button fileUploadButton;

    /*@FXML
    private TextField armyName;
    @FXML
    private Button aNButton;*/

    @FXML
    private ComboBox unitType;

    @FXML
    void backButtonClicked() throws IOException {
        WApplication.changeScene("/Views/FrontPage.fxml");
    }



  /*@FXML
   void setArmyName(){
       name = armyName.getText();
   }*/




    private Desktop desktop = Desktop.getDesktop();
    FileChooser fileChooser = new FileChooser();

    @FXML
    void fileUpload() {
        File file = fileChooser.showOpenDialog(WApplication.primaryStage);
        if (file != null) {
            openFile(file);
        }
    }

    private void openFile(File file) {
        try {
            //Filewriter filewriter = new Filewriter();
            //TODO What is its name?

            //filewriter.makeArmyFromFile(name);
            System.out.println("yes");

            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                    WApplication.class.getName()).log(
                    Level.SEVERE, null, ex
            );
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> units = FXCollections.observableArrayList("CavalryUnit", "CommanderUnit", "InfantryUnit", "RangedUnit");
        unitType.setItems(units);
    }
}
