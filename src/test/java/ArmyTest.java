import Units.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArmyTest {

    /**
     * testing all the methods from the army class as addAll()
     * @param args
     */
    public static void main(String[] args) {

        ArrayList<Unit> gnotts = new ArrayList<>();
        ArrayList<Unit> gnotts2 = new ArrayList<>();
        Army army = new Army("Gnottene", gnotts);

        System.out.println(army.hasUnits());

        RangedUnit gnott1 = new RangedUnit("Stella", 10);
        CavalryUnit gnott2 = new CavalryUnit("Kaisa", 20);
        InfantryUnit gnott3 = new InfantryUnit("Tander", 5);
        CommanderUnit gnott4 = new CommanderUnit("Sanpler", 1);

        gnotts2.add(gnott2);
        gnotts2.add(gnott3);
        gnotts2.add(gnott4);

        army.add(gnott1);
        army.addAll(gnotts2);

        System.out.println(army.getAllUnits());

        army.remove(gnott2);
        System.out.println(army.getAllUnits());

        System.out.println(army.hasUnits());

        System.out.println("\n"+ army.getRandom().toString());
    }
}
