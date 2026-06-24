package liskovsubstitution;

import liskovsubstitution.gooddesign.Bird;
import liskovsubstitution.gooddesign.FlyableBird;
import liskovsubstitution.gooddesign.Ostrich;
import liskovsubstitution.gooddesign.Sparrow;

public class LiskovSubstitutionGoodTester {

    public static void main(String[] args) {
        Bird ostrich = new Ostrich();
        simulateBirdLife(ostrich);

        FlyableBird sparrow = new Sparrow();
        simulateFlyableBirdLife(sparrow);
    }

    public static void simulateBirdLife(Bird bird) {
        bird.eat();
    }

    public static void simulateFlyableBirdLife(FlyableBird bird) {
        bird.eat();
        bird.fly();
    }
}
