import Classes.*;
import Classes.Units.CommanderUnit;
import Classes.Units.InfantryUnit;
import Classes.Units.RangedUnit;

import java.util.ArrayList;

public class BattleTest {

    /**
     * test which makes an instance of a Battle, makes the army, puts them into the constructor
     * and uses the simulate method to se who wins
     * @param args
     */
    public static void main(String[] args) {
        Battle fight = new Battle();

        ArrayList<Unit> mcuFans = new ArrayList<>();
        Army mcu = new Army("MCUFans", mcuFans);
        ArrayList<Unit> dcFans = new ArrayList<>();
        Army dc = new Army("DCFans", dcFans);

        mcuFans.add(new InfantryUnit("Steve", 30));
        mcuFans.add(new RangedUnit("Wanda", 30));

        dcFans.add(new CommanderUnit("Bruce", 30));
        dcFans.add(new RangedUnit("Robin", 30));

        fight.Battle(dc,mcu);
        System.out.println(fight.simulate().getName() + " won");
    }
}
