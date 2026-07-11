package dependencyinversion.gooddesign;

public class MySQLDatabase implements Database {

    @Override
    public void save() {
        System.out.println("Saving data to MySQL database");
    }

    @Override
    public void update() {
        System.out.println("Updating data in MySQL database");
    }

    @Override
    public void delete() {
        System.out.println("Deleting data from MySQL database");
    }

}
