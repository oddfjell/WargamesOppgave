import Classes.*;
import TestResources.UnitsGnotts;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class ArmyTest {

    //TODO make tests so that the coverage is 100%

    @Test
    public void testAddToArmy() {
        UnitsGnotts unitsGnotts = new UnitsGnotts();

        ArrayList<Unit> gnotts = unitsGnotts.getGnotts();

        gnotts.add(unitsGnotts.getGnott1());
        assertEquals(1, gnotts.size());

        gnotts.add(unitsGnotts.getGnott1());
        assertEquals(2, gnotts.size());
    }

    @Test
    public void testAddAllToArmy() {
        UnitsGnotts unitsGnotts = new UnitsGnotts();

        ArrayList<Unit> gnotts = unitsGnotts.getGnotts();

        gnotts.addAll(unitsGnotts.getSevralGnotts());
        assertEquals(4, gnotts.size());

        gnotts.addAll(unitsGnotts.getSevralGnotts());
        assertEquals(8, gnotts.size());
    }

    @Test
    public void testRemoveFromArmy() {
        UnitsGnotts unitsGnotts = new UnitsGnotts();

        ArrayList<Unit> gnotts = unitsGnotts.getSevralGnotts();

        gnotts.remove(0);
        assertEquals(3, gnotts.size());

        gnotts.remove(1);
        assertEquals(2, gnotts.size());
    }


    @Test
    public void testHasUnits() {
        UnitsGnotts unitsGnotts = new UnitsGnotts();

        assertTrue(unitsGnotts.premier().hasUnits());

        assertFalse(unitsGnotts.deuxieme().hasUnits());
    }

    @Test
    public void testGetInfantryUnits(){
        UnitsGnotts unitsGnotts = new UnitsGnotts();

        assertEquals(1,unitsGnotts.premier().getInfantryUnits().size());
    }

    @Test
    public void testGetCommanderUnits(){
        UnitsGnotts unitsGnotts = new UnitsGnotts();

        assertEquals(1,unitsGnotts.premier().getCommanderUnits().size());
    }

    @Test
    public void testCavalryUnits(){
        UnitsGnotts unitsGnotts = new UnitsGnotts();

        assertEquals(1,unitsGnotts.premier().getCavalryUnits().size());
    }

    @Test
    public void testGetRangedUnits(){
        UnitsGnotts unitsGnotts = new UnitsGnotts();

        Filewriter filewriter = new Filewriter();

        assertEquals(1,unitsGnotts.premier().getRangedUnits().size());
    }
}
