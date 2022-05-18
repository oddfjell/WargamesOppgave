package WGames.Model.Units.Mages;

import WGames.Model.Classes.Terrain;
import WGames.Model.Units.Unit;

public class BlackMage extends Mage {
    /**
     * The constructor of the Unit class
     *
     * @param name   name
     * @param health health
     * @param attack attack
     * @param armor  armor
     * @param mana   mana
     */
    public BlackMage(String name, int health, int attack, int armor, int mana) throws IllegalArgumentException {
        super(name, health, attack, armor, mana);
    }

    @Override
    public String getID() {
        return "BlackMage";
    }

    @Override
    public void attack(Unit opponent){
        Terrain defaultTerrain = Terrain.DESERT;
        int unitAttack = this.getAttack() + this.getAttackBonus(defaultTerrain);
        if (unitAttack > (this.getArmor() + this.getResistBonus(defaultTerrain))){
            int manaAttack;
            if(unitAttack < this.getMana()){
                this.setMana(this.getMana() - unitAttack);
                manaAttack = unitAttack;
            }else{
                manaAttack = getMana();
                this.setMana(0);
            }
            int opponentHealth = opponent.getHealth() - manaAttack + (opponent.getArmor()+ opponent.getResistBonus(defaultTerrain));
            System.out.println(this.getName() + " attacks " + opponent.getName());
            opponent.setHealth(opponentHealth);
        }
    }

    @Override
    public void attack(Unit opponent, Terrain terrain){
        int unitAttack = this.getAttack() + this.getAttackBonus(terrain);
        if (unitAttack > (this.getArmor() + this.getResistBonus(terrain))){
            int manaAttack;
            if(unitAttack < this.getMana()){
                this.setMana(this.getMana() - unitAttack);
                manaAttack = unitAttack;
            }else{
                manaAttack = getMana();
                this.setMana(0);
            }
            int opponentHealth = opponent.getHealth() - manaAttack + (opponent.getArmor()+ opponent.getResistBonus(terrain));
            System.out.println(this.getName() + " attacks " + opponent.getName());
            opponent.setHealth(opponentHealth);
        }
    }
}
