package Units;

public class CavalryUnit extends Unit{

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
     * @return attackBonus
     */
    @Override
    public int getAttackBonus(){
        //TODO fiks
        return 2;
    }

    /**
     * the abstract method from Unit now has a body
     * @return resistBonus
     */
    @Override
    public int getResistBonus(){
        return 1;
    }
}
