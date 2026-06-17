package liskovsubstitution.baddesign;

public class Bird {

    private String name;

    protected Bird(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name.concat(" is eating"));
    }

    public void fly() {
        System.out.println(name.concat(" is flying"));
    }

}
