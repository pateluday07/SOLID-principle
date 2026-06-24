package liskovsubstitution;

import liskovsubstitution.baddesign.Bird;
import liskovsubstitution.baddesign.Ostrich;
import liskovsubstitution.baddesign.Sparrow;

public class LiskovSubstitutionBadTester {

    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        simulateBirdLife(sparrow);

        Bird ostrich = new Ostrich();
        simulateBirdLife(ostrich);
    }

    public static void simulateBirdLife(Bird bird) {
        bird.eat();
        bird.fly();
    }

}
