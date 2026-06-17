package liskovsubstitution.gooddesign;

public class Bird {

    protected String name;

    protected Bird(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name.concat(" is eating"));
    }

}
