package WGames.Controller;

import WGames.WApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
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
    private TextField attack;
    @FXML
    private TextField armor;


    @FXML
    private Button addUnitButton;
    @FXML
    private Button removeUnitButton;

    @FXML
    void addUnitButtonClicked() throws IllegalArgumentException{
        if(name.getText()!=null && health.getText()!=null && attack.getText()!=null && armor.getText()!=null && unitType.getValue()!=null){
            String unitName = name.getText();
            int unitHealth = Integer.parseInt(health.getText());
            int unitAttack = Integer.parseInt(attack.getText());
            int unitArmor = Integer.parseInt(armor.getText());
            String typeOfUnit = String.valueOf(unitType.getValue());
        } else if(name.getText()!=null && health.getText()!=null && unitType.getValue()!=null){
            String unitName = name.getText();
            int unitHealth = Integer.parseInt(health.getText());
            String typeOfUnit = String.valueOf(unitType.getValue());
        } else{
            throw new IllegalArgumentException("Illegal unit format");
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
