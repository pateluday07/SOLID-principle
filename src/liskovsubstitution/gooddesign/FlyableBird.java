package liskovsubstitution.gooddesign;

public class FlyableBird extends Bird {

    protected FlyableBird(String name) {
        super(name);
    }

    public void fly() {
        System.out.println(name.concat(" is flying"));
    }

}
