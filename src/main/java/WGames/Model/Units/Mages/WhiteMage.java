package WGames.Model.Units.Mages;

import WGames.Model.Classes.Terrain;
import WGames.Model.Units.Unit;

public class WhiteMage extends Mage {
    /**
     * The constructor of the Unit class
     *
     * @param name   name
     * @param health health
     * @param attack attack
     * @param armor  armor
     * @param mana   mana
     */
    public WhiteMage(String name, int health, int attack, int armor, int mana) throws IllegalArgumentException {
        super(name, health, attack, armor, mana);
    }

    @Override
    public String getID() {
        return "WhiteMage";
    }

    //TODO heal own team

    @Override
    public void attack(Unit companion){
        Terrain defaultTerrain = Terrain.DESERT;
        if ((this.getAttack() + this.getAttackBonus(defaultTerrain)) > (this.getArmor() + this.getResistBonus(defaultTerrain))){
            int opponentHealth = companion.getHealth() - (this.getAttack() + this.getAttackBonus(defaultTerrain)) + (companion.getArmor()+ companion.getResistBonus(defaultTerrain));
            System.out.println(this.getName() + " heals " + companion.getName());
            companion.setHealth(opponentHealth);
        }
    }

    @Override
    public void attack(Unit companion, Terrain terrain){
        if ((this.getAttack() + this.getAttackBonus(terrain)) > (this.getArmor() + this.getResistBonus(terrain))){
            int opponentHealth = companion.getHealth() - (this.getAttack() + this.getAttackBonus(terrain)) + (companion.getArmor()+ companion.getResistBonus(terrain));
            System.out.println(this.getName() + " heals " + companion.getName());
            companion.setHealth(opponentHealth);
        }
    }
}
