import Classes.Army;
import Classes.Filewriter;
import TestResources.UnitsNotGnotts;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class FilewriterTest {

    @Test
    public void writeArmyFromFileTest(){
        Filewriter filewriter = new Filewriter();
        UnitsNotGnotts unitsNotGnotts = new UnitsNotGnotts();

        filewriter.writeArmyInFile(unitsNotGnotts.premier());

        List<String> theUnits;

        try{
            BufferedReader br = new BufferedReader(
                    new FileReader("src\\main\\Files\\f4.csv"));

            theUnits = br.lines().collect(Collectors.toList());
            br.close();
        }catch (Exception ex){
            return;
        }


        File file = new File("src\\main\\Files\\f4.csv");

        assertTrue(file.isFile());
        assertEquals(unitsNotGnotts.premier().getAllUnits().size() + 1, theUnits.size());

        file.delete();
    }

    @Test
    public void makeArmyFromFileTest(){
        Filewriter filewriter = new Filewriter();

        Army army = filewriter.makeArmyFromFile("testArmy");

        assertEquals(army.getName(), "testArmy");
        assertEquals(6, army.getAllUnits().size());



    }


}