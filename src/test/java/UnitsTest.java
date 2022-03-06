import Units.*;

public class UnitsTest {
    public static void main(String[] args) {
        RangedUnit bard = new RangedUnit("Jaskier", 20);
        CavalryUnit mountedForce = new CavalryUnit("Monty", 50);
        CommanderUnit dictator = new CommanderUnit("Borat", 5);
        InfantryUnit christian = new InfantryUnit("The spanish inquisition", 200);

        System.out.println(bard.toString());
        System.out.println(christian.toString());
        System.out.println(bard.getName() + " attacks " + christian.getName() + " 2 times");
        for(int i = 0; i < 2; i++){
            bard.attack(christian);
        }
        for(int i = 0; i < 1; i++){
            christian.attack(bard);
        }
        System.out.println(christian.getName() + " have " + christian.getHealth() + " HP left");
        System.out.println(bard.getName() + " have " + bard.getHealth() + " HP left");
    }
}
