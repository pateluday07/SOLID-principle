package liskovsubstitution;

import liskovsubstitution.gooddesign.Bird;
import liskovsubstitution.gooddesign.FlyableBird;
import liskovsubstitution.gooddesign.Ostrich;
import liskovsubstitution.gooddesign.Sparrow;

public class LiskovSubstitutionGoodTester {

    public static void main(String[] args) {
        Bird ostrich = new Ostrich();
        ostrich.eat();

        System.out.println();
        FlyableBird sparrow = new Sparrow();
        sparrow.eat();
        sparrow.fly();
    }
}
