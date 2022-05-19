package WGames.Controller;

import WGames.Model.Classes.Filewriter;
import WGames.WApplication;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    //TODO fiks denne sida



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
        nameOfTheArmies.setText(chosenArmy.get(0));
        chosenArmy.remove(0);
        /*String troops = "";
        for(int i = 1; chosenArmy.size() > i; i++){
            troops += chosenArmy.get(i) + "\n";

        }
        System.out.println(troops);
        textInBox.setText(troops);*/

    }

    @FXML
    private TableView armyTable;
    @FXML
    private TableColumn<String, String> unitString;
    @FXML
    private Button updateTable;
    @FXML
    public void updateTables(){
        if(chosenArmy != null){
            ObservableList<String> unitList = FXCollections.observableArrayList(chosenArmy);
            unitString.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
            armyTable.setItems(unitList);

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}


}
