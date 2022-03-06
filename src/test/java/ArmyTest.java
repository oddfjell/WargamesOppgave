import Units.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArmyTest {
    //TODO

    public static void main(String[] args) {
        Army army = new Army("Gnottene");
        RangedUnit gnott1 = new RangedUnit("Stella", 10);
        CavalryUnit gnott2 = new CavalryUnit("Kaisa", 20);
        InfantryUnit gnott3 = new InfantryUnit("Tander", 5);
        CommanderUnit gnott4 = new CommanderUnit("Sanpler", 1);

        ArrayList<Unit> gnotts = new ArrayList<>();
        gnotts.add(gnott2);
        gnotts.add(gnott3);
        gnotts.add(gnott4);

        army.add(gnott1);
        army.addAll(gnotts);

        System.out.println(army.getAllUnits());



        /*
        Stella, Tander, Sampler og Kaisa
         */

    }
    /*
    public class Army {
    private String name;
    private List<Unit> units;

    public Army(String name){
        this.name = name;
    }

    public Army(String name, List<Unit> untis){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Unit unit){
        units.add(unit);
    }
    public void addAll(List<Unit> units){
        //units.add(units);
        //TODO forstå spørsmålet
    }
    public void remove(Unit unit){
        units.remove(unit);
    }
    public boolean hasUnits(){
        if(units.size() > 0){
            return true;
        } else {
            return false;
        }
        //TODO skjekk
    }
    public List<Unit> getAllUnits(){
        List<Unit> u = new ArrayList<Unit>(units);
        u.sort(Comparator.comparing(Unit::toString));
        return u;
    }
    public Unit getRandom(){
        Random random = new Random(units.size() - 1);
        int rand = random.nextInt();
        return units.get(rand);
    }


    @Override
    public String toString(){
        return this.getName() + ": " + units.size() + " units";//TODO
    }
    @Override
    public boolean equals(Object object){
        if (object == this){
            return true;
        } else {
            return false;
        }
        //TODO skjekk
    }
    @Override
    public int hashCode(){
        return
    }
}

     */
}
