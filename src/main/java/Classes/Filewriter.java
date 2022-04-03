package Classes;

import Classes.Units.CavalryUnit;
import Classes.Units.CommanderUnit;
import Classes.Units.InfantryUnit;
import Classes.Units.RangedUnit;
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
                    new FileWriter("src\\main\\Files\\" + army.getName() + ".csv"));

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
     * @param armyName
     * @return army
     */
    public Army makeArmyFromFile(String armyName) {
        List<Unit> u = new ArrayList<>();

        Army army = new Army(armyName, u);

        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("src\\main\\Files\\" + armyName + ".csv"));

            List<String> theUnits = br.lines().skip(1).collect(Collectors.toList());

            for (String theUnit : theUnits) {
                String[] unitStats = theUnit.trim().split(",");
                if(unitStats[0].equals("CavalryUnit")){
                    CavalryUnit cavalryUnit = new CavalryUnit(unitStats[1], Integer.parseInt(unitStats[2]));
                    u.add(cavalryUnit);
                } else if(unitStats[0].equals("CommanderUnit")){
                    CommanderUnit commanderUnit = new CommanderUnit(unitStats[1], Integer.parseInt(unitStats[2]));
                    u.add(commanderUnit);
                } else if(unitStats[0].equals("InfantryUnit")) {
                    InfantryUnit infantryUnit = new InfantryUnit(unitStats[1], Integer.parseInt(unitStats[2]));
                    u.add(infantryUnit);
                } else if(unitStats[0].equals("RangedUnit")) {
                    RangedUnit rangedUnit = new RangedUnit(unitStats[1], Integer.parseInt(unitStats[2]));
                    u.add(rangedUnit);
                }
            }
            br.close();
            System.out.println(army.getAllUnits());
        }catch(Exception ex){
            return null;
        }
       return army;
    }
}