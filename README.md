# SOLID Principle Examples

This repository contains small Java examples that demonstrate SOLID design principles.

## Interface Segregation Principle

The Interface Segregation Principle says that a class should not be forced to depend on methods it does not use. In practice, this means large "do everything" interfaces should be split into smaller, role-specific interfaces.

The examples are in:

```text
src/interfacesegregation
```

### Bad Design

Package:

```text
interfacesegregation.baddesign
```

Classes:

- `MultifunctionDevice` defines one large interface with `print()`, `scan()`, and `fax()`.
- `SimplePrinter` implements `MultifunctionDevice`, but it only supports printing.
- `BadTester` shows the problem by calling `scan()` and `fax()` on `SimplePrinter`.

Problem:

`SimplePrinter` is forced to implement behavior it does not support. Because of that, its `scan()` and `fax()` methods throw `UnsupportedOperationException`.

```java
public class SimplePrinter implements MultifunctionDevice {
    @Override
    public void print() {
        System.out.println("Printing document...");
    }

    @Override
    public void scan() {
        throw new UnsupportedOperationException("Scanning is not supported by SimplePrinter");
    }

    @Override
    public void fax() {
        throw new UnsupportedOperationException("Faxing is not supported by SimplePrinter");
    }
}
```

This design violates the Interface Segregation Principle because a simple printer should not be required to provide scanning or faxing behavior.

### Good Design

Package:

```text
interfacesegregation.gooddesign
```

Interfaces:

- `Printer` contains only `print()`.
- `Scanner` contains only `scan()`.
- `Fax` contains only `fax()`.

Concrete classes:

- `SimplePrinter` implements only `Printer`.
- `SimpleScanner` implements only `Scanner`.
- `SimpleFax` implements only `Fax`.
- `MultiFunctionPrinter` implements `Printer`, `Scanner`, and `Fax`.
- `GoodTester` shows each class using only the interfaces it needs.

This design follows the Interface Segregation Principle because each class depends only on the behavior it actually supports.

```java
public class SimplePrinter implements Printer {
    @Override
    public void print() {
        System.out.println("Printing document...");
    }
}
```

```java
public class MultiFunctionPrinter implements Printer, Scanner, Fax {
    @Override
    public void print() {
        System.out.println("Printing document...");
    }

    @Override
    public void scan() {
        System.out.println("Scanning document...");
    }

    @Override
    public void fax() {
        System.out.println("Faxing document...");
    }
}
```

### Key Takeaway

Prefer small, focused interfaces over large interfaces that force classes to implement unused methods.

Bad:

```java
public interface MultifunctionDevice {
    void print();
    void scan();
    void fax();
}
```

Good:

```java
public interface Printer {
    void print();
}

public interface Scanner {
    void scan();
}

public interface Fax {
    void fax();
}
```

### Run The Examples

Compile the interface segregation examples:

```powershell
javac -d out src/interfacesegregation/baddesign/*.java src/interfacesegregation/gooddesign/*.java
```

Run the bad design example:

```powershell
java -cp out interfacesegregation.baddesign.BadTester
```

This prints the document and then throws an exception when unsupported scan or fax behavior is called.

Run the good design example:

```powershell
java -cp out interfacesegregation.gooddesign.GoodTester
```

## Links

[![YouTube](https://img.shields.io/badge/YouTube-ByteAndBeyondWithUday-red?logo=youtube&logoColor=white&style=flat-square)](https://www.youtube.com/@ByteAndBeyondWithUday)
