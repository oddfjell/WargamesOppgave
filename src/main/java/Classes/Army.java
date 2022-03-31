package Classes;

import Classes.Units.RangedUnit;

import java.util.*;

public class Army {
    private String name;
    private List<Unit> units;

    /**
     * constructor of army
     * @param name
     */
    public Army(String name){
        this.name = name;
    }

    /**
     * constructor of army with name and list
     * @param name
     * @param units
       */
    public Army(String name, List<Unit> units){
        this.name = name;
        this.units = units;
    }

    /**
     * gets the name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * method to add a unit to the army
     * @param unit
     */
    public void add(Unit unit){
        units.add(unit);
    }

    /**
     * method to add all the units from a certain list to the army
     * @param units
     */
    public void addAll(List<Unit> units){
        this.units.addAll(units);
    }

    /**
     * method to remove a unit from the army
     * @param unit
     */
    public void remove(Unit unit){
        units.remove(unit);
    }

    /**
     * method to check if army has units
     * @return true if army is not empty, false otherwise
     */
    public boolean hasUnits(){
        if(units.size() > 0){
            return true;
        } else {
            return false;
        }
    }

    /**
     * returns a sorted list of the units of the army
     * @return list
     */
    public List<Unit> getAllUnits(){
        List<Unit> u = new ArrayList<>(units);
        u.sort(Comparator.comparing(Unit::toString));
        return u;
    }

    /**
     * method to get a random index wHich fits the army.size()
     * @return
     */
    public Unit getRandom() {
        if (units.size() > 0) {
            Random random = new Random();
            int r = random.nextInt(units.size());
            return units.get(r);
        } else {
            return null;
        }
    }

    @Override
    public String toString(){
        return this.getName() + ": " + units.size() + " units";
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


    public List<Unit> getInfantryUnits(){
        List<Unit> listOfInfantryUnits = new ArrayList<>();
        for(Unit unit:units){
            if(unit.getID() == 2){
                listOfInfantryUnits.add(unit);
            }
        }
        return listOfInfantryUnits;
    }

    public List<Unit> getCavalryUnits(){
        List<Unit> listOfCavalryUnits = new ArrayList<>();
        for(Unit unit:units){
            if(unit.getID() == 0){
                listOfCavalryUnits.add(unit);
            }
        }
        return listOfCavalryUnits;
    }

    public List<Unit> getRangedUnits(){
        List<Unit> listOfRangedUnits = new ArrayList<>();
        for(Unit unit:units){
            if(unit.getID() == 3){
                listOfRangedUnits.add(unit);
            }
        }
        return listOfRangedUnits;
    }

    public List<Unit> getCommanderUnits(){
        List<Unit> listOfCommanderUnit = new ArrayList<>();
        for(Unit unit:units){
            if(unit.getID() == 1){
                listOfCommanderUnit.add(unit);
            }
        }
        return listOfCommanderUnit;
    }
}
