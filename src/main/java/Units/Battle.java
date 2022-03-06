package Units;

import java.util.ArrayList;
import java.util.Random;

public class Battle {
    private Army armyOne;
    private Army armyTwo;

    public void Battle(Army armyOne, Army armyTwo){
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
    }

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
            //System.out.println(armyTwo.getName() + " won with " + armyTwo.getAllUnits().size() + " troop(s)");
        } else{
            return armyOne;
            //System.out.println(armyOne.getName() + " won with " + armyOne.getAllUnits().size() + " troop(s)");
        }
    }

    @Override
    public String toString(){
        return armyOne.toString() + " versus " + armyTwo.toString();
    }
}
