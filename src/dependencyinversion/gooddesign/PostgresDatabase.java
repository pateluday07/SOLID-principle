package dependencyinversion.gooddesign;

public class PostgresDatabase implements Database {

    @Override
    public void save() {
        System.out.println("Saving data to PostgreSQL database");
    }

    @Override
    public void update() {
        System.out.println("Updating data in PostgreSQL database");
    }

    @Override
    public void delete() {
        System.out.println("Deleting data from PostgreSQL database");
    }

}
