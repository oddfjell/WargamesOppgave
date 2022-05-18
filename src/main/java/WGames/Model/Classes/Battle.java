package WGames.Model.Classes;

import WGames.Model.Units.Unit;

import java.util.Random;

//TODO enum

public class Battle {
    private Army armyOne;
    private Army armyTwo;
    private Terrain terrain;



    public static String battleText = "";


    /**
     * constructor of the battle class
     * @param armyOne
     * @param armyTwo
     * @param terrain
     */
    public Battle(Army armyOne, Army armyTwo, Terrain terrain) throws IllegalStateException{
        //used to be void
        if(!armyOne.getName().trim().equals(armyTwo.getName().trim())){
            this.armyOne = armyOne;
            this.armyTwo = armyTwo;
            this.terrain = terrain;
        } else {
            throw new IllegalStateException("You cannot make an army attack itself");
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
                    arm1.attack(arm2, terrain);
                    if (arm2.getHealth() <= 0) {
                        armyTwo.remove(arm2);
                        System.out.println(arm2.getName() + " (" + armyTwo.getName() + ") died");
                    }
                }
                case 1 -> {
                    arm2.attack(arm1, terrain);
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

    public String slowSimulate(){
        Random random = new Random();

        Unit arm1 = armyOne.getRandom();
        Unit arm2 = armyTwo.getRandom();

        int whoIsFirst = random.nextInt(2);

        switch (whoIsFirst) {
            case 0 -> {
                arm1.attack(arm2, terrain);
                if (arm2.getHealth() <= 0) {
                    armyTwo.remove(arm2);
                    System.out.println(arm2.getName() + " (" + armyTwo.getName() + ") died");
                    return arm1.getName() + " kills " + arm2.getName() + " (" + armyTwo.getName() + ")";
                    //return arm1.getName() + " attacks " + arm2.getName() + "\n" + arm2.getName() + " (" + armyTwo.getName() + ") died";
                }
                return arm1.getName() + " attacks " + arm2.getName();
            }
            case 1 -> {
                arm2.attack(arm1, terrain);
                if (arm1.getHealth() <= 0) {
                    armyOne.remove(arm1);
                    System.out.println(arm1.getName() + " (" + armyOne.getName() + ") died");
                    return arm2.getName() + " kills " + arm1.getName() + " (" + armyOne.getName() + ")";
                    //return arm2.getName() + " attacks " + arm1.getName() + "\n" + arm1.getName() + " (" + armyOne.getName() + ") died";
                }
                return arm2.getName() + " attacks " + arm1.getName();
            }
        }
        return "";
    }

//TODO ha en fast paste simulate med en notepad over hendelsene


    /**
     * toString method
     * @return String
     */
    @Override
    public String toString(){
        return armyOne.toString() + " versus " + armyTwo.toString();
    }
}
