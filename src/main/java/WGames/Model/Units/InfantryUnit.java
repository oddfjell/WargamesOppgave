package WGames.Model.Units;

import WGames.Model.Terrain;

public class InfantryUnit extends Unit {

    /**
     * Constructor of the InfantryUnit class
     * @param name
     * @param health
     * @param attack
     * @param armor
     */
    public InfantryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Constructor of the InfantryUnit class with defined values for attack and armor
     * @param name
     * @param health
     */
    public InfantryUnit(String name, int health) {
        super(name, health, 15, 10);
    }

    /**
     * the abstract method from Unit has now a body
     * If the unit attacks in the terrain "FOREST", it gains a little attack bonus
     * @return attackBonus
     */
    @Override
    public int getAttackBonus(Terrain terrain){
        if(terrain.equals(Terrain.FOREST)){
            return 3;
        } else{
            return 2;
        }
    }

    /**
     * the abstract method from Unit has now a body
     * If the unit defends in the terrain "FOREST", it gains a little resistance bonus
     * @return resistBonus
     */
    @Override
    public int getResistBonus(Terrain terrain){
        if(terrain.equals(Terrain.FOREST)){
            return 2;
        } else{
            return 1;
        }
    }

    @Override
    public String getID(){
        return "InfantryUnit";
    }

}
