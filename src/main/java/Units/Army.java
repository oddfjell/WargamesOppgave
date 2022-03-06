package Units;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Army {
    private String name;
    private List<Unit> units;

    public Army(String name){
        this.name = name;
    }

    public Army(String name, List<Unit> units){
        this.name = name;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public void add(Unit unit){
        units.add(unit);
    }
    public void addAll(List<Unit> units){
        this.units.addAll(units);
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
    /*@Override
    public int hashCode(){
        return
    }*/
}
