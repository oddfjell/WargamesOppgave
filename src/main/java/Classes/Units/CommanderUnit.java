package Classes.Units;

public class CommanderUnit extends CavalryUnit {

    /**
     * Constructor of the CommanderUnit class
     * @param name
     * @param health
     * @param attack
     * @param armor
     */
    public CommanderUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Constructor of the CommanderUnit class with defined values for attack and armor
     * @param name
     * @param health
     */
    public CommanderUnit(String name, int health) {
        super(name, health, 25, 15);
    }

    @Override
    public int getID(){
        return 1;
    }
}
