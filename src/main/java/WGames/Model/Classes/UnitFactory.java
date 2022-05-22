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

    /**
     * Method which makes a new unit. It checks which ID fits the parameter and
     * makes that unit.
     * @param typeOfUnit typeOfUnit
     * @param name name
     * @param health health
     * @return Unit
     * @throws IllegalArgumentException illegal argument exception
     */
    public Unit getUnit(String typeOfUnit, String name, int health) throws IllegalArgumentException{
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
            } else{
                throw new IllegalArgumentException("This is not a defined unit");
            }
        }catch (Exception exception){
            Dialog.error(exception);
        }
        return null;
    }
}
