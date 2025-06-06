package liskovsubstitution.gooddesign;

public class Ostrich extends Bird {

    @Override
    protected void eat() {
        System.out.println("Ostrich is eating");
    }

    // Ostrich cannot fly, so we do not inherit the fly method from FlyingBird
    // This class does not implement a fly method, adhering to Liskov Substitution Principle
}
