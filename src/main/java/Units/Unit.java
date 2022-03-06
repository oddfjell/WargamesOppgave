package Units;

public abstract class Unit {
    private String name;
    private int health;
    private final int attack, armor;

    /**
     * The constructor of the Unit class
     * @param name name
     * @param health health
     * @param attack attack
     * @param armor armor
     */
    public Unit(String name, int health, int attack, int armor){
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    /**
     * method for attacking an opponent
     * @param opponent opponent
     */
    public void attack(Unit opponent){
        int opponentHealth = opponent.getHealth() - (this.attack + this.getAttackBonus()) + (this.armor + this.getResistBonus());
        System.out.println(this.getName() + " attacks " + opponent.getName());
        opponent.setHealth(opponentHealth);
    }

    /**
     * gets the name of the unit
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * gets the health of the unit
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * gets the attack of the unit
     * @return attack
     */
    public int getAttack() {
        return attack;
    }

    /**
     * gets the armor of the unit
     * @return armor
     */
    public int getArmor() {
        return armor;
    }

    /**
     * sets the health of an unit
     * @param health health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * toString method
     * @return String
     */
    @Override
    public String toString(){
        return "Name: " + this.getName() + "\nHealth: " + this.getHealth() + "\nAttack: " + this.getAttack() + " (" + this.getAttackBonus() + ")\nArmor: " + this.getArmor() + " (" + this.getResistBonus() + ")";
    }

    /**
     * abstract class which gets the attack bonus
     */
    public abstract int getAttackBonus();

    /**
     * abstract class which gets the resist bonus
     */
    public abstract int getResistBonus();
}
