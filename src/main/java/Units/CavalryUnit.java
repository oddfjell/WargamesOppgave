package Units;

public class CavalryUnit extends Unit{
    public CavalryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    public CavalryUnit(String name, int health) {
        super(name, health, 20, 12);
    }

    @Override
    public int getAttackBonus(){
        //TODO fiks
        return 2;
    }

    public int getResistBonus(){
        return 1;
    }
}
