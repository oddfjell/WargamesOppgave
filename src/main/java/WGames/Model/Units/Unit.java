package WGames.Model.Units;

import WGames.Model.Terrain;

import java.util.Objects;

public abstract class Unit {
    private final String name;
    private int health;
    private final int attack, armor;

    /**
     * The constructor of the Unit class
     * @param name name
     * @param health health
     * @param attack attack
     * @param armor armor
     */
    public Unit(String name, int health, int attack, int armor) throws IllegalArgumentException{
        if(!Objects.equals(name, "")){
            this.name = name;
        } else{
            throw new IllegalArgumentException("The unit must have a name");
        }

        if(health>0 && health<=500){
            this.health = health;
        }else{
            throw new IllegalArgumentException("The health must be a positive integer between 1 and 500");
        }

        if(attack>0 && attack<=100){
            this.attack = attack;
        }else{
            throw new IllegalArgumentException("The attack must be a positive integer between 1 and 100");
        }

        if(armor>=0 && armor<=100){
            this.armor = armor;
        }else{
            throw new IllegalArgumentException("The armor must be a positive integer between 1 and 100");
        }


        /*
        try{
            this.name = name;
            this.health = health;
            this.attack = attack;
            this.armor = armor;
        }
        catch (IllegalArgumentException e){
            System.out.println("Illegal format");//TODO
        }
         */
    }

    /**
     * method for attacking an opponent
     * the if-method is to prevent the opponent from gaining life
     * @param opponent opponent
     */
    public void attack(Unit opponent){
        Terrain defaultTerrain = Terrain.DESERT;
        if ((this.attack + this.getAttackBonus(defaultTerrain)) > (this.armor + this.getResistBonus(defaultTerrain))){
            int opponentHealth = opponent.getHealth() - (this.attack + this.getAttackBonus(defaultTerrain)) + (opponent.getArmor()+ opponent.getResistBonus(defaultTerrain));
            System.out.println(this.getName() + " attacks " + opponent.getName());
            opponent.setHealth(opponentHealth);
        }
    }

    public void attack(Unit opponent, Terrain terrain){
        if ((this.attack + this.getAttackBonus(terrain)) > (this.armor + this.getResistBonus(terrain))){
            int opponentHealth = opponent.getHealth() - (this.attack + this.getAttackBonus(terrain)) + (opponent.getArmor()+ opponent.getResistBonus(terrain));
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
     * toString method
     * @return String
     */
    @Override
    public String toString(){
        return this.getID() + " || Name: " + this.getName() + " || Health: " + this.getHealth() + " || Attack: " + this.getAttack() + " || Armor: " + this.getArmor() + "\n";
    // return this.getID() + " || Name: " + this.getName() + " || Health: " + this.getHealth() + " || Attack: " + this.getAttack() + " (" + this.getAttackBonus() + ") || Armor: " + this.getArmor() + " (" + this.getResistBonus() + ")\n";
        //
    }

    /**
     * abstract class which gets the attack bonus
     */
    public abstract int getAttackBonus(Terrain terrain);

    /**
     * abstract class which gets the resist bonus
     */
    public abstract int getResistBonus(Terrain terrain);

    /**
     * abstract class which gets the type of unit as an identification string
     */
    public abstract String getID();

}
