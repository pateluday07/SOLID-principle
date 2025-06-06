package dependencyinversion.baddesign;

public class DatabaseService {

    private final MySQLDatabase mySQLDatabase = new MySQLDatabase(); //tight coupling to MySQLDatabase

    public void saveData() {
        mySQLDatabase.save();
    }

}
