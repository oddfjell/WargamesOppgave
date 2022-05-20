package WGames.Controller;

import WGames.Dialog.Dialog;
import WGames.Model.Classes.Army;
import WGames.Model.Classes.Filewriter;
import WGames.Model.Classes.UnitFactory;
import WGames.Model.Units.Unit;
import WGames.WApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;


public class NewArmyController implements Initializable {

    //TODO fix delete unit
    //TODO the user can make several units from one button click
    //make a textfield for the number or a combobox up til 1000

    //TODO remove confirm


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
        try {
            UnitFactory unitFactory = new UnitFactory();
            Filewriter filewriter = new Filewriter();

            List<Unit> units = new ArrayList<>();
            //Army army = new Army(armyName.getText(), units);


            Army army;
            if(!armyName.getText().trim().equals("")){
                army = new Army(armyName.getText(), units);
            } else {
                throw new IllegalArgumentException("The army must have a name");
            }

            Unit unit = null;


            String nameOfTheArmy = armyName.getText();
            if (name.getText() != null && health.getText() != null && unitType.getValue() != null) {

                String unitName;
                if(!name.getText().trim().equals("")){
                    unitName = name.getText().trim();
                } else{
                    throw new IllegalArgumentException("The unit must have a name");
                }
                int unitHealth;
                if(Integer.parseInt(health.getText()) == (int)Integer.parseInt(health.getText())){
                    unitHealth = Integer.parseInt(health.getText());
                }else{
                    throw new IllegalArgumentException("The health must be an integer");
                }
                String typeOfUnit = String.valueOf(unitType.getValue());
                unit = unitFactory.getUnit(typeOfUnit, unitName, unitHealth);
                standardUnitText.setText(unit.toString());

            } else {
                throw new IllegalArgumentException("Please fill in the boxes");
            }

            if (!(new File("src\\main\\resources\\Files\\" + armyName.getText() + ".csv")).exists()) {
                army.add(unit);
                filewriter.writeArmyInFile(army);
            } else {
                filewriter.writeData(armyName.getText(), unit);
            }
        }catch (IllegalArgumentException e){
                Dialog.error(e);
            }

        //back button skrive til fil
        //om army fil eksisterer putter man nye units inn i dan gamle filen
        //ellers lages det en ny fil

        //new army/edit army

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
    private Button standardUnitBox;
    @FXML
    private Text standardUnitText;
    @FXML
    public void makeStandardUnit(){
        try{

            UnitFactory unitFactory = new UnitFactory();
            Unit unit = null;

            Filewriter filewriter = new Filewriter();
            List<Unit> units = new ArrayList<>();
            Army army;
            if(!armyName.getText().trim().equals("")){
                army = new Army(armyName.getText(), units);
            } else {
                throw new IllegalArgumentException("The army must have a name");
            }

            if (unitType.getValue() != null) {
                String typeOfUnit = String.valueOf(unitType.getValue());
                Random random = new Random();
                int unitHealth = random.nextInt(50) + 1;
                unit = unitFactory.getUnit(typeOfUnit, typeOfUnit, unitHealth);
                System.out.println(unit.toString());
                standardUnitText.setText(unit.toString());
            }else {
                throw new IllegalArgumentException("Please choose the unit type from the box above");
            }


            if (!(new File("src\\main\\resources\\Files\\" + armyName.getText() + ".csv")).exists() && unit!=null) {
                army.add(unit);
                filewriter.writeArmyInFile(army);
            } else {
                filewriter.writeData(armyName.getText(), unit);
            }



        }catch (IllegalArgumentException exception){
            Dialog.error(exception);
        }
        //choose the unit type from the box
    }





    @FXML
    private ComboBox unitType;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> u = FXCollections.observableArrayList("CavalryUnit", "CommanderUnit", "InfantryUnit", "RangedUnit", "BlackMage", "WhiteMage");
        unitType.setItems(u);
        /*ObservableList<Terrain> terrains = FXCollections.observableArrayList(Terrain.values());
        unitType.setItems(terrains);*///TODO add to battle
        //unitAdded.setVisible(false);
    }

}
