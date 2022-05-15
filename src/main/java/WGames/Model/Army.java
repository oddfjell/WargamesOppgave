package WGames.Model;

import java.util.*;
import java.util.stream.Collectors;

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
        return units.size() > 0;
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
     * method to get a random index which fits the army.size()
     * @return null
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

    /**
     * toString method
     * @return String
     */
    @Override
    public String toString(){
        return this.getName() + ": " + units.size() + " units";
    }

    /**
     * equals method
     * @param o
     * @return true/false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Army army = (Army) o;
        return Objects.equals(name, army.name) && Objects.equals(units, army.units);
    }

    /**
     * hashCode method
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, units);
    }


    /**
     * returns a list of the InfantryUnits of the army
     * @return list
     */
    public List<Unit> getInfantryUnits(){
        return units.stream()
                .filter(unit -> unit.getID().equals("InfantryUnit"))
                .collect((Collectors.toList()));
    }

    /**
     * returns a list of the CavalryUnits of the army
     * @return list
     */
    public List<Unit> getCavalryUnits(){
        return units.stream()
                .filter(unit -> unit.getID().equals("CavalryUnit"))
                .collect((Collectors.toList()));
    }

    /**
     * returns a list of the RangedUnits of the army
     * @return list
     */
    public List<Unit> getRangedUnits(){
        return units.stream()
                .filter(unit -> unit.getID().equals("RangedUnit"))
                .collect((Collectors.toList()));
    }

    /**
     * returns a list of the CommanderUnits of the army
     * @return list
     */
    public List<Unit> getCommanderUnits(){
        return units.stream()
                .filter(unit -> unit.getID().equals("CommanderUnit"))
                .collect((Collectors.toList()));
    }


}
