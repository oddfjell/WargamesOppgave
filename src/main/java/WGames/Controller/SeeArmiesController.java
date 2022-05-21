package WGames.Controller;

import WGames.Model.Classes.Army;
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
    //TODO midtstill kolonnene



    @FXML
    private Button back;

    @FXML
    void backButtonClicked() throws IOException {
        WApplication.changeScene("/Views/FrontPage.fxml");
    }


    @FXML
    private Text nameOfTheArmies;

    @FXML
    private Button fileUploadButton;

    private Army army;
    @FXML
    public void fileUpload() {
        Filewriter filewriter = new Filewriter();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("src\\main\\resources\\Files"));

        army = filewriter.makeArmyFromFile(fileChooser.showOpenDialog(WApplication.primaryStage));
        nameOfTheArmies.setText(army.getName());

        if(army != null){
            theArmyTableType.setCellValueFactory(new PropertyValueFactory<>("ID"));
            theArmyTableName.setCellValueFactory(new PropertyValueFactory<>("name"));
            theArmyTableHealth.setCellValueFactory(new PropertyValueFactory<>("health"));

            theArmyTable.setItems(FXCollections.observableArrayList(army.getAllUnits()));
        }
    }

    @FXML
    private TableView theArmyTable;
    @FXML
    private TableColumn theArmyTableType;
    @FXML
    private TableColumn theArmyTableName;
    @FXML
    private TableColumn theArmyTableHealth;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}


}
