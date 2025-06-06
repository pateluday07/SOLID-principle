package dependencyinversion.gooddesign;

public class MySQLDatabase implements Database {

    @Override
    public void save() {
        System.out.println("Saving data to MySQL database");
    }

}
