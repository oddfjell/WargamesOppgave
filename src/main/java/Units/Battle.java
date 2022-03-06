package Units;

import java.util.ArrayList;
import java.util.Random;

public class Battle {
    private Army armyOne;
    private Army armyTwo;

    public void Battle(Army armyOne, Army armyTwo){
        while(armyOne.getAllUnits().size() != 0 && armyTwo.getAllUnits().size() != 0){

            Random random = new Random();
        /*int attacker;
        int victim;*/

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
            System.out.println(armyTwo.getName() + " won with " + armyTwo.getAllUnits().size() + " troop(s)");
        } else if(armyTwo.getAllUnits().size() == 0){
            System.out.println(armyOne.getName() + " won with " + armyOne.getAllUnits().size() + " troop(s)");
        }




         /*if(whoIsFirst == 0){
           attacker = random.nextInt(armyOne.getAllUnits().size());
            victim = random.nextInt(armyTwo.getAllUnits().size());
            armyOne.getAllUnits().get(attacker).attack(armyTwo.getAllUnits().get(victim));
            armyOne.getRandom().attack(armyTwo.getRandom());
        } else{
            /*attacker = random.nextInt(armyTwo.getAllUnits().size());
            victim = random.nextInt(armyOne.getAllUnits().size());
            armyTwo.getAllUnits().get(attacker).attack(armyOne.getAllUnits().get(victim));
            armyTwo.getRandom().attack(armyOne.getRandom());
        }*/



        //int r = random.nextInt(units.size());
        //return units.get(r);
    }

    public Army simulate(){
        //TODO

        /*
        Simuleringen er relativt enkel: en tilfeldig enhet fra en armé angripe en
tilfeldig enhet fra den andre arméen. Hvis en enhet har helse lik 0 fjernes den fra arméen.
Denne dansen gjentas inntil en av arméene er utslettet. Til slutt returneres seierherren
(armyOne eller armyTwo).
         her er det en ting*/
        return null;
    }

    @Override
    public String toString(){
        //TODO
        return null;
    }
}
