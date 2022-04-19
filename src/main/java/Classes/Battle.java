package Classes;

import java.util.ArrayList;
import java.util.Random;

//TODO enum

public class Battle {
    private Army armyOne;
    private Army armyTwo;

    private String terrain;

    public final String[] terrains ={"FOREST", "HILL", "PLAINS"};

    /**
     * constructor of the battle class
     * @param armyOne
     * @param armyTwo
     */
    public void Battle(Army armyOne, Army armyTwo, String terrain){
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
        if(terrain.equals("PLAINS") || terrain.equals("HILL") || terrain.equals("FOREST")){//TODO
            this.terrain = terrain.toUpperCase().trim();
        }

    }

    /**
     * method to get a random army to attack a random hostile unit with their own random unit
     * the simulation loops the random process until an army does not have any more units
     * then it returns the victor team
     * @return the victorious army
     */
    public Army simulate(){
        while(armyOne.getAllUnits().size() != 0 && armyTwo.getAllUnits().size() != 0){

            Random random = new Random();

            Unit arm1 = armyOne.getRandom();
            Unit arm2 = armyTwo.getRandom();

            int whoIsFirst = random.nextInt(2);

            switch (whoIsFirst) {
                case 0 -> {
                    arm1.attack(arm2);
                    if (arm2.getHealth() <= 0) {
                        armyTwo.remove(arm2);
                        System.out.println(arm2.getName() + " (" + armyTwo.getName() + ") died");
                    }
                }
                case 1 -> {
                    arm2.attack(arm1);
                    if (arm1.getHealth() <= 0) {
                        armyOne.remove(arm1);
                        System.out.println(arm1.getName() + " (" + armyOne.getName() + ") died");
                    }
                }
            }
        }

        if (armyOne.getAllUnits().size() == 0){
            return armyTwo;
        } else{
            return armyOne;
        }
    }

    /**
     * toString method
     * @return String
     */
    @Override
    public String toString(){
        return armyOne.toString() + " versus " + armyTwo.toString();
    }
}
