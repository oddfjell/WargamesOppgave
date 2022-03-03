import Units.*;

public class UnitsTest {
    public static void main(String[] args) {
        RangedUnit bard = new RangedUnit("Jaskier", 20);
        CavalryUnit mountedForce = new CavalryUnit("Monty", 50);
        CommanderUnit dictator = new CommanderUnit("Borat", 5);
        InfantryUnit christian = new InfantryUnit("The spanish inquisition", 200);

        System.out.println(bard.toString());
        System.out.println(christian.toString());
        System.out.println(bard.getName() + " attacks " + christian.getName() + " 20 times");
        for(int i = 0; i < 20; i++){
            bard.attack(christian);
        }
        System.out.println(christian.getName() + " have " + christian.getHealth() + " HP left");
    }
}
