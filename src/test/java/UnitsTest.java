import Classes.Units.CavalryUnit;
import Classes.Units.CommanderUnit;
import Classes.Units.InfantryUnit;
import Classes.Units.RangedUnit;
import TestResources.UnitsNotGnotts;
import org.junit.Test;
import static org.junit.Assert.*;

public class UnitsTest {

    //TODO make tests so that the coverage is 100%

    @Test
    public void testUnitProperties(){
        UnitsNotGnotts unitsNotGnotts = new UnitsNotGnotts();

        CommanderUnit u = unitsNotGnotts.getDictator();

        assertEquals("Borat", u.getName());
        assertEquals(5, u.getHealth());
        assertEquals(25, u.getAttack());
        assertEquals(15, u.getArmor());
    }


    @Test
    public void testAttack(){
        UnitsNotGnotts unitsNotGnotts = new UnitsNotGnotts();

        RangedUnit u1 = unitsNotGnotts.getBard();
        CavalryUnit u2 = unitsNotGnotts.getMountedForce();
        InfantryUnit u3 = unitsNotGnotts.getChristian();

        u2.attack(u1);
        assertEquals(12, u1.getHealth());
        //bonuses

        u2.attack(u1);
        assertEquals(2, u1.getHealth());
        //bonuses
    }

    @Test
    public void testSetHealth(){
        UnitsNotGnotts unitsNotGnotts = new UnitsNotGnotts();

        RangedUnit u = unitsNotGnotts.getBard();

        u.setHealth(88);

        assertEquals(88, u.getHealth());
    }
}






