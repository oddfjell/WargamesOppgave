package Classes;

public abstract class Unit {
    private String name, terrain;
    private int health;
    private final int attack, armor;

    //TODO fiks javadoc etter terrain (get, set og inne i klassene)

    /**
     * The constructor of the Unit class
     * @param name name
     * @param health health
     * @param attack attack
     * @param armor armor
     * @param terrain terrain
     */
    public Unit(String name, int health, int attack, int armor, String terrain){
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
        this.terrain = terrain;
    }

    /**
     * method for attacking an opponent
     * the if-method is to prevent the opponent from gaining life
     * @param opponent opponent
     */
    public void attack(Unit opponent){
        if ((this.attack + this.getAttackBonus()) > (this.armor + this.getResistBonus())){
            int opponentHealth = opponent.getHealth() - (this.attack + this.getAttackBonus()) + (opponent.getArmor()+ opponent.getResistBonus());
            System.out.println(this.getName() + " attacks " + opponent.getName());
            opponent.setHealth(opponentHealth);
        }
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
     * gets the terrain/environment which the unit is in
     * @return terrain
     */
    public String getTerrain(){
        return terrain.toUpperCase().trim();
    }

    /**
     * sets the terrain/environment which the unit is in
     * @param terrain terrain
     */
    public void setTerrain(String terrain){
        this.terrain = terrain.toUpperCase().trim();
    }

    /**
     * toString method
     * @return String
     */
    @Override
    public String toString(){
        return this.getID() + "\nName: " + this.getName() + "\nHealth: " + this.getHealth() + "\nAttack: " + this.getAttack() + " (" + this.getAttackBonus() + ")\nArmor: " + this.getArmor() + " (" + this.getResistBonus() + ")";
    }

    /**
     * abstract class which gets the attack bonus
     */
    public abstract int getAttackBonus();

    /**
     * abstract class which gets the resist bonus
     */
    public abstract int getResistBonus();

    /**
     * abstract class which gets the type of unit as an identification string
     */
    public abstract String getID();

}
