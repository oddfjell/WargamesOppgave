package Units;

import java.util.*;

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
        List<Unit> u = new ArrayList<>(units);  //endret fra <Unit>
        u.sort(Comparator.comparing(Unit::toString));
        return u;
    }
    public Unit getRandom(){
        if(units.size() > 0){
            Random random = new Random();
            int r = random.nextInt(units.size());
            return units.get(r);
        }
        else{
            return null;
        }
    }


    @Override
    public String toString(){
        return this.getName() + ": " + units.size() + " units";//TODO
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Army army = (Army) o;
        return Objects.equals(name, army.name) && Objects.equals(units, army.units);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, units);
    }
}
