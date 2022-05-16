import TestResources.UnitsGnotts;
import WGames.Model.Classes.Army;
import WGames.Model.Classes.UnitFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnitFactoryTest {

    @Test
    public void unitFactoryTest(){
        UnitsGnotts unitsGnotts = new UnitsGnotts();
        UnitFactory unitFactory = new UnitFactory();

        Army army = unitsGnotts.premier();

        for(int i = 0; i < 2; i++){
            army.add(unitFactory.getUnit("RangedUnit", "Geir", 100));
        }

        assertEquals(6, army.getAllUnits().size());



    }


}
