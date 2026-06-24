# Liskov Substitution Principle (LSP)

The **Liskov Substitution Principle** states that objects of a superclass should be replaceable with objects of its subclasses without breaking the correctness of the program.

In other words: if code works with a base type, it should keep working when you pass any valid subtype — without special-case checks, surprises, or runtime failures.

## The Classic Problem: Birds That Cannot Fly

This module uses the well-known **bird hierarchy** example:

- Every **sparrow** can fly.
- An **ostrich** is a bird, but it cannot fly.

The question is how to model this in a way that respects LSP.

## Bad Design (`baddesign`)

```
Bird
 ├── Sparrow
 └── Ostrich  (overrides fly() to throw UnsupportedOperationException)
```

Here, `Bird` declares a `fly()` method that all birds are expected to support. `Sparrow` works fine, but `Ostrich` violates the contract by throwing an exception:

```java
Bird ostrich = new Ostrich();
ostrich.fly(); // throws UnsupportedOperationException
```

### Why this violates LSP

Any code that accepts a `Bird` and calls `fly()` assumes all birds can fly. Substituting an `Ostrich` for a `Bird` breaks that assumption. Callers must now know the concrete type or wrap calls in try/catch — a sign the abstraction is wrong.

## Good Design (`gooddesign`)

```
Bird
 ├── Ostrich
 └── FlyableBird
      └── Sparrow
```

Flying is moved to a separate abstraction. `Bird` only defines behavior shared by all birds (e.g. `eat()`). `FlyableBird` extends `Bird` and adds `fly()` for birds that actually fly.

```java
Bird ostrich = new Ostrich();
ostrich.eat(); // works — Ostrich is a valid Bird

FlyableBird sparrow = new Sparrow();
sparrow.eat();
sparrow.fly(); // fly() is only on FlyableBird, not forced on every Bird
```

### Why this respects LSP

- `Ostrich` can be substituted anywhere a `Bird` is expected.
- `Sparrow` can be substituted anywhere a `FlyableBird` (or `Bird`) is expected.
- No subclass weakens or breaks the contract of its parent.

## Project Structure

```
liskovsubstitution/
├── baddesign/
│   ├── Bird.java          # Base class with eat() and fly()
│   ├── Sparrow.java       # Flying bird
│   └── Ostrich.java       # Overrides fly() to throw
├── gooddesign/
│   ├── Bird.java          # Base class with eat() only
│   ├── FlyableBird.java   # Adds fly() for birds that can fly
│   ├── Sparrow.java       # Extends FlyableBird
│   └── Ostrich.java       # Extends Bird (no fly())
├── LiskovSubstitutionBadTester.java   # Demonstrates the violation
├── LiskovSubstitutionGoodTester.java  # Demonstrates the fix
└── README.md
```

## Running the Examples

From the project root, compile and run either tester:

```bash
# Bad design — Ostrich breaks the Bird contract
javac -d out src/liskovsubstitution/baddesign/*.java src/liskovsubstitution/LiskovSubstitutionBadTester.java
java -cp out liskovsubstitution.LiskovSubstitutionBadTester

# Good design — subtypes honor their contracts
javac -d out src/liskovsubstitution/gooddesign/*.java src/liskovsubstitution/LiskovSubstitutionGoodTester.java
java -cp out liskovsubstitution.LiskovSubstitutionGoodTester
```

### Expected Output

**Bad design:**

```
Sparrow is eating
Sparrow is flying

Ostrich is eating
Ostriches cannot fly
```

**Good design:**

```
Ostrich is eating

Sparrow is eating
Sparrow is flying
```

## Key Takeaways

| Violation sign | Better approach |
|---|---|
| Subclass throws `UnsupportedOperationException` | Split the hierarchy; put the behavior only on types that support it |
| Callers check `instanceof` before calling a method | Use a more specific interface or base class |
| Subclass method does nothing or returns a sentinel value | Favor composition or separate abstractions over forced inheritance |

LSP is not just about inheritance syntax — it is about **behavioral substitutability**. Subtypes must honor the expectations set by their supertypes.
