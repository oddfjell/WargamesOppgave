package WGames.Model;

import java.util.ArrayList;
import java.util.Comparator;

public class Armies {

    private ArrayList<Army> armies;

    public Armies(){
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

}
