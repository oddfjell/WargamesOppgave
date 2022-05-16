package WGames.Model;

import WGames.Model.Units.*;

public class UnitFactory {

    public Unit getUnit(String typeOfUnit, String name, int health){
        if("CavalryUnit".equals(typeOfUnit)){
            return new CavalryUnit(name, health);
        }
        else if("CommanderUnit".equals(typeOfUnit)){
            return new CommanderUnit(name, health);
        }
        else if("InfantryUnit".equals(typeOfUnit)){
            return new InfantryUnit(name, health);
        }
        else if("RangedUnit".equals(typeOfUnit)){
            return new RangedUnit(name, health);
        }
        else{
            return null;
        }
    }
}
