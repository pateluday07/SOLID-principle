package dependencyinversion.baddesign;

public class BadTester {

    public static void main(String[] args) {
        DatabaseService databaseService = new DatabaseService();
        databaseService.save();
        databaseService.update();
        databaseService.delete();
    }
}
