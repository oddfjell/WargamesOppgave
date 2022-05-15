package WGames.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Filewriter {

    /**
     * Method to write an army to a file. The method has an army as its parameter. The BufferedWriter
     * class will write the information in a path with the name of the army. It will write the army name
     * on the first line and the sorted unitsList the other lines.
     * @param army
     */
    public void writeArmyInFile(Army army){
        //if(army.hasUnits())

        try{
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("src\\main\\resources\\Files\\" + army.getName() + ".csv"));

            List<Unit> unitsList = army.getAllUnits().stream()
                    .sorted(Comparator.comparing(Unit::getID).thenComparing(Unit::getName).thenComparing(Unit::getHealth))
                    .collect(Collectors.toList());


            bw.write(army.getName() + "\n");

            for (Unit unit : unitsList) {
                bw.write(unit.getID() + "," + unit.getName() + "," + unit.getHealth() + "\n");

            }

            bw.close();

        }catch (Exception ex){
            return;
        }
    }


    /**
     * Method to make an army from an already existing written army. It uses BufferedReader and checks
     * all the sentences except the first (the army name) to put them into a new army. For each line
     * it will check which unit type to make a new unit of that type.
     * @param //armyName
     * @return army
     */
    /*public Army makeArmyFromFile(String armyName) {
        List<Unit> u = new ArrayList<>();

        Army army = new Army(armyName, u);



        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("src\\main\\resources\\Files\\" + armyName + ".csv"));

            List<String> theUnits = br.lines().skip(1).collect(Collectors.toList());

            for (String theUnit : theUnits) {
                String[] unitStats = theUnit.trim().split(",");
                UnitFactory unitFactory = new UnitFactory();
                u.add(unitFactory.getUnit(unitStats[0], unitStats[1], Integer.parseInt(unitStats[2])));

            }
            br.close();
            System.out.println(army.getAllUnits());
        }catch(Exception ex){
            return null;
        }
       return army;
    }*/

    public Army makeArmyFromFile(File file) {
        List<Unit> u = new ArrayList<>();

        Army army;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String armyName = br.readLine();

            List<String> theUnits = br.lines().skip(0).collect(Collectors.toList());

            army = new Army(armyName, u);

            for (String theUnit : theUnits) {
                String[] unitStats = theUnit.trim().split(",");
                UnitFactory unitFactory = new UnitFactory();
                u.add(unitFactory.getUnit(unitStats[0], unitStats[1], Integer.parseInt(unitStats[2])));

            }
            br.close();
            //System.out.println(army.getAllUnits());
        }catch(Exception ex){
            return null;
        }
        return army;
    }
}