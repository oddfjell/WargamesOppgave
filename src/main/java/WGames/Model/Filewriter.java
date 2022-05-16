package WGames.Model;

import WGames.Model.Units.Unit;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Filewriter {



    //TODO implement exeptions

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
            //noe if her

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


    public Army makeArmyFromFile(File file) {
        List<Unit> u = new ArrayList<>();
        System.out.println(1);

        Army army;


        //TODO fiks
        try {
            System.out.println(2);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String armyName = br.readLine();

            List<String> theUnits = br.lines().skip(0).collect(Collectors.toList());

            army = new Army(armyName, u);
            System.out.println(3);

            for (String theUnit : theUnits) {
                System.out.println(theUnit);
                if(!Objects.equals(theUnit, "")){
                    String[] unitStats = theUnit.trim().split(",");
                    System.out.println(6);
                    if(!Objects.equals(unitStats[0], "")&& unitStats[2].matches("[0-9]+") && !Objects.equals(unitStats[1], "") && !Objects.equals(unitStats[2], "")){
                        UnitFactory unitFactory = new UnitFactory();
                        u.add(unitFactory.getUnit(unitStats[0], unitStats[1], Integer.parseInt(unitStats[2])));
                        System.out.println(7);
                    }
                }
            }
            br.close();
            System.out.println(4);
            //System.out.println(army.getAllUnits());
        }catch(Exception ex){
            return null;
        }
        return army;
    }






    public void writeData(String armyName, String info)
    {
        //TODO bytt ut string info med unit

        PrintWriter csvWriter;
        try
        {

            File file = new File("src\\main\\resources\\Files\\" + armyName + ".csv");
            if(!file.exists()){
                file = new File("src\\main\\resources\\Files\\" + armyName + ".csv");
            }
            csvWriter = new  PrintWriter(new FileWriter(file,true));


            //csvWriter.println(data+","+"hello");
            csvWriter.println(info);


            csvWriter.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }




   /* public void removeLineFromFile(String armyName, String lineToRemove) {

        try {

            File inFile = new File("src\\main\\resources\\Files\\" + armyName + ".csv");

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\Files\\" + armyName + ".csv"));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //List<String> theUnits = br.lines().skip(0).collect(Collectors.toList());
            int numberOfLines = br.lines().skip(0).collect(Collectors.toList()).size();

            //Read from the original file and write to the new
            //unless content matches data to be removed.


            //int read = 0;

            for(int i = 0; i < numberOfLines; i++){
                line = br.readLine();
                if (!line.trim().equals(lineToRemove)) {

                    pw.println(line);
                    pw.flush();
                }
            }


            pw.close();
            br.close();

            //Delete the original file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }*/
}