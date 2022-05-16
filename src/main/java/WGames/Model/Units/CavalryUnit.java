package WGames.Model.Units;

import WGames.Model.Classes.Terrain;

public class CavalryUnit extends Unit {

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
     * I used int attacking to change the attack bonus value
     * If the unit attacks in the terrain "PLAINS", it gains a little attack bonus
     * @return attackBonus
     */
    int attacking = -1;
    @Override
    public int getAttackBonus(Terrain terrain){
        int plainBonus = 0;
        if(terrain.equals(Terrain.PLAINS)){
            plainBonus = 1;
        }
        attacking++;
        switch (attacking){
            case 0: return 6 + plainBonus;
            default: return 2 + plainBonus;
        }
    }

    /**
     * the abstract method from Unit now has a body
     * If the unit defends in the terrain "FOREST", it gains no resistance bonus
     * @return resistBonus
     */
    @Override
    public int getResistBonus(Terrain terrain){
        if(terrain.equals(Terrain.FOREST)){
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String getID(){
        return "CavalryUnit";
    }

}
