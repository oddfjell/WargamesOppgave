package WGames.Model.Classes;

import WGames.Dialog.Dialog;
import WGames.Model.Units.*;
import WGames.Model.Units.Mages.BlackMage;
import WGames.Model.Units.Mages.WhiteMage;
import WGames.Model.Units.Standard.CavalryUnit;
import WGames.Model.Units.Standard.CommanderUnit;
import WGames.Model.Units.Standard.InfantryUnit;
import WGames.Model.Units.Standard.RangedUnit;

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
            else if("BlackMage".equals(typeOfUnit)){
                return new BlackMage(name, health);
            }
            else if("WhiteMage".equals(typeOfUnit)){
                return new WhiteMage(name, health);
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
