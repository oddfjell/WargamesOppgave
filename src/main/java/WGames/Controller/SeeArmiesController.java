package WGames.Controller;

import WGames.Model.Classes.Filewriter;
import WGames.WApplication;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

    private List<String> chosenArmy;
    @FXML
    public void fileUpload() {
        Filewriter filewriter = new Filewriter();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("src\\main\\resources\\Files"));
        chosenArmy = filewriter.copyCSVFile(fileChooser.showOpenDialog(WApplication.primaryStage));
        String troops = "";
        for(int i = 1; chosenArmy.size() > i; i++){
            troops += chosenArmy.get(i) + "\n";

        }
        System.out.println(troops);
        textInBox.setText(troops);
        nameOfTheArmies.setText(chosenArmy.get(0));
    }

    @FXML
    private TableView armyTable;
    @FXML
    private TableColumn unitString;
    @FXML
    private Button updateTable;
    @FXML
    public void updateTables(){
        if(chosenArmy != null){
            //sett en tekst med navnet

            /*for (String s : chosenArmy) {
                unitString.setCellValueFactory(new PropertyValueFactory<List<String>, String>(s));
            }*/


            unitString.setCellValueFactory(new PropertyValueFactory<>("String"));
            armyTable.setItems(FXCollections.observableArrayList(chosenArmy));

        }
        /*for(String s : chosenArmy){
            unitString.setCellValueFactory(chosenArmy-> s);
        }
        armyTable.setItems(FXCollections.observableArrayList(chosenArmy));*/
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}


}
