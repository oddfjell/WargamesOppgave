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
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.scene.image.Image;

import javax.swing.text.Element;
import javafx.scene.image.ImageView;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BattleController implements Initializable {

    //TODO change to winning text
    //TODO make a button to restart the battle

    private Army armyOne;
    private Army armyTwo;
    private Battle battle;
    private Filewriter filewriter = new Filewriter();
    private Terrain terrain;
    private int speed = 1000;

    @FXML
    private Button back;
    @FXML
    private Button confirmTerrainButton;
    @FXML
    private Button fight;
    @FXML
    private Button fileUploadButton;
    @FXML
    private Button restartButton;

    @FXML
    private ComboBox terrainType;

    @FXML
    private TableColumn healthArmyOne;
    @FXML
    private TableColumn healthArmyTwo;
    @FXML
    private TableColumn nameArmyOne;
    @FXML
    private TableColumn nameArmyTwo;
    @FXML
    private TableColumn unitTypeArmyOne;
    @FXML
    private TableColumn unitTypeArmyTwo;

    @FXML
    private TableView armyOneTable;
    @FXML
    private TableView armyTwoTable;

    @FXML
    private Text armyOneName;
    @FXML
    private Text armyTwoName;
    @FXML
    private Text battleAction;
    @FXML
    private Text terrainSelect;
    @FXML
    private Text terrainText;





    @FXML
    void backButtonClicked() throws IOException {
        WApplication.changeScene("/Views/FrontPage.fxml");
    }

    @FXML
    public void fileUpload() {
        try{

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

            setTerrainImage(terrain);

            battle = new Battle(armyOne,armyTwo, terrain);
            terrainText.setText(String.valueOf(terrain));
            armyOneName.setText(armyOne.getName());
            armyTwoName.setText(armyTwo.getName());

            //fileUploadButton.setVisible(false);
            //terrainType.setVisible(false);
            //terrainSelect.setVisible(false);

            updateTables();

        } catch (Exception exception){
            Dialog.error(exception);
        }

    }

    @FXML
    public void updateTables(){
        if(armyOne != null){

            unitTypeArmyOne.setCellValueFactory(new PropertyValueFactory<>("ID"));
            nameArmyOne.setCellValueFactory(new PropertyValueFactory<>("name"));
            healthArmyOne.setCellValueFactory(new PropertyValueFactory<>("health"));


            //System.out.println(armyOne.getAllUnits());
            armyOneTable.setItems(FXCollections.observableArrayList(armyOne.getAllUnits()));

        }
        if(armyTwo != null){

            unitTypeArmyTwo.setCellValueFactory(new PropertyValueFactory<>("ID"));
            nameArmyTwo.setCellValueFactory(new PropertyValueFactory<>("name"));
            healthArmyTwo.setCellValueFactory(new PropertyValueFactory<>("health"));


            //System.out.println(armyTwo.getAllUnits());
            armyTwoTable.setItems(FXCollections.observableArrayList(armyTwo.getAllUnits()));

        }

        armyOneTable.refresh();
        armyTwoTable.refresh();
    }

    @FXML
    private void handleClickTableViewOne(MouseEvent click) {
        if(armyOne!= null){
            Object o = armyOneTable.getSelectionModel().getSelectedItem();
            //System.out.println(o);
            Dialog.tableInformation(o);
        }
    }

    @FXML
    private void handleClickTableViewTwo(MouseEvent click) {
        if(armyTwo!= null){
            Object o = armyTwoTable.getSelectionModel().getSelectedItem();
            //System.out.println(o);
            Dialog.tableInformation(o);
        }
    }

    @FXML
    public void theBattle() throws InterruptedException, FileNotFoundException {
        restartButton.setDisable(true);
        fileUploadButton.setDisable(true);
       // terrainImage = new ImageView((Element) new Image(BattleController.class.getResourceAsStream("Pictures\\HILL.png")));



        try {
            if(armyOne.getAllUnits().size() != 0 && armyTwo.getAllUnits().size() != 0 && armyOne.getRandom() != null && armyTwo.getRandom() != null){
                new Thread(()->{
                    while(armyOne.getAllUnits().size() != 0 && armyTwo.getAllUnits().size() != 0 && armyOne.getRandom() != null && armyTwo.getRandom() != null){
                        if(battle.slowSimulate().equals("stalemate")){
                            battleAction.setText(battle.slowSimulate());
                            break;
                        }
                        battleAction.setText(battle.slowSimulate());
                        updateTables();
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    if (armyOne.getAllUnits().size() == 0 && armyTwo.getAllUnits().size() != 0){
                        battleAction.setText(armyTwo.getName() + " won with " + armyTwo.getAllUnits().size() + " units left");
                    } else if(armyTwo.getAllUnits().size() == 0 && armyOne.getAllUnits().size() != 0){
                        battleAction.setText(armyOne.getName() + " won with " + armyOne.getAllUnits().size() + " units left");
                    } else if (armyOne.getAllUnits().size() == 1 && armyTwo.getAllUnits().size() == 1 && !battleAction.getText().equals("stalemate")){
                        battleAction.setText("restarted");
                    }
                    restartButton.setDisable(false);
                    fileUploadButton.setDisable(false);
                }).start();
            } else{
                throw new IllegalArgumentException("You must choose armies before the war can start");
            }

        } catch (Exception exception){
            Dialog.error(exception);
        }


    }



    @FXML
    public void restart(){
        armyOneTable.getItems().clear();
        armyTwoTable.getItems().clear();

        armyOne = filewriter.makeArmyFromFile(new File("src\\main\\resources\\Files\\" + armyOne.getName() + ".csv"));
        armyTwo = filewriter.makeArmyFromFile(new File("src\\main\\resources\\Files\\" + armyTwo.getName() + ".csv"));


        //terrainText.setText("");
        //battleAction.setText("");

        speed = 1000;

        battle = new Battle(armyOne,armyTwo, terrain);

        updateTables();

        /*for(Unit unit: armyOne.getAllUnits()){
            armyOne.remove(unit);
        }
        for(Unit unit: armyTwo.getAllUnits()){
            armyTwo.remove(unit);
        }*/

        //fileUploadButton.setVisible(true);
        //terrainType.setVisible(true);
        //terrainSelect.setVisible(true);

    }



    @FXML
    public void confirmTerrain(){
        if(terrainType.getValue()==null){
            terrain = Terrain.DESERT;
        } else{
            terrain = (Terrain) terrainType.getValue();
        }
        if(armyOne != null && armyTwo != null){
            battle = new Battle(armyOne,armyTwo, terrain);
        } else {
            System.out.println(88888);
        }
        setTerrainImage(terrain);
        terrainText.setText(String.valueOf(terrain));
        System.out.println(terrain);
    }


    @FXML
    private Button halfSpeedButton;
    @FXML
    private Button normalSpeedButton;
    @FXML
    private Button oneQuarterSpeedButton;
    @FXML
    private Button doubleSpeedButton;
    @FXML
    private Button quadrupleSpeedButton;
    @FXML
    private Button doubleQuadrupleSpeedButton;
    @FXML
    private Button quadrupleQuadrupleSpeedButton;

    @FXML
    public void halfSpeed(){
        speed = 2000;
    }
    @FXML
    public void normalSpeed(){
        speed = 1000;
    }
    @FXML
    public void oneQuarterSpeed(){
        speed = 4000;
    }
    @FXML
    public void doubleSpeed(){
        speed = 500;
    }
    @FXML
    public void quadrupleSpeed(){
        speed = 250;
    }
    @FXML
    public void doubleQuadrupleSpeed(){
        speed = 125;
    }
    @FXML
    public void quadrupleQuadrupleSpeed(){
        speed = 62;
    }


    @FXML
    private Pane terrainImage;

    private  ImageView imageView;

    public void setTerrainImage(Terrain terrain){
        terrainImage.getChildren().remove(imageView);
        imageView = new ImageView(new Image(BattleController.class.getResourceAsStream("/Pictures/" + terrain + ".png")));
        if(terrain.equals(Terrain.FOREST) || terrain.equals(Terrain.PLAINS) ){
            imageView.fitWidthProperty().bind(terrainImage.widthProperty());
            imageView.fitHeightProperty().bind(terrainImage.heightProperty());
        }
        terrainImage.getChildren().add(imageView);

        //570x og 8y på desert
    }

    /*@FXML
    private Pane imagePane;*/


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Terrain> u = FXCollections.observableArrayList(Terrain.values());
        terrainType.setItems(u);
        restartButton.setDisable(true);

        imageView = new ImageView(new Image(BattleController.class.getResourceAsStream("/Pictures/DESERT.png")));
        terrainImage.getChildren().add(imageView);



        //terrainImage = new ImageView(new Image(new FileInputStream("src\\main\\resources\\Pictures\\DESERT.png")));

       // ImageView imageView = new ImageView(new Image(BattleController.class.getResourceAsStream("src\\main\\resources\\Pictures\\DESERT.png")));

        /*Image image = new Image(BattleController.class.getResourceAsStream("src\\main\\resources\\Pictures\\DESERT.png"));
        terrainImage = new ImageView((Element) image);*/

       // terrainImage = new Image(BattleController.class.getResourceAsStream("src\\main\\resources\\Pictures\\DESERT.png"));

        //terrainImage.getImage(new Image("src\\main\\resources\\Pictures\\DESERT.png")));

        //terrainImage.setImage(new Image(BattleController.class.getResourceAsStream("src\\main\\resources\\Pictures\\DESERT.png")));
    }
}
