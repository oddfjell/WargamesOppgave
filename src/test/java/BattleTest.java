import Units.*;

import java.util.ArrayList;

public class BattleTest {
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
    }
}
