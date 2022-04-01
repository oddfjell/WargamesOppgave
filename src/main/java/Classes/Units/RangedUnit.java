package Classes.Units;

import Classes.Unit;

public class RangedUnit extends Unit {

    /**
     * Constructor of the RangedUnit class
     * @param name
     * @param health
     * @param attack
     * @param armor
     */
    public RangedUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Constructor of the RangedUnit class with defined values for attack and armor
     * @param name
     * @param health
     */
    public RangedUnit(String name, int health) {
        super(name, health, 15, 8);
    }

    /**
     * the abstract method from Unit has now a body
     * @return attackBonus
     */
    @Override
    public int getAttackBonus(){
        return 3;
    }

    /**
     * the abstract method from Unit has now a body
     * I used int attacked to change the resistance bonus value
     * @return resistBonus
     */
    int attacked = -1;
    @Override
    public int getResistBonus(){
        attacked++;
        switch (attacked){
            case 0: return 6;
            case 1: return 4;
            default: return 2;
        }

    }

    @Override
    public String getID(){
        return "RangedUnit";
    }
}
