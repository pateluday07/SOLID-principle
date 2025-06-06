package liskovsubstitution.baddesign;

public class Ostrich extends Bird {

    @Override
    protected void eat() {
        System.out.println("Ostrich is eating");
    }

    // Ostriches cannot fly, so we override the fly method to throw an exception
    @Override
    protected void fly() {
        throw new UnsupportedOperationException("Ostriches cannot fly");
    }
}
