import WGames.Model.Army;
import WGames.Model.Terrain;
import WGames.Model.Unit;
import WGames.Model.Units.CavalryUnit;
import WGames.Model.Units.CommanderUnit;
import WGames.Model.Units.InfantryUnit;
import WGames.Model.Units.RangedUnit;
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


    /**
     * Exceptions to make a Unit
     */
    @Test(expected = IllegalArgumentException.class)
    public void testExceptionName(){
        Unit rangedUnit = new RangedUnit("",1,1,1);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testExceptionHealth0(){
        Unit rangedUnit = new RangedUnit("Robin Hood",0,1,1);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testExceptionHealthOver500(){
        Unit rangedUnit = new RangedUnit("Robin Hood",501,1,1);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testExceptionAttack0(){
        Unit rangedUnit = new RangedUnit("Robin Hood",1,-0,1);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testExceptionAttackOver100(){
        Unit rangedUnit = new RangedUnit("Robin Hood",1,101,1);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testExceptionArmorNegative(){
        Unit rangedUnit = new RangedUnit("Robin Hood",1,1,-1);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testExceptionArmorOver100(){
        Unit rangedUnit = new RangedUnit("Robin Hood",1,1,101);

    }
}






