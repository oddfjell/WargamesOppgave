import TestResources.UnitsGnotts;
import TestResources.UnitsNotGnotts;
import WGames.Model.Classes.Army;
import WGames.Model.Classes.Battle;
import WGames.Model.Classes.Terrain;
import org.junit.Test;
import static org.junit.Assert.*;

public class BattleTest {


    @Test
    public void battleTest() throws InterruptedException {
        //Battle war = new Battle();
        UnitsNotGnotts unitsNotGnotts = new UnitsNotGnotts();
        UnitsGnotts unitsGnotts = new UnitsGnotts();

        Army notGnotts = unitsNotGnotts.premier();
        Army gnotts = unitsGnotts.premier();

        //war.Battle(notGnotts, gnotts, Terrain.FOREST);
        Battle war = new Battle(notGnotts, gnotts, Terrain.FOREST);
        Army winner = war.simulate();

        assertTrue(winner.getName().equals(notGnotts.getName()) || winner.getName().equals(gnotts.getName()));

        //TODO
       /* Armies armies = new Armies();
        armies.addArmy(gnotts);
        assertEquals(1, armies.listAllArmies().size());*/
    }

    @Test
    public void slowBattleTest() throws InterruptedException {
        //Battle war = new Battle();
        UnitsNotGnotts unitsNotGnotts = new UnitsNotGnotts();
        UnitsGnotts unitsGnotts = new UnitsGnotts();

        Army notGnotts = unitsNotGnotts.premier();
        Army gnotts = unitsGnotts.premier();

        //war.Battle(notGnotts, gnotts, Terrain.FOREST);
        Battle war = new Battle(notGnotts, gnotts, Terrain.FOREST);

        String winner = "";

        while(notGnotts.getAllUnits().size() != 0 && gnotts.getAllUnits().size() != 0){
            if(war.slowSimulate().equals("stalemate")){
                //winner = "none";
                //battleAction.setText(battle.slowSimulate());
                break;
            }
            else {
                war.slowSimulate();
            }
            //battleAction.setText(battle.slowSimulate());
            //updateTables();
        }
        if(notGnotts.getAllUnits().size() == 0 && gnotts.getAllUnits().size() != 0){
            winner = gnotts.getName();
        } else if(gnotts.getAllUnits().size() == 0 && notGnotts.getAllUnits().size() != 0){
            winner = notGnotts.getName();
        } else{
            winner = "none";
        }


        //Army winner = war.simulate();

        assertTrue(winner.equals(notGnotts.getName()) || winner.equals(gnotts.getName()) || winner.equals("none"));

        //TODO
       /* Armies armies = new Armies();
        armies.addArmy(gnotts);
        assertEquals(1, armies.listAllArmies().size());*/
    }
}
