import Units.*;

public class UnitsTest {
    public static void main(String[] args) {
        //test1();
        test2();
        //test3();
    }

    /**
     * test to check if you can make the different units
     */
    public static void test1(){
        RangedUnit bard = new RangedUnit("Jaskier", 20);
        CavalryUnit mountedForce = new CavalryUnit("Monty", 50);
        CommanderUnit dictator = new CommanderUnit("Borat", 5);
        InfantryUnit christian = new InfantryUnit("The spanish inquisition", 200);

        System.out.println(bard.toString());
        System.out.println(mountedForce.toString());
        System.out.println(dictator.toString());
        System.out.println(christian.toString());
    }

    /**
     * test to check if the attack method works
     */
    public static void test2(){
        RangedUnit bard = new RangedUnit("Jaskier", 20);
        InfantryUnit christian = new InfantryUnit("The spanish inquisition", 200);

        for(int i = 0; i < 2; i++){
            bard.attack(christian);
        }
        for(int i = 0; i < 1; i++){
            christian.attack(bard);
        }

        System.out.println(christian.getName() + " have " + christian.getHealth() + " HP left");
        System.out.println(bard.getName() + " have " + bard.getHealth() + " HP left");
        //TODO bard should have 4 resistance bonus on the second attack against it
    }

    /**
     * test to check if mounted force has a bonus on its first attack
     */
    public static void test3(){
        RangedUnit bard = new RangedUnit("Jaskier", 200);
        CavalryUnit mountedForce = new CavalryUnit("Monty", 50);

        for(int i = 0; i < 5; i++){
            System.out.println(bard.toString());
            System.out.println(mountedForce.toString());
            mountedForce.attack(bard);
            System.out.println(bard.getHealth());
        }
    }
}
