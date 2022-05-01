package TestResources;

import WGames.Model.Army;
import WGames.Model.Unit;
import WGames.Model.Units.CavalryUnit;
import WGames.Model.Units.CommanderUnit;
import WGames.Model.Units.InfantryUnit;
import WGames.Model.Units.RangedUnit;

import java.util.ArrayList;

/**
 * UnitsotGnotts is used as test data
 */

public class UnitsNotGnotts {

    public RangedUnit getBard(){
        RangedUnit bard = new RangedUnit("Jaskier", 20);
        return bard;
    }

    public CavalryUnit getMountedForce(){
        CavalryUnit mountedForce = new CavalryUnit("Monty", 50);
        return mountedForce;
    }

    public InfantryUnit getChristian(){
        InfantryUnit christian = new InfantryUnit("The spanish inquisition", 200);
        return christian;
    }

    public CommanderUnit getDictator(){
        CommanderUnit dictator = new CommanderUnit("Borat", 5);
        return dictator;
    }

    public ArrayList<Unit> getNotGnotts(){
        ArrayList<Unit> herd = new ArrayList<>();
        return herd;
    }

    public ArrayList<Unit> getSevralNotGnotts(){
        ArrayList<Unit> herd = new ArrayList<>();
        herd.add(getBard());
        herd.add(getMountedForce());
        herd.add(getChristian());
        herd.add(getDictator());
        return herd;
    }

    public Army premier(){
        ArrayList<Unit> herd = getSevralNotGnotts();
        Army army = new Army("f4", herd);//"The fantastic four"
        return army;
    }

    public Army deuxieme(){
        ArrayList<Unit> herd = getNotGnotts();
        Army army = new Army("No one", herd);
        return army;
    }
}
