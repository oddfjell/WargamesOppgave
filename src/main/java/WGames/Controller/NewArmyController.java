package WGames.Controller;

import WGames.Model.Army;
import WGames.Model.Filewriter;
import WGames.Model.UnitFactory;
import WGames.Model.Units.Unit;
import WGames.WApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;


public class NewArmyController implements Initializable {


    @FXML
    private Button back;
    @FXML
    void backButtonClicked() throws IOException {
        WApplication.changeScene("/Views/FrontPage.fxml");
    }

    @FXML
    private TextField name;
    @FXML
    private TextField health;



    @FXML
    private Button addUnitButton;
    @FXML
    private Button removeUnitButton;

    @FXML
    void addUnitButtonClicked() throws IllegalArgumentException{
        UnitFactory unitFactory = new UnitFactory();
        Filewriter filewriter = new Filewriter();

        List<Unit> units = new ArrayList<>();
        Army army = new Army(armyName.getText(), units);

        Unit unit;


        String nameOfTheArmy = armyName.getText();
        if(name.getText()!=null && health.getText()!=null && unitType.getValue()!=null){
            String unitName = name.getText();
            int unitHealth = Integer.parseInt(health.getText());
            String typeOfUnit = String.valueOf(unitType.getValue());
            unit = unitFactory.getUnit(typeOfUnit, unitName, unitHealth);
        } else if(unitType.getValue()!=null){
            String typeOfUnit = String.valueOf(unitType.getValue());
            Random random = new Random();
            int unitHealth = random.nextInt(50) + 1;
            unit = unitFactory.getUnit(typeOfUnit, typeOfUnit, unitHealth);
        } else{
            throw new IllegalArgumentException("Illegal unit format");
        }

        if(!(new File( "src\\main\\resources\\Files\\" + armyName.getText() + ".csv")).exists()){
            filewriter.writeArmyInFile(army);
        } else{
            filewriter.writeData(armyName.getText(), unit);
        }


        //back button skrive til fil
        //om army fil eksisterer putter man nye units inn i dan gamle filen
        //ellers lages det en ny fil

        //new army/edit army

        /*
        String username = userField.getText();
    String passw = passField.getText();
         */
    }

    @FXML
    private Button confirm;
    @FXML
    private TextField armyName;
    @FXML
    public void confirmButtonClicked(){
        armyName.setEditable(false);
    }





    @FXML
    private ComboBox unitType;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> u = FXCollections.observableArrayList("CavalryUnit", "CommanderUnit", "InfantryUnit", "RangedUnit");
        unitType.setItems(u);
        /*ObservableList<Terrain> terrains = FXCollections.observableArrayList(Terrain.values());
        unitType.setItems(terrains);*///TODO add to battle
        //unitAdded.setVisible(false);
    }

}
