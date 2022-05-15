import TestResources.UnitsGnotts;
import TestResources.UnitsNotGnotts;
import WGames.Model.Armies;
import WGames.Model.Army;
import WGames.Model.Battle;
import WGames.Model.Terrain;
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

        war.Battle(notGnotts, gnotts, Terrain.FOREST);
        Army winner = war.simulate();

        assertTrue(winner.getName().equals(notGnotts.getName()) || winner.getName().equals(gnotts.getName()));

        //TODO
        Armies armies = new Armies();
        armies.addArmy(gnotts);
        assertEquals(1, armies.listAllArmies().size());
    }
}
