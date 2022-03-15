package TestResources;

import Classes.Army;
import Classes.Unit;
import Classes.Units.CavalryUnit;
import Classes.Units.CommanderUnit;
import Classes.Units.InfantryUnit;
import Classes.Units.RangedUnit;

import java.util.ArrayList;

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

    /*public ArrayList<Unit> getNotGnotts(){
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
    }*/

    /*public Army premier(){
        ArrayList<Unit> gnotts = getSevralGnotts();
        Army army = new Army("g1", gnotts);
        return army;
    }

    public Army deuxieme(){
        ArrayList<Unit> gnotts = getGnotts();
        Army army = new Army("g2", gnotts);
        return army;
    }*/
}
