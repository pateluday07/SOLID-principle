package dependencyinversion.baddesign;

public class MySQLDatabase {

    public void save() {
        System.out.println("Saving data to MySQL database");
    }

    public void update() {
        System.out.println("Updating data in MySQL database");
    }

    public void delete() {
        System.out.println("Deleting data from MySQL database");
    }
}
