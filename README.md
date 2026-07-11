# Dependency Inversion Principle

This package demonstrates the Dependency Inversion Principle (DIP), the `D` in SOLID.

DIP says:

- High-level modules should not depend on low-level modules. Both should depend on abstractions.
- Abstractions should not depend on details. Details should depend on abstractions.

In this example, `DatabaseService` is the high-level module because it contains the application operation: save, update, and delete data. `MySQLDatabase` and `PostgresDatabase` are low-level modules because they contain database-specific details.

## Package Structure

```text
dependencyinversion/
|-- baddesign/
|   |-- BadTester.java
|   |-- DatabaseService.java
|   |-- MySQLDatabase.java
|   `-- PostgresDatabase.java
`-- gooddesign/
    |-- Database.java
    |-- DatabaseService.java
    |-- GoodTester.java
    |-- MySQLDatabase.java
    `-- PostgresDatabase.java
```

## Bad Design

Location: `dependencyinversion.baddesign`

In the bad design, `DatabaseService` directly creates and uses `MySQLDatabase`.

```java
private final MySQLDatabase mySQLDatabase = new MySQLDatabase();
```

This creates tight coupling:

- `DatabaseService` depends on a concrete database class.
- Switching to `PostgresDatabase` requires changing `DatabaseService`.
- Adding another database type requires editing high-level business logic.
- Testing `DatabaseService` is harder because the dependency is created inside the class.

Even though `PostgresDatabase` exists in the package, `DatabaseService` cannot use it without code changes.

## Good Design

Location: `dependencyinversion.gooddesign`

In the good design, `DatabaseService` depends on the `Database` interface.

```java
private final Database database;

public DatabaseService(Database database) {
    this.database = database;
}
```

This follows DIP:

- `DatabaseService` depends on an abstraction, not a concrete database.
- `MySQLDatabase` and `PostgresDatabase` implement the same `Database` interface.
- The required database implementation is passed through constructor injection.
- New database types can be added without modifying `DatabaseService`.

## Class Responsibilities

| Class | Responsibility |
| --- | --- |
| `Database` | Defines the common database operations: `save`, `update`, and `delete`. |
| `DatabaseService` | Uses the `Database` abstraction to perform operations. |
| `MySQLDatabase` | Provides MySQL-specific implementations of database operations. |
| `PostgresDatabase` | Provides PostgreSQL-specific implementations of database operations. |
| `BadTester` | Runs the tightly coupled version. |
| `GoodTester` | Runs the DIP-compliant version with both database implementations. |

## How to Run

From the project root:

```powershell
javac -d out (Get-ChildItem -Recurse src\dependencyinversion -Filter *.java).FullName
```

Run the bad design example:

```powershell
java -cp out dependencyinversion.baddesign.BadTester
```

Run the good design example:

```powershell
java -cp out dependencyinversion.gooddesign.GoodTester
```

## Expected Output

Bad design:

```text
Saving data to MySQL database
Updating data in MySQL database
Deleting data from MySQL database
```

Good design:

```text
Saving data to MySQL database
Updating data in MySQL database
Deleting data from MySQL database
Saving data to PostgreSQL database
Updating data in PostgreSQL database
Deleting data from PostgreSQL database
```

## Key Takeaway

The bad design makes the service depend directly on a specific database implementation. The good design introduces a `Database` abstraction, allowing the service to work with any database implementation that follows the interface. This makes the code easier to extend, test, and maintain.


## Links

[![YouTube](https://img.shields.io/badge/YouTube-ByteAndBeyondWithUday-red?logo=youtube&logoColor=white&style=flat-square)](https://www.youtube.com/@ByteAndBeyondWithUday)