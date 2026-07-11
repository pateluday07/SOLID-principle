package dependencyinversion.baddesign;

public class DatabaseService {

    private final MySQLDatabase mySQLDatabase = new MySQLDatabase(); //tight coupling to MySQLDatabase

    public void save() {
        mySQLDatabase.save();
    }

    public void update() {
        mySQLDatabase.update();
    }

    public void delete() {
        mySQLDatabase.delete();
    }

}
