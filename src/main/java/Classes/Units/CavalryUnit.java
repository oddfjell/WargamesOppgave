package Classes.Units;

import Classes.Unit;

public class CavalryUnit extends Unit {

    /**
     * Constructor of the CavalryUnit class
     * @param name
     * @param health
     * @param attack
     * @param armor
     */
    public CavalryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Constructor of the CavalryUnit class with defined values for attack and armor
     * @param name
     * @param health
     */
    public CavalryUnit(String name, int health) {
        super(name, health, 20, 12);
    }

    /**
     * the abstract method from Unit has now a body
     * I used int attacking to change the attack bonus value
     * @return attackBonus
     */
    int attacking = -1;
    @Override
    public int getAttackBonus(){
        attacking++;
        switch (attacking){
            case 0: return 6;
            default: return 2;
        }
    }

    /**
     * the abstract method from Unit now has a body
     * @return resistBonus
     */
    @Override
    public int getResistBonus(){
        return 1;
    }

    @Override
    public int getID(){
        return 0;
    }
}
