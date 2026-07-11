package dependencyinversion.baddesign;

public class PostgresDatabase {

    public void save() {
        System.out.println("Saving data to Postgres database");
    }

    public void update() {
        System.out.println("Updating data in Postgres database");
    }

    public void delete() {
        System.out.println("Deleting data from Postgres database");
    }
}
