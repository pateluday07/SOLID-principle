package liskovsubstitution.gooddesign;

public class Sparrow extends FlyingBird {

    @Override
    protected void eat() {
        System.out.println("Sparrow is eating");
    }

    // Sparrow can fly, so we inherit the fly method from FlyingBird
    // No need to override it here
}
