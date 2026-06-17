package liskovsubstitution;

import liskovsubstitution.baddesign.Bird;
import liskovsubstitution.baddesign.Ostrich;
import liskovsubstitution.baddesign.Sparrow;

public class LiskovSubstitutionBadTester {

    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        sparrow.eat();
        sparrow.fly();

        System.out.println();
        Bird ostrich = new Ostrich();
        ostrich.eat();
        try {
            ostrich.fly();
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }



    }
}
