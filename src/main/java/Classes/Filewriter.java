package Classes;

import TestResources.UnitsGnotts;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Filewriter {

    /*public static void main(String[] args) {
        try{
        BufferedWriter bw = new BufferedWriter(
                new FileWriter("C:\\Users\\annma\\Wargames\\src\\main\\Files\\output.txt"));
        bw.write("karen\n");
        bw.write("chad\n");
        bw.write("becky\n");
        bw.close();
        }catch (Exception ex){
            return;
        }

        try{
            BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\annma\\Wargames\\src\\main\\Files\\output.txt"));
            String s;
            while((s = br.readLine()) != null){
                System.out.println(s);
            }
            br.close();
        }catch (Exception ex){
            return;
        }

        try{
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("C:\\Users\\annma\\Wargames\\src\\main\\Files\\output-copy.txt"));
            BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\annma\\Wargames\\src\\main\\Files\\output.txt"));
            String s;
            while((s = br.readLine()) != null){
                bw.write(s + "\n");
            }
            br.close();
            bw.close();
        }catch (Exception ex){
            return;
        }



    }*/

    public void writeArmyInFile(Army army){
        try{
            /*BufferedWriter bw = new BufferedWriter(
                    new FileWriter("C:\\Users\\annma\\Wargames\\src\\main\\Files\\test1.txt"));
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("C:\\Users\\annma\\Wargames\\src\\main\\Files\\" + army.getName() + ".csv"));*/

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("src\\main\\Files\\" + army.getName() + ".csv"));


            List<Unit> unitsList = army.getAllUnits().stream()
                    .sorted(Comparator.comparing(Unit::getID).thenComparing(Unit::getName).thenComparing(Unit::getHealth))
                    .collect(Collectors.toList());

            //unit -> unit.getName()

            bw.write(army.getName() + "\n");

            for (Unit unit : unitsList) {
                bw.write(unit.getID() + "," + unit.getName() + "," + unit.getHealth() + "\n");

            }

            bw.close();

        }catch (Exception ex){
            return;
        }
    }


    public void writeArmyFromFile(Army army){
        try{
            BufferedReader br = new BufferedReader(
                    new FileReader("src\\main\\Files\\" + army.getName() + ".csv"));
            String s;
            while((s = br.readLine()) != null){
                System.out.println(s);
            }
            br.close();
        }catch (Exception ex){
            return;
        }
    }
}
