package dependencyinversion.gooddesign;

public class DatabaseService {

    //loose coupling to Database interface
    private final Database database; // Use the Database interface for dependency injection

    public DatabaseService(Database database) {
        this.database = database; // Constructor injection
    }

    public void saveData() {
        database.save(); // Call the save method on the injected database instance
    }

}
