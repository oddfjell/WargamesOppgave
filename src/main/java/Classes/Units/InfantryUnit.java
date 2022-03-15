package Classes.Units;

import Classes.Unit;

public class InfantryUnit extends Unit {

    /**
     * Constructor of the InfantryUnit class
     * @param name
     * @param health
     * @param attack
     * @param armor
     */
    public InfantryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Constructor of the InfantryUnit class with defined values for attack and armor
     * @param name
     * @param health
     */
    public InfantryUnit(String name, int health) {
        super(name, health, 15, 10);
    }

    /**
     * the abstract method from Unit has now a body
     * @return attackBonus
     */
    @Override
    public int getAttackBonus(){
        return 2;
    }

    /**
     * the abstract method from Unit has now a body
     * @return resistBonus
     */
    @Override
    public int getResistBonus(){
        return 1;
    }
}
