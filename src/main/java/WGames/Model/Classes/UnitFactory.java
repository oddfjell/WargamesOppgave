package WGames.Model.Classes;

import WGames.Dialog.Dialog;
import WGames.Model.Units.*;

public class UnitFactory {

    public Unit getUnit(String typeOfUnit, String name, int health){
        try{
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
            //else{
              //  return null;
            //}
        }catch (IllegalArgumentException exception){
            Dialog.error(exception);
        }
        return null;
    }
}
