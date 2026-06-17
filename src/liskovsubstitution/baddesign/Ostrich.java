package liskovsubstitution.baddesign;

public class Ostrich extends Bird {

    private static final String NAME = "Ostrich";

    public Ostrich() {
        super(NAME);
    }

    // Ostriches cannot fly, so we override the fly method to throw an exception
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostriches cannot fly");
    }

}
