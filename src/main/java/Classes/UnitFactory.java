package Classes;

import Classes.Units.CavalryUnit;
import Classes.Units.CommanderUnit;
import Classes.Units.InfantryUnit;
import Classes.Units.RangedUnit;

public class UnitFactory {
    public static Unit getUnit(Unit unit){
        //eventuelt switch case
        /*if("CavalryUnit".equals(unit.getID()))return new CavalryUnit(unit.getName(), unit.getHealth(), unit.getAttack(), unit.getArmor());
        else if("CommanderUnit".equals(unit.getID()))return new CommanderUnit(unit.getName(), unit.getHealth(), unit.getAttack(), unit.getArmor());
        else if("InfantryUnit".equals(unit.getID()))return new InfantryUnit(unit.getName(), unit.getHealth(), unit.getAttack(), unit.getArmor());
        else if("RangedUnit".equals(unit.getID()))return new RangedUnit(unit.getName(), unit.getHealth(), unit.getAttack(), unit.getArmor());
        else return null;*/
        if("CavalryUnit".equals(unit.getID())){
            unit = new CavalryUnit(unit.getName(), unit.getHealth(), unit.getAttack(), unit.getArmor());
        }
        else if("CommanderUnit".equals(unit.getID())){
            unit = new CommanderUnit(unit.getName(), unit.getHealth(), unit.getAttack(), unit.getArmor());
        }
        else if("InfantryUnit".equals(unit.getID())){
            unit = new InfantryUnit(unit.getName(), unit.getHealth(), unit.getAttack(), unit.getArmor());
        }
        else if("RangedUnit".equals(unit.getID())){
            unit = new RangedUnit(unit.getName(), unit.getHealth(), unit.getAttack(), unit.getArmor());
        }
        else{
            return null;
        }
        return unit;
    }
}
