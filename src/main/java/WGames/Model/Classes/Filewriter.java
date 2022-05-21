package WGames.Model.Classes;

import WGames.Dialog.Dialog;
import WGames.Model.Units.Unit;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Filewriter {



    //TODO implement exeptions
    //kan bare velge csv fil fra files

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

        //if(file.endsWith){}
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
                    if(unitStats.length == 3){
                        System.out.println(6);
                        if(!Objects.equals(unitStats[0], "")&& unitStats[2].matches("[0-9]+") && !Objects.equals(unitStats[1], "") && !Objects.equals(unitStats[2], "")){
                            UnitFactory unitFactory = new UnitFactory();
                            u.add(unitFactory.getUnit(unitStats[0], unitStats[1], Integer.parseInt(unitStats[2])));
                            System.out.println(7);
                        }
                    }else{
                        throw new IllegalArgumentException("Illegal format");
                    }
                } else{
                    throw new IllegalArgumentException("Illegal format");
                }
            }
            br.close();
            System.out.println(4);
            //System.out.println(army.getAllUnits());
        }catch(Exception ex){
            Dialog.error(ex);
            return null;
        }
        return army;
    }






    public void writeData(String armyName, Unit unit){

        PrintWriter csvWriter;
        try
        {

            File file = new File("src\\main\\resources\\Files\\" + armyName + ".csv");
            if(!file.exists()){
                file = new File("src\\main\\resources\\Files\\" + armyName + ".csv");
            }
            csvWriter = new  PrintWriter(new FileWriter(file,true));

            String unitInformation = unit.getID() + "," + unit.getName() + "," + unit.getHealth();



            csvWriter.println(unitInformation);

            csvWriter.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    public List<String> copyCSVFile(File file){

        //TODO bedre string

        List<String> theUnits;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            theUnits = br.lines().collect(Collectors.toList());

            theUnits.removeIf(theUnit -> Objects.equals(theUnit, ""));

            br.close();

        }catch(Exception ex){
            return null;
        }
        return theUnits;
    }


    /*public void removeLineFromFile(File file, String remove){
        Army army = makeArmyFromFile(file);

        //List<Unit> unitsList = new ArrayList<>(army.getAllUnits());

        ArrayList<Integer> removeThese = new ArrayList<>();

        int i = 0;
        for(Unit unit:army.getAllUnits()){
            if(remove.trim().toLowerCase().equals((unit.getID() + "," + unit.getName() + "," + unit.getHealth()).trim().toLowerCase())){
                removeThese.add(i);
            }
            i++;
        }

        int j = 0;
        for(Integer integer:removeThese){
            army.getAllUnits().remove(integer - j);
            j++;
        }

        //file.deleteOnExit();
        writeArmyInFile(army);
    }*/





   /*public void removeLineFromFile(String armyName, String lineToRemove) {

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

    /*public void removeLineFromFile(String armyName, String lineToRemove) {
        try {

            File inFile = new File("src\\main\\resources\\Files\\" + armyName + ".csv");

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }


            BufferedReader br = new BufferedReader(new FileReader(inFile));
            //PrintWriter pw = new PrintWriter(new FileWriter(inFile));
            CSVReader csvFileReader = new CSVReader(br);
            CSVIterator csvIterator = new CSVIterator(csvFileReader);
            String line = null;
            List<String> theUnits = br.lines().skip(0).collect(Collectors.toList());



            for (String theUnit : theUnits) {
                System.out.println(theUnit);
                if(!Objects.equals(theUnit, "")){
                    String[] unitStats = theUnit.trim().split(",");
                    System.out.println(6);
                    if(!Objects.equals(unitStats[1], lineToRemove)){
                        System.out.println(7);
                        csvIterator.remove();
                        //pw.println(unitStats[1]);
                        //pw.flush();
                    }
                }
            }




            //List<String> theUnits = br.lines().skip(0).collect(Collectors.toList());


            //Read from the original file and write to the new
            //unless content matches data to be removed.


            //int read = 0;



            //pw.close();
            br.close();
            csvFileReader.close();


        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }

    }*/

    /*public void removeLineFromFile(String armyName, String lineToRemove) {
        try {

            File inFile = new File("src\\main\\resources\\Files\\" + armyName + ".csv");

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }
            BufferedReader br = new BufferedReader(new FileReader(inFile));
            List<String> theUnits = br.lines().skip(0).collect(Collectors.toList());
            List<Integer> rows = new ArrayList<>();
            int rowCount = 1;
            for (String theUnit : theUnits) {
                System.out.println(theUnit);
                if(!Objects.equals(theUnit, "")){
                    String[] unitStats = theUnit.trim().split(",");
                    System.out.println(6);
                    if(!Objects.equals(unitStats[1], lineToRemove)){
                        System.out.println(7);
                        rows.add(rowCount);
                        rowCount++;
                    }
                }else{
                    rowCount++;
                }
            }


            CSVReader reader2 = new CSVReader(new FileReader(inFile));
            List<String[]> allElements = reader2.readAll();
            for (Integer row : rows) {
                allElements.remove(row);
            }
            /*
            for(int i = 0; i < rows.size(); i++){
                allElements.remove(rows.get(i));
            }
            FileWriter sw = new FileWriter(filelocation);
            CSVWriter writer = new CSVWriter(sw);
            writer.writeAll(allElements);
            writer.close();


            reader2.close();
            br.close();



        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }

    }*/
}