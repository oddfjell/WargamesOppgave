package WGames.Model;

import WGames.Model.Units.CavalryUnit;
import WGames.Model.Units.CommanderUnit;
import WGames.Model.Units.InfantryUnit;
import WGames.Model.Units.RangedUnit;

public class UnitFactory {

    public Unit getUnit(String typeOfUnit, String name, int health){
        if("CavalryUnit".equals(typeOfUnit)){
            CavalryUnit unit = new CavalryUnit(name, health);
            return unit;
        }
        else if("CommanderUnit".equals(typeOfUnit)){
            CommanderUnit unit = new CommanderUnit(name, health);
            return unit;
        }
        else if("InfantryUnit".equals(typeOfUnit)){
            InfantryUnit unit = new InfantryUnit(name, health);
            return unit;
        }
        else if("RangedUnit".equals(typeOfUnit)){
            RangedUnit unit = new RangedUnit(name, health);
            return unit;
        }
        else{
            return null;
        }
    }
}
