package dependencyinversion.gooddesign;

public class PostgreSQL implements Database {

    @Override
    public void save() {
        System.out.println("Saving data to PostgreSQL database");
    }

}
