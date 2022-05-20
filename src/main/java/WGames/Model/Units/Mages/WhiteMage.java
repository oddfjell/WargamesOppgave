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
    public WhiteMage(String name, int health, int mana) throws IllegalArgumentException {
        super(name, health, 15, 5, mana);
    }

    public WhiteMage(String name, int health) throws IllegalArgumentException {
        super(name, health, 15, 5, 100);
    }

    @Override
    public String getID() {
        return "WhiteMage";
    }

    //TODO heal own team

    /*@Override
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
    }*/

    @Override
    public void attack(Unit companion){
        Terrain defaultTerrain = Terrain.DESERT;
        int unitHeal = this.getAttack() + this.getAttackBonus(defaultTerrain);

        int heal;
        if(unitHeal < this.getMana()){
            this.setMana(this.getMana() - unitHeal);
            heal = unitHeal;
        }else{
            heal = getMana();
            this.setHealth(0);
        }
        int companionHealth = companion.getHealth() + heal;
        System.out.println(this.getName() + " heals " + companion.getName());
        companion.setHealth(companionHealth);


    }

    @Override
    public void attack(Unit companion, Terrain terrain){
        int unitHeal = this.getAttack() + this.getAttackBonus(terrain);

        int heal;
        if(unitHeal < this.getMana()){
            this.setMana(this.getMana() - unitHeal);
            heal = unitHeal;
        }else{
            heal = getMana();
            this.setHealth(0);
        }
        int companionHealth = companion.getHealth() + heal;
        System.out.println(this.getName() + " heals " + companion.getName());
        companion.setHealth(companionHealth);

    }
}
