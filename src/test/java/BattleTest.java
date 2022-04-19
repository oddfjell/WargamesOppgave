import Classes.*;
import TestResources.UnitsGnotts;
import TestResources.UnitsNotGnotts;
import org.junit.Test;
import static org.junit.Assert.*;

public class BattleTest {


    @Test
    public void battleTest(){
        Battle war = new Battle();
        UnitsNotGnotts unitsNotGnotts = new UnitsNotGnotts();
        UnitsGnotts unitsGnotts = new UnitsGnotts();

        Army notGnotts = unitsNotGnotts.premier();
        Army gnotts = unitsGnotts.premier();

        war.Battle(notGnotts, gnotts, war.terrains[2]);
        Army winner = war.simulate();

        assertTrue(winner.getName().equals(notGnotts.getName()) || winner.getName().equals(gnotts.getName()));
    }
}
