import WGames.Model.Units.Mages.BlackMage;
import WGames.Model.Units.Mages.WhiteMage;
import WGames.Model.Units.RangedUnit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MageTest {

    @Test
    public void makeMageTest(){
        WhiteMage whiteMage = new WhiteMage("wh", 9, 9, 9, 10);
        BlackMage blackMage = new BlackMage("bl",9,9,9,9);

        assertEquals("BlackMage",blackMage.getID());
        assertEquals("WhiteMage",whiteMage.getID());
    }

    /*@Test
    public void attackBlackMageTest(){
        BlackMage blackMage = new BlackMage("bl",9,9,9,9);
        RangedUnit rangedUnit = new RangedUnit("ra", 15, 1, 1);

        blackMage.attack(rangedUnit);

        assertEquals(1,rangedUnit.getHealth());
    }*/
}
