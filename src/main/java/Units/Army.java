package Units;

import java.util.List;

public class Army {
    private String name;
    private List<Unit> units;

    public Army(String name){
        this.name = name;
    }

    public Army(String name, List<Unit> untis){
        this.name = name;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public void add(Unit unit){}
    public void addAll(List<Unit> units){}
    public void remoive(Unit unit){}
    public boolean hasUnits(){}
    public List<Unit> getAllUnits(){}
    public Unit getRandom(){}
    public String toString(){
        return "...";//TODO
    }
    public boolean equals(Object object){}
    public int hashCode(){}
}
