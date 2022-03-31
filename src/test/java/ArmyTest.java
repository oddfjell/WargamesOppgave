import Classes.*;
import Classes.Units.CavalryUnit;
import Classes.Units.CommanderUnit;
import Classes.Units.InfantryUnit;
import Classes.Units.RangedUnit;
import TestResources.UnitsGnotts;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ArmyTest {

    /**
     * testing all the methods from the army class as addAll()
     * test which makes an instance of an Army, makes the troops, puts them into the army
     * and uses the different army methods as addAll(), remove(), add(), getAllUnits(), getRandom()
     * @param args
     */

    /**
     * method to test calculate() //TODO
     */


    //ASSERT
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

    /*@Test
    public void testGetRandom() {
        UnitsGnotts unitsGnotts = new UnitsGnotts();

        ArrayList<Unit> gnotts = unitsGnotts.getSevralGnotts();


    }*///TODO

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

}
