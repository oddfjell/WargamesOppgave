package WGames.Model.Classes;

import java.util.ArrayList;
import java.util.Comparator;

public class Armies {
    //TODO slett

    /*private ArrayList<Army> armies;

    private Armies(){
        this.armies = new ArrayList<>();
    }

    public void addArmy(Army army){
        armies.add(army);
    }

    public void removeArmy(Army army){
        armies.remove(army);
    }

    public ArrayList<Army> listAllArmies(){
        ArrayList<Army> armyArrayList = new ArrayList<Army>(armies);
        armyArrayList.sort(Comparator.comparing(Army::getName));
        return armyArrayList;
    }
    public static Armies getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();

        return single_instance;
    }*/



    private static Armies mInstance;
    private ArrayList<Army> armies = null;

    public static Armies getInstance() {
        if(mInstance == null)
            mInstance = new Armies();

        return mInstance;
    }

    private Armies() {
        armies = new ArrayList<Army>();
    }
    // retrieve array from anywhere
    public ArrayList<Army> getArray() {
        return this.armies;
    }
    //Add element to array
    public void addToArray(Army army) {
        armies.add(army);
    }

    public void removeFromArray(Army army) {
        armies.remove(army);
    }
    public ArrayList<Army> listAllArmies(){
        ArrayList<Army> armyArrayList = new ArrayList<Army>(armies);
        armyArrayList.sort(Comparator.comparing(Army::getName));
        return armyArrayList;
    }

    /*
    Anywhere you need to call your arrayList just do :

    YourSingleton.getInstance().getArray();

    To add elements to array use :

    YourSingleton.getInstance().addToArray("first value");

    or

    YourSingleton.getInstance().getArray().add("any value");
     */

}
