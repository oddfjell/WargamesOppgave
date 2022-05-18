package WGames.Model.Units.Mages;

import WGames.Model.Classes.Terrain;
import WGames.Model.Units.Unit;

public abstract class Mage extends Unit {

    private int mana;

    /**
     * The constructor of the Unit class
     *
     * @param name   name
     * @param health health
     * @param attack attack
     * @param armor  armor
     * @param mana mana
     */
    public Mage(String name, int health, int attack, int armor, int mana) throws IllegalArgumentException {
        super(name, health, attack, armor);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana){
        this.mana = mana;
    }

    @Override
    public int getAttackBonus(Terrain terrain) {
        if(terrain.equals(Terrain.DESERT)){
            return 12;
        } else if(terrain.equals(Terrain.PLAINS)){
            return 4;
        } else{
            return 8;
        }
    }

    @Override
    public int getResistBonus(Terrain terrain) {
        return 0;
    }

    @Override
    public String toString(){
        return this.getID() + " || Name: " + this.getName() + " || Health: " + this.getHealth() + " || Attack: " + this.getAttack() + " || Armor: " + this.getArmor() + "\n|| Mana: " + this.getMana() + "\n";
    }
}
