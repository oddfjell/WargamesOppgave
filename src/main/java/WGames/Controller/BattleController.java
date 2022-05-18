package WGames.Controller;

import WGames.Dialog.Dialog;
import WGames.Model.Classes.Army;
import WGames.Model.Classes.Battle;
import WGames.Model.Classes.Filewriter;
import WGames.Model.Classes.Terrain;
import WGames.Model.Units.Unit;
import WGames.WApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BattleController implements Initializable {

    @FXML
    private Button back;

    @FXML
    void backButtonClicked() throws IOException {
        WApplication.changeScene("/Views/FrontPage.fxml");
    }




    private Army armyOne;
    private Army armyTwo;
    private Battle battle;
    private Terrain terrain;


    @FXML
    private Button fileUploadButton;
    @FXML
    private ComboBox terrainType;
    @FXML
    private Text terrainText;

    @FXML
    public void fileUpload() {
        try{
            Filewriter filewriter = new Filewriter();
            FileChooser fileChooser = new FileChooser();

            fileChooser.setInitialDirectory(new File("src\\main\\resources\\Files"));
            armyOne = filewriter.makeArmyFromFile(fileChooser.showOpenDialog(WApplication.primaryStage));
            Dialog.information("Now choose another army to battle " + armyOne.getName());
            armyTwo = filewriter.makeArmyFromFile(fileChooser.showOpenDialog(WApplication.primaryStage));

            if(terrainType.getValue()==null){
                terrain = Terrain.DESERT;
            } else{
                terrain = (Terrain) terrainType.getValue();
            }

            battle = new Battle(armyOne,armyTwo, terrain);
            terrainText.setText(String.valueOf(terrain));

            //for(Unit unit:armyOne.getAllUnits()){}

            updateTables();

           // battle.simulate();
            //updateTables();



        } catch (Exception exception){
            Dialog.error(exception);
        }

    }



    @FXML
    private TableView armyOneTable;
    @FXML
    private TableColumn unitTypeArmyOne;
    @FXML
    private TableColumn nameArmyOne;
    @FXML
    private TableColumn healthArmyOne;

    @FXML
    private TableView armyTwoTable;
    @FXML
    private TableColumn unitTypeArmyTwo;
    @FXML
    private TableColumn nameArmyTwo;
    @FXML
    private TableColumn healthArmyTwo;



    @FXML
    public void updateTables(){
        if(armyOne != null){
            //sett en tekst med navnet

            unitTypeArmyOne.setCellValueFactory(new PropertyValueFactory<>("ID"));
            nameArmyOne.setCellValueFactory(new PropertyValueFactory<>("name"));
            healthArmyOne.setCellValueFactory(new PropertyValueFactory<>("health"));


            armyOneTable.setItems(FXCollections.observableArrayList(armyOne.getAllUnits()));

        }
        if(armyTwo != null){
            //sett en tekst med navnet

            unitTypeArmyTwo.setCellValueFactory(new PropertyValueFactory<>("ID"));
            nameArmyTwo.setCellValueFactory(new PropertyValueFactory<>("name"));
            healthArmyTwo.setCellValueFactory(new PropertyValueFactory<>("health"));


            armyTwoTable.setItems(FXCollections.observableArrayList(armyTwo.getAllUnits()));

        }

        armyOneTable.refresh();
        armyTwoTable.refresh();
        //battleAction.setText(Battle.battleText);


        /*
            if army != null
            sett navn
            navncol.settcallvalfac(new property val fac(id eller navn eller health)
            ref
             */


    }

    @FXML
    private Button fight;
    @FXML
    private Text battleAction;
    @FXML
    public void theBattle() throws InterruptedException {
        new Thread(()->{
            while(armyOne.getAllUnits().size() != 0 && armyTwo.getAllUnits().size() != 0){
                battleAction.setText(battle.slowSimulate());
                updateTables();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (armyOne.getAllUnits().size() == 0){
                battleAction.setText(armyTwo + " won");
            } else{
                battleAction.setText(armyOne + " won");
            }
        }).start();



    }






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Terrain> u = FXCollections.observableArrayList(Terrain.values());
        terrainType.setItems(u);
    }
}
