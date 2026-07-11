package dependencyinversion.gooddesign;

public class GoodTester {

    public static void main(String[] args) {
        Database mySQLDatabase = new MySQLDatabase();
        DatabaseService mySqlDbService = new DatabaseService(mySQLDatabase);
        mySqlDbService.save();
        mySqlDbService.update();
        mySqlDbService.delete();

        Database postgreSQLDatabase = new PostgresDatabase();
        DatabaseService postgreSqlDbService = new DatabaseService(postgreSQLDatabase);
        postgreSqlDbService.save();
        postgreSqlDbService.update();
        postgreSqlDbService.delete();

    }
}
