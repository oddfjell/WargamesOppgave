package TestResources;

import Classes.Army;
import Classes.Unit;
import Classes.Units.CavalryUnit;
import Classes.Units.CommanderUnit;
import Classes.Units.InfantryUnit;
import Classes.Units.RangedUnit;

import java.util.ArrayList;

/**
 * UnitsGnotts is used by the class ArmyTest to test the Army class//TODO
 */

public class UnitsGnotts {
    public RangedUnit getGnott1(){
        RangedUnit gnott1 = new RangedUnit("Stella", 10);
        return gnott1;
    }

    public CavalryUnit getGnott2(){
        CavalryUnit gnott2 = new CavalryUnit("Kaisa", 20);
        return gnott2;
    }

    public InfantryUnit getGnott3(){
        InfantryUnit gnott3 = new InfantryUnit("Tander", 5);
        return gnott3;
    }

    public CommanderUnit getGnott4(){
        CommanderUnit gnott4 = new CommanderUnit("Sanpler", 1);
        return gnott4;
    }

    public ArrayList<Unit> getGnotts(){
        ArrayList<Unit> gnotts = new ArrayList<>();
        return gnotts;
    }

    public ArrayList<Unit> getSevralGnotts(){
        ArrayList<Unit> gnotts = new ArrayList<>();
        gnotts.add(getGnott1());
        gnotts.add(getGnott2());
        gnotts.add(getGnott3());
        gnotts.add(getGnott4());
        return gnotts;
    }

    public Army premier(){
        ArrayList<Unit> gnotts = getSevralGnotts();
        Army army = new Army("g1", gnotts);
        return army;
    }

    public Army deuxieme(){
        ArrayList<Unit> gnotts = getGnotts();
        Army army = new Army("g2", gnotts);
        return army;
    }
}
