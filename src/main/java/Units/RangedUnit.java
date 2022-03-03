package Units;

public class RangedUnit extends Unit{
    public RangedUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    public RangedUnit(String name, int health) {
        super(name, health, 15, 8);
    }

    @Override
    public int getAttackBonus(){
        return 3;
    }

    public int getResistBonus(){

    }
}
